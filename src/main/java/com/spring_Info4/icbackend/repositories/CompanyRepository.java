package com.spring_Info4.icbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring_Info4.icbackend.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
