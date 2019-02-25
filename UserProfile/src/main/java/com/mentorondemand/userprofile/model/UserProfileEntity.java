/**
 * 
 */
package com.mentorondemand.userprofile.model;

import java.util.Date;


import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
/**
 * @author javaibm04
 *
 */
@Entity
@Table(name = "usertable")
public class UserProfileEntity  {
	
	
	// id
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		// username(email id)
		@NotBlank
		private String username;

		// password(hashed)
		@NotBlank
		private String password;

		// first name
		@NotBlank
		private String firstname;

		// lastname
		@NotBlank
		private String lastname;

		// contact number
		@NotBlank
		private String contactnumber;

		// reg_datetime
		@Column(nullable = false)
		@Temporal(TemporalType.TIMESTAMP)
		@LastModifiedDate
		private Date reg_datetime;

		// reg_code
		@NotBlank
		private String reg_code;

		// active
		@NotBlank
		private String active;

		public UserProfileEntity(String active, String contactnumber, String firstname, String lastname,
				String password, String reg_code, Date reg_datetime, String username) {
			this.active = active;
			this.contactnumber = contactnumber;
			this.firstname = firstname;
			this.lastname = lastname;
			this.password=password;
			this.reg_code = reg_code;
			this.reg_datetime = reg_datetime;
			this.username=username;
			
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getContactnumber() {
			return contactnumber;
		}

		public void setContactnumber(String contactnumber) {
			this.contactnumber = contactnumber;
		}

		public Date getReg_datetime() {
			return reg_datetime;
		}

		public void setReg_datetime(Date reg_datetime) {
			this.reg_datetime = reg_datetime;
		}

		public String getReg_code() {
			return reg_code;
		}

		public void setReg_code(String reg_code) {
			this.reg_code = reg_code;
		}

		public String getActive() {
			return active;
		}

		public void setActive(String active) {
			this.active = active;
		}



}
