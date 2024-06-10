package com.spring_Info4.icbackend.controllers;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.spring_Info4.icbackend.dtos.InfluencerDTO;
import com.spring_Info4.icbackend.services.InfluencerService;

@RestController
@RequestMapping(value = "/influencers")
public class InfluencerController {

	private final InfluencerService influencerService;

	public InfluencerController(InfluencerService influencerService) {
		this.influencerService = influencerService;
	}

	@GetMapping
	public ResponseEntity<List<InfluencerDTO>> findAll() {
		List<InfluencerDTO> influencers = influencerService.findAll();
		return ResponseEntity.ok().body(influencers);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<InfluencerDTO> findById(@PathVariable Long id) {
		InfluencerDTO influencer = influencerService.findById(id);
		return ResponseEntity.ok().body(influencer);
	}

	@PostMapping
	public ResponseEntity<InfluencerDTO> insert(@Valid @RequestBody InfluencerDTO influencerDTO) {
		InfluencerDTO createdInfluencer = influencerService.save(influencerDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdInfluencer.getId()).toUri();
		return ResponseEntity.created(uri).body(createdInfluencer);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<InfluencerDTO> update(@PathVariable Long id, @Valid @RequestBody InfluencerDTO influencerDTO) {
		InfluencerDTO updatedInfluencer = influencerService.update(id, influencerDTO);
		return ResponseEntity.ok().body(updatedInfluencer);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		influencerService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
