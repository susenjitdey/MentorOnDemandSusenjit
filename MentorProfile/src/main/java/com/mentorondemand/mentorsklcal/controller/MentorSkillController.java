/**
 * 
 */
package com.mentorondemand.mentorsklcal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.mentorsklcal.model.MentorSkill;
import com.mentorondemand.mentorsklcal.repositorydao.MentorSkillRepositoryDao;

/**
 * @author javaibm04
 *
 */
@RestController
@RequestMapping("/mentorskill")
public class MentorSkillController {

	@Autowired
	MentorSkillRepositoryDao mentorSkillRepositoryDao;

	@GetMapping("/mentorSkills/{mentorId}")
	public List<MentorSkill> getMentorSkills(@PathVariable("mentorId") long mentorId) {

		List<MentorSkill> mentorSkills = new ArrayList<>();
		mentorSkillRepositoryDao.findById(mentorId);
		return mentorSkills;
	}

	@PutMapping("/mskill/update/{mid}/{sid}")
	public ResponseEntity<MentorSkill> updateSkill(@PathVariable("mid") long mid, @PathVariable("sid") long sid,
			@RequestBody MentorSkill mentorSkill) {
		System.out.println("Update Mentor Skill with mentorId = " + mid + " and skillId = " + sid);

		Optional<MentorSkill> mentorSkills = mentorSkillRepositoryDao.findById(mid);

		if (mentorSkills.isPresent()) {
			MentorSkill _mentorSkills = mentorSkills.get();
			_mentorSkills.setYears_of_exp(mentorSkill.getYears_of_exp());
			_mentorSkills.setTrainings_delivered(mentorSkill.getTrainings_delivered());

			return new ResponseEntity<>(_mentorSkills, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
