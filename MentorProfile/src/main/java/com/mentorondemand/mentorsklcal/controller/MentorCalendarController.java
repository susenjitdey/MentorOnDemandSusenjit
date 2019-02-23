/**
 * 
 */
package com.mentorondemand.mentorsklcal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.mentorsklcal.repositorydao.MentorCalRepositoryDao;
import com.mentorondemand.mentorsklcal.repositorydao.MentorSkillRepositoryDao;

/**
 * @author javaibm04
 *
 */
@RestController
@RequestMapping("/mentorcal")
public class MentorCalendarController {
	
	@Autowired
	MentorCalRepositoryDao calRepositoryDao;
	
	@GetMapping("/MentorCalendar/{mentorId}")
	public List<MentorSkillRepositoryDao>getMentorCalendar(){
		System.out.println("get Mentor Calendar");
		return null;//TODO
	}
	
	@GetMapping("/CheckMentorAvailability/{mentorId}")
	public List<MentorSkillRepositoryDao>checkMentorAvailability(){
		
		return null; //TODO
	}

}
