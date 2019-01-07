/**
 * 
 */
package com.mentorondemand.skills.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mentorondemand.skills.model.SkillsEntity;


/**
 * @author javaibm04
 *
 */
public interface SkillsDAO extends JpaRepository<SkillsEntity, Long> {

}
