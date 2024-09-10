package com.omkar.SpringSecurity.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class UserPrincipal implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private Users user;

	public UserPrincipal(Users user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}
	
	 	@Override
	    public boolean isAccountNonExpired() {
	        return true; // You can customize this based on your requirements
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true; // You can customize this based on your requirements
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true; // You can customize this based on your requirements
	    }

	    @Override
	    public boolean isEnabled() {
	        return true; // You can customize this based on your requirements
	    }
}
