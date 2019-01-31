/**
 * 
 */
package com.mentorondemand.mentorsklcal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author javaibm04
 *
 */

@Entity
@Table(name = "MentorCal")
public class MentorCal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*
	 *  mid start_time end_time start_date end_date
	 */


}
