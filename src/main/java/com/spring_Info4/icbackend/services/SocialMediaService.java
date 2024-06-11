package com.spring_Info4.icbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_Info4.icbackend.models.SocialMedia;
import com.spring_Info4.icbackend.repositories.SocialMediaRepository;


@Service
public class SocialMediaService {

	@Autowired
	private SocialMediaRepository socialMediaRepo;
	
	public boolean setDefaultsSocialMedia() {
        List<SocialMedia> socialMedias = socialMediaRepo.findAll();

        if (socialMedias.isEmpty()) {
            createDefaultSocialMediaPlatforms();

            return true;
        }

        return false;
    }

    private void createDefaultSocialMediaPlatforms() {
        String[] defaultSocialMediaPlatforms = {
            "Facebook",
            "Instagram",
            "Youtube",
            "TikTok",
            "Twitter"
        };

        for (String platform : defaultSocialMediaPlatforms) {
            SocialMedia newSocialMedia = new SocialMedia(platform);

            socialMediaRepo.save(newSocialMedia);
        }
    }
}
