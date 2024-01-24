package com.example.postgreetester;

import com.example.postgreetester.domain.model.Aluno;
import com.example.postgreetester.domain.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostgreeTesterApplication implements CommandLineRunner {

    @Autowired
    AlunoRepository dao;

    public static void main(String[] args) {
        SpringApplication.run(PostgreeTesterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Aluno a = new Aluno(1L, "teste", "", "", null);
        dao.save(a);
        System.out.println(dao.findByName("teste"));
    }
}
