package com.manojskillhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manojskillhub.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	

}
