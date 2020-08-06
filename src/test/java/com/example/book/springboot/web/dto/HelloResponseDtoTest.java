package com.example.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_test() {
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //assertJ 라는 테스트 검증 라이브러리의 검증 메소드 이다.
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

        // Junit 의 기본 assertThat 이 아닌 assertj 를 사용한 이유는
        // 추가 라이브러리가 필요 하지 않고 자동완성이 좀 더 확실하게 지원 된다.
    }
}
