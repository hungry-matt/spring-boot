package com.example.book.springboot.web;

import com.example.book.springboot.domain.posts.PostsRepository;
import com.example.book.springboot.domain.posts.PostsSaveRequestDto;
import com.example.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// final 필드가 포함된 생성자 생성
@RequiredArgsConstructor
// Json 을 반환 하는 컨트롤러
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }
}
