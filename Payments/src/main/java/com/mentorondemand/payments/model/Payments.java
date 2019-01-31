/**
 * 
 */
package com.mentorondemand.payments.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * @author javaibm04
 *
 */

@Entity
@Table(name = "Payments")
public class Payments {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Long mentor_id;
	
	@NotNull
	private Long training_id;
	
	private String txn_type;
	
	private double amount;
	
	@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date datetime;
	
	private String remarks;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMentor_id() {
		return mentor_id;
	}

	public void setMentor_id(Long mentor_id) {
		this.mentor_id = mentor_id;
	}

	public Long getTraining_id() {
		return training_id;
	}

	public void setTraining_id(Long training_id) {
		this.training_id = training_id;
	}

	public String getTxn_type() {
		return txn_type;
	}

	public void setTxn_type(String txn_type) {
		this.txn_type = txn_type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	

	
}
