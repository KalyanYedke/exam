package com.examPortal.service;

import java.util.List;
import java.util.Set;
import com.examPortal.entities.User;
import com.examPortal.entities.UserRole;

public interface UserService {
	
	//create a user
	
	
	public User createUser(User user , Set<UserRole> userRole) throws Exception ;
	
	//getAll user
	public  List<User> getUserAll(User user);
	
	public  User getUser(String userName);
	//update
	public User updateUser(User user);
	//delete
	public void deleteUser(Integer id);
	
	
	
	

}
