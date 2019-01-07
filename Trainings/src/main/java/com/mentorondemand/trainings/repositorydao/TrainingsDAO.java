/**
 * 
 */
package com.mentorondemand.trainings.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import  com.mentorondemand.trainings.model.TrainingsEntity;

/**
 * @author javaibm04
 *
 */
@Repository
public interface TrainingsDAO extends JpaRepository<TrainingsEntity, Long> {

}
