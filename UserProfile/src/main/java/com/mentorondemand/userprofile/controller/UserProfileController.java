/**
 * 
 */
package com.mentorondemand.userprofile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.userprofile.model.UserProfileEntity;

/**
 * @author javaibm04
 *
 */
@RestController
@RequestMapping("/api")
public class UserProfileController {
	
	@Autowired
	UserProfileEntity userProfileEntity;

}
