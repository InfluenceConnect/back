package com.spring_Info4.icbackend.dtos;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
import com.spring_Info4.icbackend.models.Role;

public class InfluencerDTO {

	private Long id;

	@NotBlank(message = "Cannot be empty.")
	@Size(min = 3, max = 50, message = "influencer name must have between 3 and 50 characters.")
	private String name;

	@CPF
	@NotBlank(message = "Cannot be empty.")
	@Size(min = 11, max = 11, message = "Fill the CPF number without hyphen.")
	private String cpf;

	@NotBlank(message = "Cannot be empty.")
	@Size(min = 3, max = 60, message = "Cannot be empty.")
	private String email;

	@Size(min = 3, max = 50)
	private String state;

	private Set<NicheDTO> niches = new HashSet<>();

	@NotBlank(message = "Cannot be empty.")
	private String birthdaydate;

	private Set<SocialMediaDTO> socialmedia = new HashSet<>();

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBirthdaydate() {
		return birthdaydate;
	}

	public void setBirthdaydate(String birthdaydate) {
		this.birthdaydate = birthdaydate;
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

	public Set<SocialMediaDTO> getSocialmedia() {
		return socialmedia;
	}

	public void setSocialmedia(Set<SocialMediaDTO> socialmedia) {
		this.socialmedia = socialmedia;
	}

	public Set<Role.Type> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role.Type> roles) {
		this.roles = roles;
	}
}
