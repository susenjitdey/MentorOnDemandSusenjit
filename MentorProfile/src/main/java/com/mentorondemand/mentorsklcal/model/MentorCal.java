/**
 * 
 */
package com.mentorondemand.mentorsklcal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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

	@NotBlank
	private String mid;

	@NotBlank
	private Date start_date;

	@NotBlank
	private Date end_date;

	public MentorCal(Long id, @NotBlank String mid, @NotBlank Date start_date, @NotBlank Date end_date) {
		this.id = id;
		this.mid = mid;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
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

}
