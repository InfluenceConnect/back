package com.spring_Info4.icbackend.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "company")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private Long id;

	@NotBlank(message = "Cannot be empty.")
	@Size(min = 3, max = 50, message = "Company name must have between 3 and 50 characters.")
	@Column(name = "company_name", nullable = false)
	private String name;

	@NotBlank(message = "Cannot be empty.")
	@Size(min = 14, max = 14, message = "CNPJ must have 14 characters.")
	@Column(name = "company_cnpj", nullable = false, unique = true)
	private String cnpj;

	@NotBlank(message = "Cannot be empty.")
	@Size(min = 3, max = 60, message = "Cannot be empty.")
	@Column(name = "company_email", nullable = false, unique = true)
	private String email;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "company_niche", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "niche_id"))
	private Set<Niche> niches = new HashSet<>();

	@NotBlank(message = "Cannot be empty.")
	@Size(min = 8, max = 50, message = "Your password must have at least 8 characters.")
	@Column(name = "company_password", nullable = false)
	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "company_id"))
	@Column(name = "company_role")
	@Enumerated(EnumType.STRING)
	private Set<Role.Type> roles = new HashSet<>();

	public Company() {
	}

	public Company(String name, String cnpj, String email, String password) {
		this.name = name;
		this.cnpj = cnpj;
		this.email = email;
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

	public Set<Niche> getNiches() {
		return niches;
	}

	public void setNiches(Set<Niche> niches) {
		this.niches = niches;
	}

	public Set<Role.Type> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role.Type> roles) {
		this.roles = roles;
	}
}
