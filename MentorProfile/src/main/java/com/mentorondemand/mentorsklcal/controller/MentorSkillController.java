/**
 * 
 */
package com.mentorondemand.mentorsklcal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	
	@GetMapping("/MentorCalendar")
	public List<MentorSkillRepositoryDao>getMentorCalendar(){
		
		return null;//TODO
	}
	
	@GetMapping("/CheckMentorAvailability")
	public List<MentorSkillRepositoryDao>checkMentorAvailability(){
		
		return null; //TODO
	}


}
