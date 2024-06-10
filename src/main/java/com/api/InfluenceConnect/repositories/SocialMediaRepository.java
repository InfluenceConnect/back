package com.api.InfluenceConnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.InfluenceConnect.models.SocialMedia;

@Repository
public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long> {

}