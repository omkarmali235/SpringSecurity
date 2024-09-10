package com.omkar.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.omkar.SpringSecurity.model.UserPrincipal;
import com.omkar.SpringSecurity.model.Users;
import com.omkar.SpringSecurity.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = repo.findByUserName(username);
		if(user == null) {
			System.out.println("User Not Found");
			throw new UsernameNotFoundException("User Not FOund");
		}
		
		return new UserPrincipal(user);
	}
	
}
