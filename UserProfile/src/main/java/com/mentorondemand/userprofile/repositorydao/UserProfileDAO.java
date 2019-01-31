/**
 * 
 */
package com.mentorondemand.userprofile.repositorydao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.userprofile.model.UserProfileEntity;
/**
 * @author javaibm04
 *
 */
@Repository
@RestController
@RequestMapping()
public interface UserProfileDAO extends JpaRepository<UserProfileEntity, Long>{

}
