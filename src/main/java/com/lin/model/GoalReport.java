package com.lin.model;

import java.util.Date;

public class GoalReport {

	private Long goalId;
	private int goalMinutes;
	private int exerciseMinutes;
	private String username;
	private Date date;
	private int sets;
	private int reps;
	
	private String exerciseActivity;

	public GoalReport(){}

	public GoalReport(Long goalId, Date date, int goalMinutes, int exerciseMinutes, String username, String exerciseActivity, int sets, int reps) {
		this.goalId = goalId;
		this.date = date;
		this.goalMinutes = goalMinutes;
		this.exerciseMinutes = exerciseMinutes;
		this.username = username;
		this.exerciseActivity = exerciseActivity;
		this.sets = sets;
		this.reps = reps;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public Long getGoalId() {
		return goalId;
	}

	public void setGoalId(Long goalId) {
		this.goalId = goalId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getGoalMinutes() {
		return goalMinutes;
	}

	public void setGoalMinutes(int goalMinutes) {
		this.goalMinutes = goalMinutes;
	}

	public int getExerciseMinutes() {
		return exerciseMinutes;
	}

	public void setExerciseMinutes(int exerciseMinutes) {
		this.exerciseMinutes = exerciseMinutes;
	}
	
	public String getExerciseActivity() {
		return exerciseActivity;
	}

	public void setExerciseActivity(String exerciseActivity) {
		this.exerciseActivity = exerciseActivity;
	}
}
