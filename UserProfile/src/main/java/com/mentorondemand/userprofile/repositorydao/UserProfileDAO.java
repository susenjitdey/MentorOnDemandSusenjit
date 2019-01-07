/**
 * 
 */
package com.mentorondemand.userprofile.repositorydao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mentorondemand.userprofile.model.UserProfileEntity;
/**
 * @author javaibm04
 *
 */
public interface UserProfileDAO extends JpaRepository<UserProfileEntity, Long>{

}
