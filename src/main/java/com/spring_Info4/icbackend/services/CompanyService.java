package com.spring_Info4.icbackend.services;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import com.spring_Info4.icbackend.dtos.CompanyDTO;
import com.spring_Info4.icbackend.models.Company;
import com.spring_Info4.icbackend.models.Role;
import com.spring_Info4.icbackend.repositories.CompanyRepository;

@Service
public class CompanyService {

	@Qualifier("modelMapper")
	private final ModelMapper modelMapper;
	private final CompanyRepository companyRepository;

	public CompanyService(ModelMapper modelMapper, CompanyRepository companyRepository) {
		this.modelMapper = modelMapper;
		this.companyRepository = companyRepository;
	}

	// Método para converter entidade Company em DTO CompanyDTO
	public CompanyDTO convertToDTO(Company company) {
		return modelMapper.map(company, CompanyDTO.class);
	}

	// Método para converter DTO CompanyDTO em entidade Company
	public Company convertToEntity(CompanyDTO companyDTO) {
		return modelMapper.map(companyDTO, Company.class);
	}

	public List<CompanyDTO> findAll() {
		List<Company> companies = companyRepository.findAll();
		return companies.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public CompanyDTO findById(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		return company.map(this::convertToDTO).orElseThrow(() -> new EntityNotFoundException("Company not found"));
	}

	public CompanyDTO save(CompanyDTO companyDTO) {
		Company company = convertToEntity(companyDTO);
		// Set roles for the new company
		Set<Role.Type> roles = company.getRoles();
		if (roles.isEmpty()) {
			roles.add(Role.Type.Company);
		}
		Company savedCompany = companyRepository.save(company);
		return convertToDTO(savedCompany);
	}

	public CompanyDTO update(Long id, CompanyDTO companyDTO) {
		if (!companyRepository.existsById(id)) {
			throw new EntityNotFoundException("Company not found");
		}
		Company company = convertToEntity(companyDTO);
		company.setId(id); // Ensure the company to update has the correct ID
		Company updatedCompany = companyRepository.save(company);
		return convertToDTO(updatedCompany);
	}

	public void delete(Long id) {
		if (!companyRepository.existsById(id)) {
			throw new EntityNotFoundException("Company not found");
		}
		companyRepository.deleteById(id);
	}
}
