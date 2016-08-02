package com.lin.service.Impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.model.Authority;
import com.lin.model.UserCredentials;
import com.lin.repository.UserCredentialsRepository;

//@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserCredentialsRepository userCredentialsRepository;	
	
	@Transactional(readOnly = true)
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		UserCredentials user = userCredentialsRepository.findByUsername(username);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		
		for(Authority au : user.getAuthorities()){
			grantedAuthorities.add(new SimpleGrantedAuthority(au.getName()));
		}

		return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
	
	
	
}
