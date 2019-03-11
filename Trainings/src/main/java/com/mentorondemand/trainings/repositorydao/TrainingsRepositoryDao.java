/**
 * 
 */
package com.mentorondemand.trainings.repositorydao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.trainings.model.TrainingStatus;
import com.mentorondemand.trainings.model.Trainings;

/**
 * @author javaibm04
 *
 */
@Repository
public interface TrainingsRepositoryDao extends JpaRepository<Trainings, Long>{
	//List<Mentor> findByMentors(List skill);
		List<Trainings> findByMentorId(long mentorid);
		List<Trainings> findByUserId(Long userid);
		List<Trainings> findByStatus(TrainingStatus status);

}
