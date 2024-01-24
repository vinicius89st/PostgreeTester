package com.example.postgreetester.resource;

import com.example.postgreetester.domain.model.Aluno;
import com.example.postgreetester.domain.repository.AlunoRepository;
import com.example.postgreetester.infra.URI_API_PATH;
import com.example.postgreetester.resource.support.AbstractRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = URI_API_PATH.ALUMNS_API)
public class AlumnResourse extends AbstractRestController<Aluno, Long> {

    @Autowired
    AlunoRepository repository;
    @Override
    public CrudRepository getRepository() {
        return repository;
    }
}
