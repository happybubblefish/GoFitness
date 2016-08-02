package com.lin.service;

import java.util.List;

import com.lin.model.Goal;
import com.lin.model.GoalReport;

public interface GoalService {

	Goal save(Goal goal);

	List<Goal> findAllGoals();

	List<GoalReport> findAllGoalReports();
	
	List<String> findAllMoods();
	
	List<GoalReport> findUserGoalReports(String username);
	
	List<GoalReport> findUserActualExerciseGoalReports(String username);
}
