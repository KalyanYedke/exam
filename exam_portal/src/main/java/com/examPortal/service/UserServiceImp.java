package com.examPortal.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examPortal.entities.User;
import com.examPortal.entities.UserRole;
import com.examPortal.repository_dao.RoleRepository;
import com.examPortal.repository_dao.UserRepository;
@Service
public class UserServiceImp implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRole) throws Exception {
	
		
		User local =	this.userRepository.findByUserName(user.getUserName());
		
	if(local != null) {
		System.out.println("user is already there");
		throw new Exception("user is already exit");
	}
	else {
		for(UserRole role:userRole) {
			roleRepository.save(role.getRole());
			
			
		}
		user.getUserRole().addAll(userRole); 
		local = this.userRepository.save(user);
		
	
	}
	
	return local; 
	}

		

	@Override
	public List<User> getUserAll(User user) {
		
		List<User> list = this.userRepository.findAll();
		
		return list;
	}



	@Override
	public User getUser(String userName) {
		
		return this.userRepository.findByUserName(userName);
		//return null;
	}



	@Override
	public User updateUser(User user) {
		
		User update = this.userRepository.save(user);
		
				return update;
	}



	@Override
	public void deleteUser(Integer id) {
		this.userRepository.deleteById(id);
				
	} 

}
 