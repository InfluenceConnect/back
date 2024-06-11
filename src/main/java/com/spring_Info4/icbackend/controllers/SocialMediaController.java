package com.spring_Info4.icbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_Info4.icbackend.services.SocialMediaService;

@RestController
@RequestMapping(value="/socialmedias")
public class SocialMediaController {
	
	@Autowired
	private SocialMediaService socialMediaServ;
	
	@GetMapping("/setDefault")
	public ResponseEntity<Void> setDefaultSocialMedia(){
		boolean wasCreated = socialMediaServ.setDefaultsSocialMedia();
		
		if (wasCreated) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();	
	}
}
