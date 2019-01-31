/**
 * 
 */
package com.mentorondemand.mentorsklcal.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.mentorsklcal.model.MentorCal;

/**
 * @author javaibm04
 *
 */
@Repository
public interface MentorCalRepositoryDao extends JpaRepository<MentorCal, Long>{

}
