package com.example.book.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
//JPA Auditing 애노테이션을 모두 활성화.
@EnableJpaAuditing
public class JpaConfig {
}
