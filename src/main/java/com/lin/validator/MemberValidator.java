package com.lin.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lin.model.Member;

@Component
public class MemberValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Member.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Member member = (Member)target;
		
		if(member.getGender() == null || member.getGender().equals("")){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "required.gender");
		}
	}

}
