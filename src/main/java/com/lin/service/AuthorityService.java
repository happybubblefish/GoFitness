package com.lin.service;

import java.util.List;

import com.lin.model.Authority;

public interface AuthorityService {
	
	Authority save(Authority authority);
	
	List<Authority> findAllAuthorities();
	
	Authority findAuthorityById(Long id);
}
