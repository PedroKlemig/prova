package com.example.prova.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prova.models.Curso;
import com.example.prova.repositories.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<Curso> mostrarTodos() {
        return cursoRepository.listar();
    }

    @PostMapping
    public Curso inserir(@RequestBody Curso curso) {
        return cursoRepository.salvar(curso);
    }
}