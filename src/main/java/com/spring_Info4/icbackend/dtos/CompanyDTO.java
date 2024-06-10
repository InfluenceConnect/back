package com.spring_Info4.icbackend.dtos;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.spring_Info4.icbackend.models.Role;

public class CompanyDTO {

	private Long id;

	@NotBlank(message = "Cannot be empty.")
	@Size(min = 3, max = 50, message = "Company name must have between 3 and 50 characters.")
	private String name;

	@NotBlank(message = "Cannot be empty.")
	@Size(min = 14, max = 14, message = "CNPJ must have 14 characters.")
	private String cnpj;

	@NotBlank(message = "Cannot be empty.")
	@Size(min = 3, max = 60, message = "Cannot be empty.")
	private String email;

	private Set<NicheDTO> niches = new HashSet<>();

	@NotBlank(message = "Cannot be empty.")
	@Size(min = 8, max = 50, message = "Your password must have at least 8 characters.")
	private String password;

	private Set<Role.Type> roles = new HashSet<>();

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public Set<NicheDTO> getNiches() {
		return niches;
	}

	public void setNiches(Set<NicheDTO> niches) {
		this.niches = niches;
	}

	public Set<Role.Type> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role.Type> roles) {
		this.roles = roles;
	}
}
