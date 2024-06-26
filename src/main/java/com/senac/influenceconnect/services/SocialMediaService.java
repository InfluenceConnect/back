package com.senac.influenceconnect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.influenceconnect.models.SocialMedia;
import com.senac.influenceconnect.repositories.SocialMediaRepository;

@Service
public class SocialMediaService {
	
	@Autowired
	private SocialMediaRepository socialMediaRepo;
	
	public boolean setDefaultSocialMedia() {
	    List<SocialMedia> socialMedias = socialMediaRepo.findAll();
	    
	    if (socialMedias.isEmpty()) {
	        createDefaultSocialMedia();
	        return true;
	    }
	    
	    return false;
	}

	private void createDefaultSocialMedia() {
	    String[] defaultSocialMedias = {"facebook", "instagram", "youtube", "tiktok", "twitter"};
	    
	    for (String socialMediaCode : defaultSocialMedias) {
	        SocialMedia newSocialMedia = new SocialMedia();
	        newSocialMedia.setName(socialMediaCode.substring(0, 1).toUpperCase() + socialMediaCode.substring(1));
	        socialMediaRepo.save(newSocialMedia);
	    }
	}
}
