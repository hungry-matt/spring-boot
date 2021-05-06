package com.example.book.springboot.web.dto;

import com.example.book.springboot.domain.posts.Posts;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class PostsListResponseDto {

    private Long id;
    private String title;
    private String author;
    private String content;
    private String modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.content = entity.getContent();
        this.modifiedDate = format(entity.getModifiedDate());
    }

    private String format(LocalDateTime modifiedDate) {
        if (modifiedDate == null) return "";

        return modifiedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
