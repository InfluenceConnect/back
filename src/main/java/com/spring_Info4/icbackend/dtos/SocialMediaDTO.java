package com.spring_Info4.icbackend.dtos;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SocialMediaDTO {

	private Long id;

	@NotBlank(message = "Cannot be empty.")
	@Size(min = 3, max = 100, message = "Description of social medias used for campaigns, market and jobs in general.")
	@Column(name = "socialmedia_description", nullable = false)
	private String description;

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
