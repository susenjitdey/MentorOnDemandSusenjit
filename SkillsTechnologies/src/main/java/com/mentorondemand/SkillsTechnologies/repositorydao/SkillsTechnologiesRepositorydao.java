/**
 * 
 */
package com.mentorondemand.SkillsTechnologies.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.SkillsTechnologies.model.SkillsTechnologiesEntity;


/**
 * @author javaibm04
 *
 */
@Repository
public interface SkillsTechnologiesRepositorydao extends JpaRepository<SkillsTechnologiesEntity, Long>{

}
