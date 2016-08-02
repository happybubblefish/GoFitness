package com.lin.service.Impl;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.model.Authority;
import com.lin.model.UserCredentials;
import com.lin.repository.AuthorityRepository;
import com.lin.repository.UserCredentialsRepository;
import com.lin.service.UserCredentialsService;

@Service
@Transactional
public class UserCredentialsServiceImpl implements UserCredentialsService{
	
	@Autowired
	private UserCredentialsRepository userCredentialsRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserCredentials findByUsername(String username) {
		return userCredentialsRepository.findByUsername(username);
	}

	public UserCredentials save(UserCredentials user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setAuthorities(new HashSet<Authority>(authorityRepository.findAll()));
		userCredentialsRepository.save(user);
		
		return user;
	}
	
}
