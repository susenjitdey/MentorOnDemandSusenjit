package com.menondemand.jwtauthentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menondemand.jwtauthentication.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    //Boolean existsByUsernameAndCCode(String username, String ccode);
    Optional<User> findByUsernameAndConfirmCode(String username, String confirmCode);
    Optional<User> findByUsernameAndActive(String username, boolean active);
    
    //findByUsernameAndActive(String username, boolean active);
    
   /* @Query("SELECT p FROM User p WHERE p.username = :username and p.cCode = :ccode")
    List<User> findUsernameCCode(@Param("username") String username, @Param("ccode") String ccode);
    
    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.cCode ='' where u.username=:username")
    int updateCCode(@Param("username") String username);*/
}