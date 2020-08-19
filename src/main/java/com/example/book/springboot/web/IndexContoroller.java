package com.example.book.springboot.web;

import com.example.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("posts", postsService.findById(id));
        return "posts-update";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

}
