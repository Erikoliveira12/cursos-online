package com.belval.curso.online.repository;

import java.util.List;

import com.belval.curso.online.entity.Aluno;

public interface AlunoRepository {//extends Alunorepository<Aluno, Integer> {
	
	//select * from Aluno where Aula like "%Aula%"
	List<Aluno> findByDescricaoContainingIgnoreCase(String descricao);

}
