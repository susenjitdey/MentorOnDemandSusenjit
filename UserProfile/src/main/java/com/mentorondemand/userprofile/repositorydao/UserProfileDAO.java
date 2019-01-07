/**
 * 
 */
package com.mentorondemand.userprofile.repositorydao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.userprofile.model.UserProfileEntity;
/**
 * @author javaibm04
 *
 */
@Repository
public interface UserProfileDAO extends JpaRepository<UserProfileEntity, Long>{

}
