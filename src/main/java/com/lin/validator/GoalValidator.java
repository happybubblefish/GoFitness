package com.lin.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lin.model.Goal;

@Component
public class GoalValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Goal.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Goal goal = (Goal)target;
		
		if(goal.getMood().equals("")){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mood", "goal.moodEmpty");
		}
	}
	
}
