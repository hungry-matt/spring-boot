package com.example.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexContoroller {

    //mustache 의존성 추가로 앞의 경로와 뒤의 파일 확장자가 자동으로 지정 된다.
    // /resourece/templates/index.mustache
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
