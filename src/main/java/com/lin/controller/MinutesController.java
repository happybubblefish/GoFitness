package com.lin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lin.model.Activity;
import com.lin.model.ActualExercise;
import com.lin.model.Exercise;
import com.lin.model.Goal;
import com.lin.service.ActualExerciseService;
import com.lin.service.ExerciseService;
import com.lin.service.GoalService;

@Controller
public class MinutesController {

	@Autowired
	private ExerciseService exerciseService;

	@Autowired
	private ActualExerciseService actualExerciseService;

	@Autowired
	private GoalService goalService;

	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@RequestMapping(value = "addMinutes", method = RequestMethod.GET)
	public String getMinutes(Model model ) {
		if(!model.containsAttribute("exercise")){
			Exercise exercise = new Exercise();
			model.addAttribute("exercise", exercise);
		}

		return "addMinutes";
	}

	@RequestMapping(value = "addMinutes", method = RequestMethod.POST)
	public String addMinutes(HttpSession session, @Valid @ModelAttribute("exercise") Exercise exercise, 
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.exercise", bindingResult);
			redirectAttributes.addFlashAttribute("exercise", exercise);
		} else {
			Goal goal = (Goal) session.getAttribute("goal");

			exercise.setGoal(goal);
			exerciseService.save(exercise);
		}

		return "redirect:/addMinutes";
	}

	@RequestMapping(value = "actualExercise", method = RequestMethod.GET)
	public String preInputActualExercise(Model model) {
		if(!model.containsAttribute("actualExercise")){
			ActualExercise actualExercise = new ActualExercise();
			model.addAttribute("actualExercise", actualExercise);
		}
		
		List<Goal> goals = goalService.findAllGoals();
		model.addAttribute("goals", goals);

		return "actualExercise";
	}

	@RequestMapping(value = "actualExercise", method = RequestMethod.POST)
	public String inputActualExercise(@Valid @ModelAttribute("actualExercise") ActualExercise actualExercise,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			
			for (Object object : bindingResult.getAllErrors()) {
				if (object instanceof FieldError) {
					FieldError fieldError = (FieldError) object;

					System.out.println(fieldError.getCode());
				}

				if (object instanceof ObjectError) {
					ObjectError objectError = (ObjectError) object;

					System.out.println(objectError.getCode());
				}
			}
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.actualExercise", bindingResult);
			redirectAttributes.addFlashAttribute("actualExercise", actualExercise);
			return "redirect:/actualExercise";
		} else {
			actualExerciseService.save(actualExercise);
		}

		return "redirect:/actualExercise";
	}

	@RequestMapping(value = "activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities() {
		return exerciseService.findAllActivities();
	}

}
