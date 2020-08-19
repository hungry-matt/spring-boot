package com.example.book.springboot.web;

import com.example.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class IndexContoroller {

    private final PostsService postsService;

    //mustache 의존성 추가로 앞의 경로와 뒤의 파일 확장자가 자동으로 지정 된다.
    // /resourece/templates/index.mustache
    @GetMapping("/")
    public String index(Model model) {
        //Service Layer에서 List<PostsListResponsDto> 를 반환하는 findAllDesc()를 model에 담아 View로 전달 한다.
        //Model : 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장. findAllDesc()로 가져온 결과를 posts로 전달.
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

}
