/**
 * 
 */
package com.mentorondemand.trainings.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;

import  com.mentorondemand.trainings.model.TrainingsEntity;

/**
 * @author javaibm04
 *
 */
public interface TrainingsDAO extends JpaRepository<TrainingsEntity, Long> {

}
