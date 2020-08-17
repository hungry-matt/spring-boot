package com.example.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//JPA Auditing 애노테이션을 모두 활성화.
@EnableJpaAuditing
//스프링 부트의 자동 설정, 스프링 bean 읽기와 생성을 모두 자동으로 설정.
//@SpringbootApplication 이 있는 위치부터 설정을 읽음.
//때문에 이 클래스는 항상 프로젝트 최상단에 위치 해야 한다.
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //SpringApplication.run : 내장 WAS 실행
        SpringApplication.run(Application.class, args);
    }
}
