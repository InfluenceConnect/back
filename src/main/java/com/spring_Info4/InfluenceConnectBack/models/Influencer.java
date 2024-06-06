package com.spring_Info4.InfluenceConnectBack.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "influencer")
public class Influencer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_influencer", nullable = false)
	private Long id;

	@NotNull(message = "Cannot be empty.")
	@Size(max = 50, message = "Cannot exceed more than 50 characters.")
	@Pattern(regexp = "^[\\p{L} \\p{P}]*$", message = "Fill with alphacharacters and space.")
	@Column(name = "name_influencer", nullable = false)
	private String name;

	@NotNull(message = "Cannot be empty.")
	@Column(name = "influencer_cpf", nullable = false)
	private String cpf;

	@NotNull(message = "cannot be empty.")
	@Column(name = "influencer_email", nullable =false)
	private String email;

	@NotNull(message = "Cannot be empty.")
	@Column(name = "influencer_password", nullable = false)
	private String password;

	@Column(name = "influencer_state")
	private String state;

	@NotNull(message = "Fill with at least one option.")
	@Column(name= "influencer_niche", nullable = false)
	private String niche;

	@NotNull(message = "Cannot be empty.")
	@Column(name = "influencer_birthdaydate", nullable = false)
	private String birthdaydate;

	@NotNull(message = "Fill with at least one option.")
	@Column(name= "influencer_socialmedia", nullable = false)
	private String socialmedia;

	@NotNull
	@Column(name= "influencer_socialmedia", nullable = false)
	private String status;

	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNiche() {
		return niche;
	}

	public void setNiche(String niche) {
		this.niche = niche;
	}

	public String getBirthdaydate() {
		return birthdaydate;
	}

	public void setBirthdaydate(String birthdaydate) {
		this.birthdaydate = birthdaydate;
	}

	public String getSocialmedia() {
		return socialmedia;
	}

	public void setSocialmedia(String socialmedia) {
		this.socialmedia = socialmedia;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
