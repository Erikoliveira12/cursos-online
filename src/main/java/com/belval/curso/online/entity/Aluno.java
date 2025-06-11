package com.belval.curso.online.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 

public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	private String aula;
	private String curso;
	private String matricula;
	
	public Aluno() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	@Override
	public int hashCode() {
		return Objects.hash(aula, curso, id, nome, telefone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(aula, other.aula) && Objects.equals(curso, other.curso) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone);
	}
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", aula=" + aula + ", curso=" + curso
				+ "]";
	}

	

}