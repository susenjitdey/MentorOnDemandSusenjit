/**
 * 
 */
package com.mentorondemand.mentorsklcal.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.mentorsklcal.model.MentorSkill;

/**
 * @author javaibm04
 *
 */
@Repository
public interface MentorSkillRepositoryDao extends JpaRepository<MentorSkill, Long>{

}
