package com.example.book.springboot.web;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexContorollerTest {

    @Autowired
    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void index_test() throws Exception{

        String body = restTemplate.getForObject("/", String.class);

        System.out.println(body);
        Assertions.assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }
}
