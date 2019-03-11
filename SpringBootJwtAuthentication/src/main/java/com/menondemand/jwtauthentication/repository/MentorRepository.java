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
    Optional<Mentor> findByUsername(String username);
    Boolean existsByUsername(String username);
    List<Mentor> findBySkillsNameContainingAndStartTimeLessThanAndEndTimeGreaterThan(String name, int startTime, int endTime);
    
//    @Query("SELECT a.username, a.years_exp FROM mentor a, mentor_skills b, \r\n" + 
//    		"skills c where a.id = b.mentor_id and b.skill_id = c.id \r\n" + 
//    		"and c.name = (:skillName)")
//    List<Mentor> findBySkill(@Param("skillName") String skillName);
}
