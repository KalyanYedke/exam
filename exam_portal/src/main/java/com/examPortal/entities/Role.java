package com.examPortal.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Role {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roleId;
	private String role;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
	@JsonIgnore
	private Set<UserRole> userRole = new HashSet<>();
	
	
	
	public Set<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Role(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}
	
	public Role() {}
	

}
