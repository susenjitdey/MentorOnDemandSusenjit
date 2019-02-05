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

/**
 * @author javaibm04
 *
 */
@RestController
@RequestMapping("/mentorcal")
public class MentorCalendarController {
	
	@Autowired
	MentorCalRepositoryDao calRepositoryDao;
	
	@GetMapping("/MentorSkills")
	public List<MentorCalRepositoryDao>getMentorSkills(){
		
		return null;//TODO
	}

}
