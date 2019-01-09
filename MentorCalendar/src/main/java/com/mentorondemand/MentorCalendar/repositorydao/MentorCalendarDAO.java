/**
 * 
 */
package com.mentorondemand.MentorCalendar.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentorondemand.MentorCalendar.model.MentorCalendarEntity;


/**
 * @author javaibm04
 *
 */
public interface MentorCalendarDAO extends JpaRepository<MentorCalendarEntity, Long>{

}
