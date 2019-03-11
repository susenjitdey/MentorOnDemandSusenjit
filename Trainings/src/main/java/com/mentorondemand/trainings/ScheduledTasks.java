package com.mentorondemand.trainings;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import com.mentorondemand.trainings.model.Trainings;
import com.mentorondemand.trainings.model.Mentor;
import com.mentorondemand.trainings.model.TrainingStatus;
import com.mentorondemand.trainings.repositorydao.MentorRepositoryDao;
import com.mentorondemand.trainings.repositorydao.TrainingsRepositoryDao;

public class ScheduledTasks {
	
	 private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

	    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	    
		@Autowired
		TrainingsRepositoryDao trainingRepository;	
		
		@Autowired
		MentorRepositoryDao mentorRepository;	
//		0 0 12 * * ?
//		0 * * * * ?
		@Transactional
	    @Scheduled(cron = "0 0 12 * * ?")
	    public void scheduleTaskWithCronExpression() {
			logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
	        List<Trainings> trainingList = trainingRepository.findByStatus(TrainingStatus.STARTED);
	        logger.info("Cron Task :: Found trainings in progress - {}", trainingList.size());
	        for (Trainings trainings : trainingList) {
	        	if (trainings.getProgress() < 100) {
	        		trainings.setProgress(trainings.getProgress() + 5);
	        		trainingRepository.save(trainings);
	        		if (trainings.getProgress() == 100) {
	    				//send payment to mentor
	            		trainings.setStatus(TrainingStatus.COMPLETED);
	            		trainingRepository.save(trainings);
	            		Mentor mentor = mentorRepository.getOne(trainings.getMentor().getId());
	            		mentor.setTrainingsDelivered(mentor.getTrainingsDelivered() + 1);
	            		mentorRepository.save(mentor);
	            	} else if (trainings.getProgress() == 25 || trainings.getProgress() == 50 || trainings.getProgress() == 75) {
	            		//send payment to mentor
	            	}
	        	}      	
			}
	    }


}
