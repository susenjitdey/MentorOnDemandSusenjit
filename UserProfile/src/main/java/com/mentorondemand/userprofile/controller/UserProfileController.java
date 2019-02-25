/**
 * 
 */
package com.mentorondemand.userprofile.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

		UserProfileEntity _userProfileEntity = userRepositorydao.save(new UserProfileEntity(
				userProfileEntity.getActive(), userProfileEntity.getContactnumber(), userProfileEntity.getFirstname(),
				userProfileEntity.getLastname(), userProfileEntity.getPassword(), userProfileEntity.getReg_code(),
				userProfileEntity.getReg_datetime(), userProfileEntity.getUsername()));
		// Customer _customer = repository.save(new Customer(customer.getName(),
		// customer.getAge()));
		return _userProfileEntity;
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
	
	@GetMapping("/getUser")
	public List<UserProfileEntity> getUser() {
		
		return userRepositorydao.findAll();
		
	}
	
	@GetMapping("/signup")
	public List<UserProfileEntity> signup() {
		
		return userRepositorydao.findAll();
		
	}
	
	@GetMapping("/confirmUser")
	public List<UserProfileEntity> confirmUser() {
		
		return userRepositorydao.findAll();
		
	}
	
	@GetMapping("/blockUser")
	public List<UserProfileEntity> blockUser() {
		
		return userRepositorydao.findAll();
		
	}
	
//input
	//id
	
	//output
	//UserDetails
	//No usage of other microservices.
	

}
