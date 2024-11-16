package com.examPortal.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examPortal.entities.Role;
import com.examPortal.entities.User;
import com.examPortal.entities.UserRole;
import com.examPortal.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		Set<UserRole> roles  = new HashSet<>();
		
		Role role = new Role();
		role.setRoleId(1);
		role.setRole("normal");
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole); 
		
		
		
		return this.userService.createUser(user,roles);
	}
	
	
	@GetMapping("/getAll")
	public List<User> getAllUser( User user){
		
		
		List <User> list = this.userService.getUserAll(user);
		
		
		
		return list;
	}
	
	
	@GetMapping("/get/{username}")
	public User getUser( @PathVariable("username") String usename) {
		
		return this.userService.getUser(usename);
		
	//	return null;
	}
	
	@PutMapping("/update")
	public User updaateUser(@RequestBody User user) {
		
		return this.userService.updateUser(user);
		
		   
		
		
		//return null;
	}
	@DeleteMapping("delete/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		this.userService.deleteUser(id);
	}
	
	
	
	

}
