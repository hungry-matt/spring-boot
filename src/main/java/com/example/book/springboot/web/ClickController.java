package com.example.book.springboot.web;

import com.example.book.springboot.domain.click.Click;
import com.example.book.springboot.service.posts.ClickService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ClickController {

    private final ClickService clickService;

    public ClickController(ClickService clickService) {
        this.clickService = clickService;
    }

    @GetMapping("/click")
    public String click() {
        return "click";
    }

    @ResponseBody
    @PostMapping("/api/click/v1")
    public Long save() {
        return clickService.save().getId();
    }

    @ResponseBody
    @GetMapping("/api/click/v1")
    public List<Click> findAllByCreatedDate() {
        return clickService.findAllByCreatedDate();
    }

}
