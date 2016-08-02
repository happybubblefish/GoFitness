package com.lin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lin.model.Member;
import com.lin.service.MemberService;

@Controller
@SessionAttributes("member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberList", method = RequestMethod.GET)
	public String viewAllMembers(Model model){
		List<Member> members = memberService.findAllMembers();
		model.addAttribute("members", members);
		
		return "memberList";
	}
	
	@RequestMapping(value = "preEditMember/{memberId}", method = RequestMethod.GET)
	public String preEditMember(@PathVariable Long memberId, Model model){
		Member editMember = memberService.findById(memberId);
		
		if(editMember == null){
			
		}
		
		model.addAttribute("editMember", editMember);
		
		
		return "editMember";
	}
	
	@RequestMapping(value = "preEditMember/{memberId}", method = RequestMethod.POST)
	public String editMember(@Valid @ModelAttribute("editMember") Member editMember, BindingResult bindingResult, Model model){
		if(!bindingResult.hasErrors()){
			
		}
		
		memberService.save(editMember);
		
		List<Member> members = memberService.findAllMembers();
		model.addAttribute("members", members);
		
		return "memberList";
	}
	
	@RequestMapping(value = "deleteMember/{memberId}", method = RequestMethod.GET)
	public String deleteMember(@PathVariable Long memberId, Model model){
		memberService.deleteMemberById(memberId);
		
		List<Member> members = memberService.findAllMembers();
		model.addAttribute("members", members);
		
		return "memberList";
	}
}
