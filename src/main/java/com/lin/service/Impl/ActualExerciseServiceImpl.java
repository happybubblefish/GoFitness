package com.lin.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.model.Activity;
import com.lin.model.ActualExercise;
import com.lin.repository.ActualExcerciseRepository;
import com.lin.service.ActualExerciseService;


@Service("actualExerciseService")
@Transactional
public class ActualExerciseServiceImpl implements ActualExerciseService {
	
	@Autowired
	private ActualExcerciseRepository actualExcerciseRepository;

	public List<Activity> findAllActivities() {
		
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity run = new Activity();
		run.setName("Run");
		activities.add(run);
		
		Activity bike = new Activity();
		bike.setName("Bike");
		activities.add(bike);
		
		Activity swim = new Activity();
		swim.setName("Swim");
		activities.add(swim);
		
		Activity shoulder = new Activity();
		swim.setName("Shoulder");
		activities.add(shoulder);
		
		Activity chest = new Activity();
		swim.setName("Chest");
		activities.add(chest);
		
		Activity leg = new Activity();
		swim.setName("Leg");
		activities.add(leg);
		
		return activities;
	}

	public ActualExercise save(ActualExercise actualExercise) {
		return actualExcerciseRepository.save(actualExercise);
	}	
}
