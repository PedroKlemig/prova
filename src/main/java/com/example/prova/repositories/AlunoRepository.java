package com.example.prova.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.prova.models.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AlunoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Aluno salvar(Aluno aluno) {
        return entityManager.merge(aluno);
    }

    public List<Aluno> listar() {
        return entityManager.createQuery(
                "FROM Aluno a", Aluno.class).getResultList();
    }
}
