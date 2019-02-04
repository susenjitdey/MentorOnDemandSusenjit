/**
 * 
 */
package com.mentorondemand.trainings.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author javaibm04
 *
 */
@RestController
@RequestMapping("/trainings")
public class TrainingsController {
	
	//Endpoints and other infos
	
	/*
	 * Trainings MicroService endpoints 
	 * getCompletedTrainings
	 * getUnderProgressTrainings createTraining proposeTraining, approveTraining
	 * finalizeTraining getTrainingDetails
	 */
	
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
