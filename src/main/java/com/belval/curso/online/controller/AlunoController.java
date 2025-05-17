package com.belval.curso.online.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class AlunoController {



//@Autowired
//private AlunoRepository repository;

///**
// * Retorna todos os Alunos
// * @return
// */
//@GetMapping("/Alunos")
//public ResponseEntity<Iterable<Aluno>> obterAlunos() {
//	return ResponseEntity
//			.status(HttpStatus.OK)
//			.body(repository.findAll());
//}
//
//@GetMapping("/Alunos/{id}")
//public ResponseEntity<Object> buscarPorId(
//		@PathVariable(value = "id") Integer id) {
//	
//	Optional<Aluno> Aluno = repository.findById(id);
//	
//	if (Aluno.isPresent()) {
//		return ResponseEntity
//				.status(HttpStatus.OK)
//				.body(Aluno.get());
//	}
//	
//	return ResponseEntity
//			.status(HttpStatus.NOT_FOUND)
//			.body("Aluno não encontrado!");
//			
//}
//
//
////curl POST http://localhost:8080/produtos -H "Content-Type: application/json; Charset=utf-8" -d @Alunoonline.json
//
//@PostMapping("/Alunos")
//public ResponseEntity<aluno> criarAluno(
//		@RequestBody aluno ) {
//	
//	//produto.setId(proxId++);
//	
//	System.out.println(" Aluno ... " + Aluno.toString());
//	repository.save(Aluno);
//	
//	return ResponseEntity
//			.status(HttpStatus.CREATED)
//			.body(Aluno);
//	
//}
//
//
////Observação: para métodos que não sejam o GET e o POST é necessário colocar o -X(menos xis maiúsculo)
////curl -X PUT http://localhost:8080/produtos/1 -H "Content-Type: application/json; Charset=utf-8" -d @c.json 
//@PutMapping("/Alunos/{id}")
//public ResponseEntity<Object> atualizarAluno(
//		@PathVariable Integer id,
//		@RequestBody Aluno prod) {
//	
//	Optional<Aluno> Aluno = repository.findById(id);
//	
//	if (Aluno.isEmpty()) {
//
//		return ResponseEntity
//				.status(HttpStatus.NOT_FOUND)
//				.body("Aluno não encontrado!");
//	}
//	
//	prod.setId(id);
//	repository.save(prod);
//	
//	return ResponseEntity
//			.status(HttpStatus.OK)
//			.body("Aluno atualizado com sucesso!");
//	
//
//}

}