package com.lin.service.Impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.lin.model.Goal;
import com.lin.model.GoalReport;
import com.lin.repository.GoalRepository;
import com.lin.service.GoalService;

@Service("goalService")
@EnableTransactionManagement
@Transactional
public class GoalServiceImpl implements GoalService {

	@Autowired
	private GoalRepository goalRepository;
	
	public Goal save(Goal goal) {
		return goalRepository.save(goal);
	}

	public List<Goal> findAllGoals() {
		return goalRepository.findAll();
	}

	public List<GoalReport> findAllGoalReports() {
		return goalRepository.findAllGoalReports();
	}
	
	public List<String> findAllMoods() {
		List<String> moods = new ArrayList<String>();
		
		moods.add("Happy");
		moods.add("Amused");
		moods.add("Calm");
		moods.add("Angry");
		moods.add("Stressed");
		
		return moods;
	}

	public List<GoalReport> findUserGoalReports(String username) {
		return goalRepository.findUserGoalReports(username);
	}
	
	public List<GoalReport> findUserActualExerciseGoalReports(String username){
		return goalRepository.findUserActualExerciseGoalReports(username);
	}
}
