package com.lin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lin.model.Goal;
import com.lin.model.GoalReport;
import com.lin.model.Member;
import com.lin.service.GoalService;
import com.lin.service.LoginService;
import com.lin.service.MemberService;
import com.lin.validator.GoalValidator;

@Controller
@SessionAttributes({"goal", "member"})
public class GoalController {
	
	@Autowired
	private GoalService goalService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private GoalValidator goalValidator;
	
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    binder.registerCustomEditor(Date.class, editor);
	  }

	@RequestMapping(value = "addDailyGoal", method = RequestMethod.GET)
	public String addGoal(Model model, HttpSession session) {
		
		Goal goal = (Goal)session.getAttribute("goal");
		
		if(goal == null){
			goal = new Goal();
		}
		
		String username = loginService.findLoggedInUsername();
		Member member = memberService.findByUsername(username);
		
		if(member == null){
			return "redirect:/profile";
		}
		
		model.addAttribute("member", member);
		model.addAttribute("goal", goal);
		
		return "addDailyGoal";
	}
	
	@RequestMapping(value = "addDailyGoal", method = RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult bindingResult, HttpSession session, RedirectAttributes redirectAttributes) {
			
		goalValidator.validate(goal, bindingResult);
		
		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.goal", bindingResult);
			redirectAttributes.addFlashAttribute("goal", goal);
			return "redirect:/addDailyGoal";
		}else{
			
			Member currentMember = (Member)session.getAttribute("member");
			Set<Goal> goals = currentMember.getGoals();
			
			if(goals == null){
				Set<Goal> newGoals = new HashSet<Goal>();
				currentMember.setGoals(newGoals);
			}
			
			goals.add(goal);
			
			goal.setMember(currentMember);
			
			goalService.save(goal);
		}
		
		return "redirect:/addMinutes";
	}	
	
	@RequestMapping(value = "getGoals", method = RequestMethod.GET)
	public String getGoals(Model model){
		List<Goal> goals = goalService.findAllGoals();
		
		model.addAttribute("goals", goals);
		
		return "getGoals";
	}
	
	@RequestMapping(value = "getGoalReports", method = RequestMethod.GET)
	public String getGoalReports(Model model){
		String username = loginService.findLoggedInUsername();
		
		List<GoalReport> goalReports = goalService.findUserGoalReports(username);
		List<GoalReport> actualExerciseGoalReports = goalService.findUserActualExerciseGoalReports(username);
		
		model.addAttribute("goalReports", goalReports);
		model.addAttribute("actualExerciseGoalReports", actualExerciseGoalReports);

		return "getGoalReport";
	}
	
	@RequestMapping(value = "/moods", method = RequestMethod.GET)
	public @ResponseBody List<String> findAllMoods() {
		return goalService.findAllMoods();
	}
	
}
