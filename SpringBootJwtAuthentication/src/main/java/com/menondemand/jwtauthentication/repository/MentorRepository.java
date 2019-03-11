/**
 * 
 */
package com.menondemand.jwtauthentication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.mentor.model.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
	
	
    Optional<Mentor> findByUsername();
    Boolean existsByUsername(String username);
    List<Mentor> findBySkillsNameContainingAndStartTimeLessThanAndEndTimeGreaterThan(String name, int startTime, int endTime);
    

}
