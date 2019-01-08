/**
 * 
 */
package com.mentorondemand.searchskillsandmentor.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.searchskillsandmentor.model.SkillsMentorEntity;


/**
 * @author javaibm04
 *
 */
@Repository
public interface SkillsMentorDAO extends JpaRepository<SkillsMentorEntity, Long> {

}
