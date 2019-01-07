/**
 * 
 */
package com.mentorondemand.skills.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.skills.model.SkillsEntity;


/**
 * @author javaibm04
 *
 */
@Repository
public interface SkillsDAO extends JpaRepository<SkillsEntity, Long> {

}
