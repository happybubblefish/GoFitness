package com.lin.service;

import java.util.List;

import com.lin.model.Activity;
import com.lin.model.Exercise;

public interface ExerciseService {

	List<Activity> findAllActivities();

	Exercise save(Exercise exercise);

}