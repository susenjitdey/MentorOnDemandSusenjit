/**
 * 
 */
package com.mentorondemand.mentorsklcal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.mentorsklcal.model.MentorSkill;
import com.mentorondemand.mentorsklcal.repositorydao.MentorCalRepositoryDao;
import com.mentorondemand.mentorsklcal.repositorydao.MentorSkillRepositoryDao;

/**
 * @author javaibm04
 *
 */
@RestController
@RequestMapping("/mentorskill")
public class MentorSkillController {
	
	@Autowired
	MentorSkillRepositoryDao  mentorSkillRepositoryDao;
	
	
	@GetMapping("/MentorSkills/{mentorId}")
	public List<MentorSkill>getMentorSkills(@PathVariable("mentorId") long mentorId){
		
		List<MentorSkill> mentorSkills = new ArrayList<>();
		mentorSkillRepositoryDao.findById(mentorId);
		return mentorSkills;
	}
	


}
