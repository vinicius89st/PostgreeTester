package com.example.postgreetester;

import com.example.postgreetester.resource.AlumnResourse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest

class PostgreeTesterApplicationTests {


    @Autowired
    private AlumnResourse myController;

    @Test
    void contextLoads() {
        assertThat(myController).isNotNull();
    }

}
