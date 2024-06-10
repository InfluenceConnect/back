package com.spring_Info4.icbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring_Info4.icbackend.models.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long>{

}
