/**
 * 
 */
package com.mentorondemand.MentorCalendar.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

/**
 * @author javaibm04
 *
 */
@Entity
@Table(name = "mentorcalendartable")
public class MentorCalendarEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MENTOR_CALENDAR_ID")
	private Long id;
	
	@NotNull
	@Column(name = "MENTOR_ID")
	private Long mid;
	
	@Convert(converter = LocalDateTimeConverter.class)
	@Column(name = "START_TIME")
	private LocalDateTime start_time;
	
	@Convert(converter = LocalDateTimeConverter.class)
	@Column(name = "END_TIME")
	private LocalDateTime end_time;
	
	@Convert(converter = LocalDateTimeConverter.class)
	@Column(name = "START_DATE")
	private LocalDateTime start_date;
	
	@Convert(converter = LocalDateTimeConverter.class)
	@Column(name = "END_DATE")
	private LocalDateTime end_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public LocalDateTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}

	public LocalDateTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalDateTime end_time) {
		this.end_time = end_time;
	}

	public LocalDateTime getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDateTime start_date) {
		this.start_date = start_date;
	}

	public LocalDateTime getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDateTime end_date) {
		this.end_date = end_date;
	}

	

}
