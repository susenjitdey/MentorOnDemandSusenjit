package com.menondemand.jwtauthentication.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ibm.mentor.model.Mentor;
import com.ibm.mentor.model.Skills;

@Entity
@Table(name = "trainings")
public class Trainings {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ManyToOne
    @JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
    @JoinColumn(name = "mentor_id")
	private Mentor mentor;
	
	@ManyToOne
    @JoinColumn(name = "skills_id")
	private Skills skills;
	
	@Enumerated
	private TrainingStatus status;
	
	private int progress;
	
	private double rating;

    public Trainings() {}

//    public Trainings(String username, String linkedin, int yearsExp, int startTime, int endTime) {
//        this.username = username;
//        this.linkedin = linkedin;
//        this.yearsExp = yearsExp;
//        this.startTime = startTime;
//        this.endTime = endTime;		
//    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Mentor getMentor() {
		return mentor;
	}

	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}

	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}

	public TrainingStatus getStatus() {
		return status;
	}

	public void setStatus(TrainingStatus status) {
		this.status = status;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}
