/**
 * 
 */
package com.mentorondemand.userprofile.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.userprofile.model.UserProfileEntity;
import com.mentorondemand.userprofile.repositorydao.UserRepositorydao;

/**
 * @author javaibm04
 *
 */
@RestController
@RequestMapping("/user")
public class UserProfileController {

	@Autowired
	UserRepositorydao userRepositorydao;

	@GetMapping("/allUsers")
	public List<UserProfileEntity> getAllUsers() {
		System.out.println("get all Users");

		List<UserProfileEntity> userProfileEntities = new ArrayList<>();
		userRepositorydao.findAll().forEach(userProfileEntities::add);
		return userProfileEntities;

	}

	@PostMapping(value = "/user/create")
	public UserProfileEntity createUser(@RequestBody UserProfileEntity userProfileEntity) {

		System.out.println("Creating User::::");
		UserProfileEntity _userProfileEntity = userRepositorydao.save(new UserProfileEntity(
				userProfileEntity.getActive(), userProfileEntity.getContactnumber(), userProfileEntity.getFirstname(),
				userProfileEntity.getLastname(), userProfileEntity.getPassword(), userProfileEntity.getReg_code(),
				userProfileEntity.getReg_datetime(), userProfileEntity.getUsername()));

		return _userProfileEntity;
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<UserProfileEntity> findUserById(@PathVariable("id") long id) {
		System.out.println("Fetching User Details::::");

		Optional<UserProfileEntity> userProfileEntities = userRepositorydao.findById(id);

		if (userProfileEntities.isPresent()) {
			UserProfileEntity _userProfileEntities = userProfileEntities.get();

			return new ResponseEntity<>(_userProfileEntities, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/user/update/{id}")
	public ResponseEntity<UserProfileEntity> updateUser(@PathVariable("id") long id,
			@RequestBody UserProfileEntity userProfileEntity) {
		System.out.println("Update User with ID = " + id + "...");

		Optional<UserProfileEntity> userProfileEntities = userRepositorydao.findById(id);

		if (userProfileEntities.isPresent()) {
			UserProfileEntity _userProfileEntitys = userProfileEntities.get();
			_userProfileEntitys.setActive(userProfileEntity.getActive());
			_userProfileEntitys.setContactnumber(userProfileEntity.getContactnumber());
			_userProfileEntitys.setFirstname(userProfileEntity.getFirstname());
			_userProfileEntitys.setLastname(userProfileEntity.getLastname());
			_userProfileEntitys.setReg_code(userProfileEntity.getReg_code());
			_userProfileEntitys.setPassword(userProfileEntity.getPassword());
			_userProfileEntitys.setUsername(userProfileEntity.getUsername());

			return new ResponseEntity<>(_userProfileEntitys, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<UserProfileEntity> deleteUser(@PathVariable("id") long id,
			@RequestBody UserProfileEntity userProfileEntity) {
		System.out.println("Delete User with ID = " + id + "...");
		//
		Optional<UserProfileEntity> userProfileEntities = userRepositorydao.findById(id);
		
			userRepositorydao.deleteById(id);
			return new ResponseEntity<>(userProfileEntity, HttpStatus.OK);

			
	}

	@GetMapping("/blockUser")
	public List<UserProfileEntity> blockUser() {

		return userRepositorydao.findAll();

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
