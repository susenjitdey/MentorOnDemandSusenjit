/**
 * 
 */
package com.mentorondemand.trainings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.trainings.repositorydao.TrainingsRepositoryDao;

/**
 * @author javaibm04
 *
 */
@RestController
@RequestMapping("/trainings")
public class TrainingsController {
	
	@Autowired
	TrainingsRepositoryDao trainingsRepositoryDao;
	
	@GetMapping("/TrainingDetails")
	public List<TrainingsRepositoryDao> getTrainingDetails(){
		
		return null;//TODO
	}
	
	@GetMapping("/TrainingCompleted")
	public List<TrainingsRepositoryDao> getCompletedTrainings(){
		
		return null;//TODO
	}
	
	@GetMapping("/TrainingInProgress")
	public List<TrainingsRepositoryDao> getUnderProgressTrainings(){
		return null;//TODO
		
	}
	
	@GetMapping("/TrainingCreate")
	public List<TrainingsRepositoryDao> createTraining(){
		return null;//TODO
		
		
	}
	
	@GetMapping("/TrainingProposed")
	public List<TrainingsRepositoryDao> proposeTraining(){
		return null;//TODO
		
		
	}
	
	@GetMapping("/TrainingApproved")
	public List<TrainingsRepositoryDao> approveTraining(){
		return null;//TODO
		
		
	}
	
	@GetMapping("/TrainingFinalized")
	public List<TrainingsRepositoryDao> finalizeTraining(){
		return null;//TODO
		
		
	}
	
	
	//Inputs
	
	/*
	 * username or user_id username or user_id training_id training_id training_id
	 */

	//Output refer with the excel.
	/*
	 * List of Trainings objects 
	 * List of Trainings objects Training object which got
	 * created Training object with changed state Training object with changed state
	 * & including payment details Training object
	 */
//Other microserives:
	/*
	 * getMentor, getSkill getMentor, getSkill
	 */

}
