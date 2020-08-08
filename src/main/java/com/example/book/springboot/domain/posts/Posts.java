package com.example.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
//인자가 없는 기본 생성자 생성
@NoArgsConstructor
//테이블과 링크되는 클래스임을 나타냄
@Entity
public class Posts {

    //해당 테이블의 PK임을 나타냄
    @Id
    //auto-increment 옵션 추가를 위한 선언
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Entity 에서 선언된 모든 필드는 컬럼이 된다
    //애노테이션 생략 가능 하며 옵션을 변경할 경우 선언 하여 사용
    @Column(length = 500, nullable = false)
    private String title;

    //문자열의 경우 VARCHAR(255) 가 기본 이다.
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
