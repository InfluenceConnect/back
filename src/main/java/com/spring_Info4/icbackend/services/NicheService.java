package com.spring_Info4.icbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_Info4.icbackend.models.Niche;
import com.spring_Info4.icbackend.repositories.NicheRepository;

@Service
public class NicheService {
	
	@Autowired
	private NicheRepository nicheRepo;
	
	public boolean setDefaultNiches() {
		List<Niche> niches = nicheRepo.findAll();
		
		if( niches.isEmpty()) {
			createDefaultNiches();
			
			return true;
		}
		
		return false;
	}
	
	private void createDefaultNiches() {
		String[] defaultNiches = {
			    "esporte",
			    "musica",
			    "moda",
			    "saude-bem-estar",
			    "negocios",
			    "design-interior",
			    "tecnologia",
			    "fotografia",
			    "culinaria",
			    "educacao",
			    "games",
			    "sustentabilidade",
			    "automoveis",
			    "viagens",
			    "pets",
			    "vida",
			    "politica-ativismo",
			    "outros"
		};
		
		for(String niche: defaultNiches) {
			Niche newNiche = new Niche(niche);
			
			nicheRepo.save(newNiche);
		}
	}
	
}
