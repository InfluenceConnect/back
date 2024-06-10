package com.spring_Info4.icbackend.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "niches")
public class Niche implements Serializable {

	private static final long serialVersionUID = 1L;

	// Campos da tabela niche
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "niche_id")
	private Long id;

	@Size(min = 0, max = 100, message = "Fill in this field the description.")
	@Column(name = "niche_description")
	private String description;

	// Constructor
	public Niche() {
	}

	public Niche(String description) {
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
