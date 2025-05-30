package com.belval.curso.online.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.belval.curso.online.entity.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Integer> {
	
	//select * from Aluno where Aula like "%Aula%"
	List<Aluno> findByMatriculaContainingIgnoreCase(String matricula);

}
