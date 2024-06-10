package com.spring_Info4.icbackend.controllers;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.spring_Info4.icbackend.dtos.CompanyDTO;
import com.spring_Info4.icbackend.services.CompanyService;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {

	private final CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@GetMapping
	public ResponseEntity<List<CompanyDTO>> findAll() {
		List<CompanyDTO> companies = companyService.findAll();
		return ResponseEntity.ok().body(companies);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CompanyDTO> findById(@PathVariable Long id) {
		CompanyDTO company = companyService.findById(id);
		return ResponseEntity.ok().body(company);
	}

	@PostMapping
	public ResponseEntity<CompanyDTO> insert(@Valid @RequestBody CompanyDTO companyDTO) {
		CompanyDTO createdCompany = companyService.save(companyDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCompany.getId()).toUri();
		return ResponseEntity.created(uri).body(createdCompany);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CompanyDTO> update(@PathVariable Long id, @Valid @RequestBody CompanyDTO companyDTO) {
		CompanyDTO updatedCompany = companyService.update(id, companyDTO);
		return ResponseEntity.ok().body(updatedCompany);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		companyService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
