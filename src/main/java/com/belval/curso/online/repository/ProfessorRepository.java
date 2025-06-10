package com.belval.curso.online.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.belval.curso.online.model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {

	List<Professor> findByLicencaContainingIgnoreCase(String licenca);
	
	
	
}
