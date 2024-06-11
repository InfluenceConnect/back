package com.spring_Info4.icbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_Info4.icbackend.services.NicheService;

@RestController
@RequestMapping(value="/niches")
public class NicheController {
	
	@Autowired
	private NicheService nicheServ;
	
	@GetMapping(value="/setDefault")
	public ResponseEntity<Void> setDefaultNiches(){
		boolean wasCreated = nicheServ.setDefaultNiches();
		
		if (wasCreated) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
