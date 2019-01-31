/**
 * 
 */
package com.mentorondemand.userprofile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
		
		return userRepositorydao.findAll();
		
	}

}
