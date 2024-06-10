package com.spring_Info4.icbackend.dtos;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class NicheDTO {

	private Long id;

	@Size(min = 0, max = 100, message = "Fill in this field the description.")
	@Column(name = "niche_description")
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
