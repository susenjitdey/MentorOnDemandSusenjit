/**
 * 
 */
package com.mentorondemand.SkillsTechnologies.model;

import java.util.Currency;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author javaibm04
 *
 */
@Entity
@Table(name = "skillstechtable")
public class SkillsTechnologiesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String skillname;
	
	//TOC
	
	@NotBlank
	private DateTimeFormat duration;
	
	@NotBlank
	private String prerequites;
	
	@NotBlank
	private Currency price;

	public Currency getPrice() {
		return price;
	}

	public void setPrice(Currency price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillname() {
		return skillname;
	}

	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}

	public DateTimeFormat getDuration() {
		return duration;
	}

	public void setDuration(DateTimeFormat duration) {
		this.duration = duration;
	}

	public String getPrerequites() {
		return prerequites;
	}

	public void setPrerequites(String prerequites) {
		this.prerequites = prerequites;
	}

	
	

}
