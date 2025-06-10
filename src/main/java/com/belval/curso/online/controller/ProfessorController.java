package com.belval.curso.online.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.belval.curso.online.model.Professor;
import com.belval.curso.online.repository.ProfessorRepository;

@RestController
public class ProfessorController {
	
	@Autowired
	private ProfessorRepository repository;
	
	@GetMapping("/professores")
	public ResponseEntity<Iterable<Professor>> obterProfessor() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.findAll());
	}
	
	@GetMapping("/professores(id)")
	public ResponseEntity<Object> buscarPorId(
	    @PathVariable(value = "id") Integer id) {
	
		Optional<Professor> professor = repository.findById(id);
		
		if (professor.isPresent()) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(professor.get());
		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Professor não encontrado!");
	}           
	
	//curl -X POST http://localhost:8080/professores -H "Content-Type: application/json; Charset=utf-8" -d @novo-professor.json
	
	@PostMapping("/professores")
	public ResponseEntity<Professor> criarProfessor(
			@RequestBody Professor professor) {
		
		//professor.setId(proxId++);
		
		System.out.println("Professor criado ... " + professor.toString());
		repository.save(professor);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(professor);
	}
	
	
	
        //curl -X DELETE http://localhost:8080/professores/1
	
		@DeleteMapping("/professores/{id}")
	    public ResponseEntity<String> deletarProfessor(@PathVariable Integer id) {
	        if (repository.existsById(id)) {
	            repository.deleteById(id);
	            return ResponseEntity
	    				.status(HttpStatus.OK)
	    				.body("Professor apagado!");
	    				
	        }
	        return ResponseEntity
	        		.status(HttpStatus.NOT_FOUND)
	        		.body("Não encontrado!.");
	    }
	

		//curl -X PUT http://localhost:8080/professores/1 -H "Content-Type: application/json; Charset=utf-8" -d @atualizar-professor.json
		
		@PutMapping("/professores/{id}")
		public ResponseEntity<Object> atualizarProfessor(
				@PathVariable Integer id,
				@RequestBody Professor prof) {
			
			Optional<Professor> professor = repository.findById(id);
			
			if (professor.isEmpty()) {
	 
				return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body("Professor não encontrado!");
			}
			
			prof.setId(id);
			repository.save(prof);
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.body("Professor atualizado com sucesso!");
			
	 
		}
	 
	}
