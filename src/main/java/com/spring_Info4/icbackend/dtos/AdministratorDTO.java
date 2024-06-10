package com.spring_Info4.icbackend.dtos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.spring_Info4.icbackend.models.Role;

public class AdministratorDTO {
private Long id;
	
	@NotBlank(message = "Cannot be empty.")
	@Size(min = 1, max=50, message = "Administrator name must have at least 1 character.")
	@Column(name = "administrator_name", nullable = false, unique = true)
	private String name;
	
	@NotBlank(message = "Cannot be empty.")
	@Size(min = 1, max = 50, message = "Must have a valid email.")
	@Column(name = "administrator_email", nullable = false)	
	private String email;
	
	@NotBlank(message = "Cannot be empty.")
	@Size(min = 1, max = 50, message = " Your password must have at least 8 characters.")
	@Column(name = "administrator_password", nullable = false)	
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "administrator_id"))
	@Column(name = "administrator_role")
	@Enumerated(EnumType.STRING)
	private Set<Role.Type> roles = new HashSet<>();

	//Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role.Type> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role.Type> roles) {
		this.roles = roles;
	}

}
