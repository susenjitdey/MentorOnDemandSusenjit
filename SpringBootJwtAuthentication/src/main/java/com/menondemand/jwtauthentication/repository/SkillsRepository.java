package com.menondemand.jwtauthentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.mentor.model.Skills;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {
    Optional<Skills> findByName(String skillName);
    //List<Mentor> findByMentors(List skill);
}

