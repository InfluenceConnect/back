package com.spring_Info4.icbackend.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "influencer")
public class Influencer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "influencer_id")
	private Long id;

	@NotBlank(message = "Cannot be empty.")
	@Size(min = 3, max = 50, message = "influencer name must have between 3 and 50 characters.")
	@Column(name = "influencer_name", nullable = false)
	private String name;

	@CPF
	@NotBlank(message = "Cannot be empty.")
	@Size(min = 11, max = 11, message = "Fill the CPF number without hyphen.")
	@Column(name = "influencer_cpf", nullable = false, unique = true)
	private String cpf;

	@NotBlank(message = "Cannot be empty.")
	@Size(min = 3, max = 60, message = "Cannot be empty.")
	@Column(name = "influencer_email", nullable = false, unique = true)
	private String email;

	@Size(min = 3, max = 50)
	@Column(name = "influencer_state")
	private String state;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "influencer_niche", joinColumns = @JoinColumn(name = "influencer_id"), inverseJoinColumns = @JoinColumn(name = "niche_id"))
	private Set<Niche> niches = new HashSet<>();

	@NotBlank(message = "Cannot be empty.")
	@Column(name = "influencer_birthdaydate", nullable = false)
	private String birthdaydate;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "influencer_socialmedia", joinColumns = @JoinColumn(name = "influencer_id"), inverseJoinColumns = @JoinColumn(name = "socialmedia_id"))
	private Set<SocialMedia> socialmedia = new HashSet<>();

	@NotBlank(message = "Cannot be empty.")
	@Size(min = 8, max = 50, message = "Your password must have at least 8 characters.")
	@Column(name = "influencer_password", nullable = false)
	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "influencer_id"))
	@Column(name = "influencer_role")
	@Enumerated(EnumType.STRING)
	private Set<Role.Type> roles = new HashSet<>();

	public Influencer() {
	}

	public Influencer(String name, String cpf, String email, String state, String birthdaydate, String password) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.state = state;
		this.birthdaydate = birthdaydate;
		this.password = password;
	}

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

	public Set<Niche> getNiches() {
		return niches;
	}

	public void setNiches(Set<Niche> niches) {
		this.niches = niches;
	}

	public Set<SocialMedia> getSocialmedia() {
		return socialmedia;
	}

	public void setSocialmedia(Set<SocialMedia> socialmedia) {
		this.socialmedia = socialmedia;
	}

	public Set<Role.Type> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role.Type> roles) {
		this.roles = roles;
	}
}
