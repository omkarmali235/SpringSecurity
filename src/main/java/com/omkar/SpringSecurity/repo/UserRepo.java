package com.omkar.SpringSecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omkar.SpringSecurity.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
	Users findByUserName(String username);
}
