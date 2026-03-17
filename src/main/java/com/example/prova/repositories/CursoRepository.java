package com.example.prova.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.prova.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CursoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Curso salvar(Curso curso) {
        return entityManager.merge(curso);
    }

    public List<Curso> listar() {
        return entityManager.createQuery(
                "FROM Curso c", Curso.class).getResultList();
    }

    public Curso buscarPorId(Long id) {
        return entityManager.find(Curso.class, id);
    }

    @Transactional
    public void excluir(Long id) {
        Curso curso = buscarPorId(id);
        if (curso != null) {
            entityManager.remove(curso);
        }
    }
}