package com.lin.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.model.Activity;
import com.lin.model.Exercise;
import com.lin.repository.ExcerciseRepository;
import com.lin.service.ExerciseService;


@Service("exerciseService")
@Transactional
public class ExerciseServiceImpl implements ExerciseService {
	
	@Autowired
	private ExcerciseRepository excerciseRepository;

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
		shoulder.setName("Shoulder");
		activities.add(shoulder);
		
		Activity chest = new Activity();
		chest.setName("Chest");
		activities.add(chest);
		
		Activity leg = new Activity();
		leg.setName("Leg");
		activities.add(leg);
		
		return activities;
	}

	public Exercise save(Exercise exercise) {
		
		return excerciseRepository.save(exercise);
	}
	
}
