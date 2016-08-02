package com.lin.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.model.Member;
import com.lin.repository.MemberRepository;
import com.lin.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	public Member save(Member member) {
		return memberRepository.save(member);
	}

	public List<Member> findAllMembers() {
		return memberRepository.findAll();
	}

	public Member findByUsername(String username) {
		return memberRepository.findByUsername(username);
	}

	public Member findById(Long id) {
		return memberRepository.findOne(id);
	}

	public void deleteMemberById(Long id) {
		memberRepository.delete(id);
	}
	
}
