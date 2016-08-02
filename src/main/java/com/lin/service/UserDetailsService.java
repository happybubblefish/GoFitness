package com.lin.service;

import com.lin.model.UserCredentials;

public interface UserDetailsService {

	void autologin(String username, String password); 
	
	UserCredentials save(UserCredentials userCredentials);
}
