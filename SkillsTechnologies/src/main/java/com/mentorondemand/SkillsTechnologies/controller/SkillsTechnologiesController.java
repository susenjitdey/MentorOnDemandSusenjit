/**
 * 
 */
package com.mentorondemand.SkillsTechnologies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.SkillsTechnologies.repositorydao.SkillsTechnologiesRepositorydao;

/**
 * @author javaibm04
 *
 */
@RestController
@RequestMapping("/skillstech")
public class SkillsTechnologiesController {
	
	@Autowired
	SkillsTechnologiesRepositorydao skillsTechnologiesRepositorydao;
	
	
	
	@GetMapping("/Skill")
	public List<SkillsTechnologiesRepositorydao>getSkill(){
		
		return null;//TODO
	}
	
	@GetMapping("/SearchSkill")
	public List<SkillsTechnologiesRepositorydao>searchSkills(){
		
		return null;//TODO
	}
	
	


	//Input
	/*
	 * id searchString
	 */
//Output
	/*
	 * Skill Matching skills array
	 */
//Note: If search string is empty retrieve all Skills

}
