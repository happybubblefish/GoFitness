package com.lin.service;

import java.util.List;

import com.lin.model.Member;

public interface MemberService {
	
	Member save(Member member);

	List<Member> findAllMembers();
	
	Member findByUsername(String username);
	
	Member findById(Long id);
	
	void deleteMemberById(Long id);
}
