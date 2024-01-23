package com.example.postgreetester.repository;

import com.example.postgreetester.model.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    List<Aluno> findByName(String name);

}
