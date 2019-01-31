/**
 * 
 */
package com.mentorondemand.SkillsTechnologies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.SkillsTechnologies.model.SkillsTechnologiesEntity;

/**
 * @author javaibm04
 *
 */
@RestController
@RequestMapping("/skillstech")
public class SkillsTechnologiesController {
	
	@Autowired
	SkillsTechnologiesEntity skillsTechnologiesEntity;

}
