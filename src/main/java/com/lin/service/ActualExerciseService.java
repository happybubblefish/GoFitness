package com.lin.service;

import java.util.List;

import com.lin.model.Activity;
import com.lin.model.ActualExercise;

public interface ActualExerciseService {

	List<Activity> findAllActivities();
	
	ActualExercise save(ActualExercise actualExercise);

}