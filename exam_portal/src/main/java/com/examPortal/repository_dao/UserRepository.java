package com.examPortal.repository_dao;



import org.springframework.data.jpa.repository.JpaRepository;


import com.examPortal.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUserName(String userName);
	
	
	
}


