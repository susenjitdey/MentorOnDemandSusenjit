/**
 * 
 */
package com.mentorondemand.trainings.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;
/**
 * @author javaibm04
 *
 */
@Entity
@Table(name = "trainings")
public class TrainingsEntity implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mentor_id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long skill_id;
	
	@NotBlank
	private String status;
	
	@NotBlank
	private String rating;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date start_date;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date end_date;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date start_time;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date end_time;
	
	@NotBlank
	private Long amount_received;
	
	@NotBlank
	private String progress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getMentor_id() {
		return mentor_id;
	}

	public void setMentor_id(Long mentor_id) {
		this.mentor_id = mentor_id;
	}

	public Long getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(Long skill_id) {
		this.skill_id = skill_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public Long getAmount_received() {
		return amount_received;
	}

	public void setAmount_received(Long amount_received) {
		this.amount_received = amount_received;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}


}
