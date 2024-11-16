package com.examPortal.repository_dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examPortal.entities.Role;
import com.examPortal.entities.User;
import com.examPortal.entities.UserRole;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	
	//public UserRole findByUserName(int userRoleId);


}
