package com.spring_Info4.icbackend.services;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import com.spring_Info4.icbackend.dtos.InfluencerDTO;
import com.spring_Info4.icbackend.models.Influencer;
import com.spring_Info4.icbackend.models.Role;
import com.spring_Info4.icbackend.repositories.InfluencerRepository;

@Service
public class InfluencerService {

	@Qualifier("modelMapper")
	private final ModelMapper modelMapper;
	private final InfluencerRepository influencerRepository;

	public InfluencerService(ModelMapper modelMapper, InfluencerRepository influencerRepository) {
		this.modelMapper = modelMapper;
		this.influencerRepository = influencerRepository;
	}

	// Método para converter entidade Influencer em DTO InfluencerDTO
	public InfluencerDTO convertToDTO(Influencer influencer) {
		return modelMapper.map(influencer, InfluencerDTO.class);
	}

	// Método para converter DTO InfluencerDTO em entidade Influencer
	public Influencer convertToEntity(InfluencerDTO influencerDTO) {
		return modelMapper.map(influencerDTO, Influencer.class);
	}

	public List<InfluencerDTO> findAll() {
		List<Influencer> influencers = influencerRepository.findAll();
		return influencers.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public InfluencerDTO findById(Long id) {
		Optional<Influencer> influencer = influencerRepository.findById(id);
		return influencer.map(this::convertToDTO).orElseThrow(() -> new EntityNotFoundException("Influencer not found"));
	}

	public InfluencerDTO save(InfluencerDTO influencerDTO) {
		Influencer influencer = convertToEntity(influencerDTO);
		// Set roles for the new influencer
		Set<Role.Type> roles = influencer.getRoles();
		if (roles.isEmpty()) {
			roles.add(Role.Type.Influencer);
		}
		Influencer savedInfluencer = influencerRepository.save(influencer);
		return convertToDTO(savedInfluencer);
	}

	public InfluencerDTO update(Long id, InfluencerDTO influencerDTO) {
		if (!influencerRepository.existsById(id)) {
			throw new EntityNotFoundException("Influencer not found");
		}
		Influencer influencer = convertToEntity(influencerDTO);
		influencer.setId(id); // Ensure the influencer to update has the correct ID
		Influencer updatedInfluencer = influencerRepository.save(influencer);
		return convertToDTO(updatedInfluencer);
	}

	public void delete(Long id) {
		if (!influencerRepository.existsById(id)) {
			throw new EntityNotFoundException("Influencer not found");
		}
		influencerRepository.deleteById(id);
	}
}
