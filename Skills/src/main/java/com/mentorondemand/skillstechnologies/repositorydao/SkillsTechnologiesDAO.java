/**
 * 
 */
package com.mentorondemand.skillstechnologies.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.skillstechnologies.model.SkillsTechnologiesEntity;


/**
 * @author javaibm04
 *
 */
@Repository
public interface SkillsTechnologiesDAO extends JpaRepository<SkillsTechnologiesEntity, Long> {

}
