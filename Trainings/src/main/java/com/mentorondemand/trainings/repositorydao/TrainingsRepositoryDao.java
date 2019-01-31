/**
 * 
 */
package com.mentorondemand.trainings.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.trainings.model.Trainings;

/**
 * @author javaibm04
 *
 */
@Repository
public interface TrainingsRepositoryDao extends JpaRepository<Trainings, Long>{

}
