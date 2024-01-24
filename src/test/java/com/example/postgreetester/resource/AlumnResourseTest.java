package com.example.postgreetester.resource;

import com.example.postgreetester.domain.model.Aluno;
import com.example.postgreetester.domain.repository.AlunoRepository;
import com.example.postgreetester.infra.URI_API_PATH;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@TestPropertySource(properties = {
        "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
        "spring.flyway.enabled=false",
        "spring.jpa.hibernate.ddl-auto=create-drop",
})
class AlumnResourseTest {

    @Autowired
    protected WebTestClient web;

    @Autowired
    protected AlunoRepository repository;

    @BeforeEach
    public void setUp(){
        web.mutate().responseTimeout(Duration.ofMillis(10000)).build();
        repository.deleteAll();
    }
    @Test
    void must_save_alumn() {
        Aluno aluno = new Aluno();
        aluno.setName("João");
        web.post().uri(URI_API_PATH.ALUMNS_API)
                .accept(MediaType.ALL)
                .body(BodyInserters.fromValue(aluno))
                .exchange()
                .expectStatus().isCreated().expectBody(Aluno.class)
                .value(c -> assertTrue(c.getName().equals("João")));
    }
}