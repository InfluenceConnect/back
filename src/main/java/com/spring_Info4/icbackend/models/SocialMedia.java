package com.spring_Info4.icbackend.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "socialmedias")
public class SocialMedia implements Serializable {

	private static final long serialVersionUID = 1L;

	// Campos da entidade SocialMedia
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "socialmedia_id")
	private Long id;

	@NotBlank(message = "Cannot be empty.")
	@Size(min = 3, max = 100, message = "Description of social medias used for campaigns, market and jobs in general.")
	@Column(name = "socialmedia_description", nullable = false)
	private String description;

	// Constructor
	public SocialMedia() {
	}

	public SocialMedia(String description) {
		this.description = description;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
