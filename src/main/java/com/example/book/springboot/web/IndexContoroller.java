package com.example.book.springboot.web;

import com.example.book.springboot.config.auth.dto.SessionUser;
import com.example.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexContoroller {

    private final PostsService postsService;

    private final HttpSession httpSession;

    // mustache 의존성 추가로 앞의 경로와 뒤의 파일 확장자가 자동으로 지정 된다.
    // /resourece/templates/index.mustache
    @GetMapping("/")
    public String index(Model model) {
        // Service Layer에서 List<PostsListResponsDto> 를 반환하는 findAllDesc()를 model에 담아 View로 전달 한다.
        // Model : 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장. findAllDesc()로 가져온 결과를 posts로 전달.
        model.addAttribute("posts", postsService.findAllDesc());

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        String url = "posts-update";
        try{
            model.addAttribute("posts", postsService.findById(id));
        } catch (Exception e) {
            url = "redirect:/";
        }
        return url;
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

}
