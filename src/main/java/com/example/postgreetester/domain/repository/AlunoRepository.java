package com.example.postgreetester.domain.repository;

import com.example.postgreetester.domain.model.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    List<Aluno> findByName(String name);

}
