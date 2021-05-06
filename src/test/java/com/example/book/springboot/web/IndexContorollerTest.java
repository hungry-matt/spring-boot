package com.example.book.springboot.web;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexContorollerTest {

    @Autowired
    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void index_test() throws Exception{

        String body = restTemplate.getForObject("/", String.class);

        System.out.println(body);
        Assertions.assertThat(body).contains("Test");
    }
}
