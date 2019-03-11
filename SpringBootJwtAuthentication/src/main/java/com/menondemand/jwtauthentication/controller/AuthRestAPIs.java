package com.menondemand.jwtauthentication.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.mentor.model.Mentor;
import com.ibm.mentor.model.Skills;
import com.menondemand.jwtauthentication.message.request.LoginForm;
import com.menondemand.jwtauthentication.message.request.MentorSignUp;
import com.menondemand.jwtauthentication.message.request.SignUpForm;
import com.menondemand.jwtauthentication.message.response.JwtResponse;
import com.menondemand.jwtauthentication.message.response.ResponseMessage;
import com.menondemand.jwtauthentication.model.Role;
import com.menondemand.jwtauthentication.model.RoleName;
import com.menondemand.jwtauthentication.model.User;
import com.menondemand.jwtauthentication.repository.MentorRepository;
import com.menondemand.jwtauthentication.repository.RoleRepository;
import com.menondemand.jwtauthentication.repository.SkillsRepository;
import com.menondemand.jwtauthentication.repository.UserRepository;
import com.menondemand.jwtauthentication.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	@Qualifier("edooka")
	public MailSender mailSender;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SkillsRepository skillsRepository;
	
	@Autowired
	MentorRepository mentorRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		if(userRepository.findByUsernameAndActive(loginRequest.getUsername(), true).isPresent()) {
			return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
		} else {
			return new ResponseEntity<>(new ResponseMessage("User is pending email verification!"),
					HttpStatus.BAD_REQUEST);
		}		
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}
		
		String confirmCode = randomAlphaNumeric(6);

		// Creating user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()), confirmCode);

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			case "mentor":
				Role mentorRole = roleRepository.findByName(RoleName.ROLE_MENTOR)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(mentorRole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userRepository.save(user);
		
		//send email with confirmation code in Hyper link
		String from = "mentorservice22@gmail.com";
		String to = signUpRequest.getEmail(); //get this email from db
		String subject = "Please Verify your Email";
		String body = "Click on link below to verify your account \n http://localhost:8080/api/auth/user?ccode="+confirmCode+"&username="+signUpRequest.getUsername();
		
		mailSender.sendMail(from, to, subject, body);

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
	
	@PostMapping("/mentor/signup")
	public ResponseEntity<?> registerMentor(@Valid @RequestBody MentorSignUp signUpRequest) {
		if (mentorRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating new mentor
		Mentor mentor = new Mentor(signUpRequest.getUsername()
								, signUpRequest.getLinkedin()
								, signUpRequest.getYearsExp(),
								signUpRequest.getStartTime(),
								signUpRequest.getEndTime(),
								signUpRequest.getFee());

		Set<String> strSkills = signUpRequest.getSkills();
		Set<Skills> skills = new HashSet<>();
		
		strSkills.forEach(skill -> {
			Skills mentorSkill = skillsRepository.findByName(skill).orElseGet(() -> skillsRepository.save(new Skills(skill)));
			skills.add(mentorSkill);
		});

		mentor.setSkills(skills);
		mentorRepository.save(mentor);
		
		String confirmCode = randomAlphaNumeric(6);
		
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getLinkedin(),
				encoder.encode(signUpRequest.getPassword()), confirmCode);
		Role mentorRole = roleRepository.findByName(RoleName.ROLE_MENTOR).get();
		Set<Role> roles = new HashSet<>();
		roles.add(mentorRole);
		user.setRoles(roles);
		
		userRepository.save(user);	
		
		String from = "mentorservice22@gmail.com";
		String to = signUpRequest.getLinkedin();
		String subject = "Please Verify your Email";
		String body = "Click on link below to verify your account \n http://localhost:8080/api/auth/user?ccode="+confirmCode+"&username="+signUpRequest.getUsername();
		
		mailSender.sendMail(from, to, subject, body);
			
		return new ResponseEntity<>(new ResponseMessage("Mentor registered successfully!"), HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> confirmSignup(@RequestParam("ccode") String ccode, @RequestParam("username") String username) {

		if(userRepository.findByUsernameAndConfirmCode(username, ccode).isPresent()) {
			
			User user = userRepository.findByUsername(username).get();
			user.setActive(true);
			userRepository.save(user);
			
			return new ResponseEntity<>(new ResponseMessage("User verification successful! You may now login"), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ResponseMessage("Unable to Verify your account. Please contact System Administrator."), HttpStatus.OK);
		}
	}
	
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	/*
	 * //HTTP GET
	 * 
	 * @RequestMapping(value="user", method = RequestMethod.GET)
	 * public @ResponseBody String confirmSignup(@RequestParam("ccode") String
	 * ccode,
	 * 
	 * @RequestParam("username") String username ){ //validate if ccode and username
	 * confirms List<User> lu = userRepository.findUsernameCCode(username, ccode);
	 * 
	 * String status = ""; //if match return confirmed if(lu.size()>0) //check if
	 * condition need to be improved { //Update ccode to empty in database
	 * userRepository.updateCCode(username); status = "Confirmed"; } else //else
	 * return could not confirm { status =
	 * "Unable to Confirm. Pls check with Admin"; }
	 * 
	 * return status; }
	 */
}