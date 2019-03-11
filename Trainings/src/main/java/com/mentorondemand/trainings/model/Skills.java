package com.mentorondemand.trainings.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
public class Skills {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
//    @JoinTable(name = "mentor_skills", 
//    	joinColumns = @JoinColumn(name = "skill_id"), 
//    	inverseJoinColumns = @JoinColumn(name = "mentor_id"))
//    private List<Mentor> mentors = new ArrayList<Mentor>();
    
    public Skills() {}

    public Skills(String name) {
        this.name = name;
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Mentor> getMentors() {
//		return mentors;
//	}
//
//	public void setMentors(List<Mentor> mentors) {
//		this.mentors = mentors;
//	}
}