package com.lin.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.model.Authority;
import com.lin.repository.AuthorityRepository;
import com.lin.service.AuthorityService;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepository;
	
	public Authority save(Authority authority) {
		return authorityRepository.save(authority);
	}

	public List<Authority> findAllAuthorities() {
		return authorityRepository.findAll();
	}

	public Authority findAuthorityById(Long id) {
		return authorityRepository.findOne(id);
	}

}
