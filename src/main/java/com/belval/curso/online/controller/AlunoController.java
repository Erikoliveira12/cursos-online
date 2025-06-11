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

import com.belval.curso.online.entity.Aluno;
import com.belval.curso.online.repository.AlunoRepository;



@RestController
public class AlunoController {

	
		@Autowired
        private AlunoRepository repository;
		
		@GetMapping("/alunos")
		public ResponseEntity<Iterable<Aluno>> obterAlunos() {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(repository.findAll());
		}
		@GetMapping("/alunos/{id}")
		public ResponseEntity<Object> buscarPorId(
				@PathVariable(value = "id") Integer id) {
			
			Optional<Aluno> aluno = repository.findById(id);
			
			if (aluno.isPresent()) {
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(aluno.get());
			}
			
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Aluno não encontrado!");
					
		}
		
		
		//curl -X POST http://localhost:8080/alunos -H "Content-Type: application/json; Charset=utf-8" -d @aluno-novo.json
		
		@PostMapping("/alunos")
		public ResponseEntity<Aluno> criarAluno(
				@RequestBody Aluno aluno) {
			
			//produto.setId(proxId++);
			
			System.out.println("Aluno criado ... " + aluno.toString());
			repository.save(aluno);
			
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(aluno);
			
		}
		
		//curl -X DELETE http://localhost:8080/alunos/1
		@DeleteMapping("/alunos/{id}")
	    public ResponseEntity<String> deletarAluno(@PathVariable Integer id) {
	        if (repository.existsById(id)) {
	            repository.deleteById(id);
	            return ResponseEntity
	    				.status(HttpStatus.OK)
	    				.body("Ok.");
	    				
	        }
	        return ResponseEntity
	        		.status(HttpStatus.NOT_FOUND)
	        		.body("nao encontrado.");
	    }
		
		
		
		
		
		//curl -X PUT http://localhost:8080/alunos/1 -H "Content-Type: application/json; Charset=utf-8" -d @aluno-atualizar.json 
		@PutMapping("/alunos/{id}")
		public ResponseEntity<Object> atualizarAluno(
				@PathVariable Integer id,
				@RequestBody Aluno aluno) {
			
			Optional<Aluno> alunoEncontrado = repository.findById(id);
			
			if (alunoEncontrado.isEmpty()) {

				return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body("Aluno não encontrado!");
			}
			
			aluno.setId(id);
			repository.save(aluno);
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.body("Aluno atualizado com sucesso!");
			

		}

	}

