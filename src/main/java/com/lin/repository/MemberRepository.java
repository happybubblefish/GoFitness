package com.lin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lin.model.Member;

@Repository("memberRepository")
public interface MemberRepository extends JpaRepository<Member, Long> {
	
	Member findByUsername(String username);
}
