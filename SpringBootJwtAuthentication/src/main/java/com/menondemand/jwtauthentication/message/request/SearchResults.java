package com.menondemand.jwtauthentication.message.request;

import javax.validation.constraints.NotBlank;

public class SearchResults {
	@NotBlank
    private String skill;

    private int startTime;

    private int endTime;

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

}
