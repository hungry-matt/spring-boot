package com.example.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    //해당 클래스의 빌드 패턴 클래스를 생성
    //생성자 위에 선언시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
