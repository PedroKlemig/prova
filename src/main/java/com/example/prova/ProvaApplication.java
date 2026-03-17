package com.example.prova;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.prova.models.Aluno;
import com.example.prova.models.Curso;
import com.example.prova.repositories.AlunoRepository;
import com.example.prova.repositories.CursoRepository;

@SpringBootApplication
public class ProvaApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired AlunoRepository alunoRepository,
			@Autowired CursoRepository cursoRepository) {
		return args -> {

			
			Curso c1 = cursoRepository.salvar(
					new Curso(null, "Engenharia de Software"));

			Curso c2 = cursoRepository.salvar(
					new Curso(null, "Análise e Desenvolvimento de Sistemas"));

			
			alunoRepository.salvar(
    				new Aluno(null, "João Silva", 2023, c1));

			alunoRepository.salvar(
    				new Aluno(null, "Maria Souza", 2024, c2));

			
			System.out.println("CURSOS");
			List<Curso> listaCursos = cursoRepository.listar();
			listaCursos.forEach(System.out::println);

			
			System.out.println("ALUNOS");
			List<Aluno> listaAlunos = alunoRepository.listar();
			listaAlunos.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProvaApplication.class, args);
	}
}