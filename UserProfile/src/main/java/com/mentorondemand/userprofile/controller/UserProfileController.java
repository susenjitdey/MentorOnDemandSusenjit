/**
 * 
 */
package com.mentorondemand.userprofile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.userprofile.model.UserProfileEntity;
import com.mentorondemand.userprofile.rep.RepMessage;
import com.mentorondemand.userprofile.repositorydao.UserRepositorydao;
import com.mentorondemand.userprofile.req.BlockUser;

/**
 * @author javaibm04
 *
 */
@RestController
@RequestMapping("/user")
public class UserProfileController {

	@Autowired
	UserRepositorydao userRepositorydao;

	/*
	 * @GetMapping("/allUsers") public List<UserProfileEntity> getAllUsers() {
	 * System.out.println("get all Users");
	 * 
	 * List<UserProfileEntity> userProfileEntities = new ArrayList<>();
	 * userRepositorydao.findAll().forEach(userProfileEntities::add); return
	 * userProfileEntities;
	 * 
	 * }
	 * 
	 * @PostMapping(value = "/user/create") public UserProfileEntity
	 * createUser(@RequestBody UserProfileEntity userProfileEntity) {
	 * 
	 * System.out.println("Creating User::::"); UserProfileEntity _userProfileEntity
	 * = userRepositorydao.save(new UserProfileEntity(
	 * userProfileEntity.getActive(), userProfileEntity.getContactnumber(),
	 * userProfileEntity.getFirstname(), userProfileEntity.getLastname(),
	 * userProfileEntity.getPassword(), userProfileEntity.getReg_code(),
	 * userProfileEntity.getReg_datetime(), userProfileEntity.getUsername()));
	 * 
	 * return _userProfileEntity; }
	 * 
	 * @GetMapping("/getUser/{id}") public ResponseEntity<UserProfileEntity>
	 * findUserById(@PathVariable("id") long id) {
	 * System.out.println("Fetching User Details::::");
	 * 
	 * Optional<UserProfileEntity> userProfileEntities =
	 * userRepositorydao.findById(id);
	 * 
	 * if (userProfileEntities.isPresent()) { UserProfileEntity _userProfileEntities
	 * = userProfileEntities.get();
	 * 
	 * return new ResponseEntity<>(_userProfileEntities, HttpStatus.OK); } else {
	 * return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
	 * 
	 * }
	 * 
	 * @PutMapping("/user/update/{id}") public ResponseEntity<UserProfileEntity>
	 * updateUser(@PathVariable("id") long id,
	 * 
	 * @RequestBody UserProfileEntity userProfileEntity) {
	 * System.out.println("Update User with ID = " + id + "...");
	 * 
	 * Optional<UserProfileEntity> userProfileEntities =
	 * userRepositorydao.findById(id);
	 * 
	 * if (userProfileEntities.isPresent()) { UserProfileEntity _userProfileEntitys
	 * = userProfileEntities.get();
	 * _userProfileEntitys.setActive(userProfileEntity.getActive());
	 * _userProfileEntitys.setContactnumber(userProfileEntity.getContactnumber());
	 * _userProfileEntitys.setFirstname(userProfileEntity.getFirstname());
	 * _userProfileEntitys.setLastname(userProfileEntity.getLastname());
	 * _userProfileEntitys.setReg_code(userProfileEntity.getReg_code());
	 * _userProfileEntitys.setPassword(userProfileEntity.getPassword());
	 * _userProfileEntitys.setUsername(userProfileEntity.getUsername());
	 * 
	 * return new ResponseEntity<>(_userProfileEntitys, HttpStatus.OK); } else {
	 * return new ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 * 
	 * @DeleteMapping("/user/delete/{id}") public ResponseEntity<UserProfileEntity>
	 * deleteUser(@PathVariable("id") long id,
	 * 
	 * @RequestBody UserProfileEntity userProfileEntity) {
	 * System.out.println("Delete User with ID = " + id + "..."); //
	 * Optional<UserProfileEntity> userProfileEntities =
	 * userRepositorydao.findById(id);
	 * 
	 * userRepositorydao.deleteById(id); return new
	 * ResponseEntity<>(userProfileEntity, HttpStatus.OK);
	 * 
	 * 
	 * }
	 */

	@PostMapping("/block")
	public ResponseEntity<?> blockUser(@RequestBody BlockUser blockUserRequest) {
		UserProfileEntity user = userRepositorydao.findByUsername(blockUserRequest.getUsername())
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User not found."));

		user.setActive(false);
		userRepositorydao.save(user);

		return new ResponseEntity<>(new RepMessage("User blocked!"), HttpStatus.OK);
	}

	@PostMapping("/unblock")
	public ResponseEntity<?> UnblockUser(@RequestBody BlockUser blockUserRequest) {
		System.out.println("=========== here");
		UserProfileEntity user = userRepositorydao.findByUsername(blockUserRequest.getUsername())
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User not found."));

		user.setActive(true);
		userRepositorydao.save(user);

		return new ResponseEntity<>(new RepMessage("User Un-blocked!"), HttpStatus.OK);
	}

	@GetMapping("/testString")
	public String getTestString() {

		return "Hello USerAm Working";

	}

	/*
	 * @GetMapping("/login") public List<UserProfileEntity> login() {
	 * 
	 * return userRepositorydao.findAll();
	 * 
	 * }
	 */

	/*
	 * @GetMapping("/login") public List<UserProfileEntity> login() {
	 * 
	 * return userRepositorydao.findAll();
	 * 
	 * }
	 */

	/*
	 * @GetMapping("/signup") public List<UserProfileEntity> signup() {
	 * 
	 * return userRepositorydao.findAll();
	 * 
	 * }
	 * 
	 * @GetMapping("/confirmUser") public List<UserProfileEntity> confirmUser() {
	 * 
	 * return userRepositorydao.findAll();
	 * 
	 * }
	 */

}
