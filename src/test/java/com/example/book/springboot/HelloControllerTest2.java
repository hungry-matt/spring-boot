package com.example.book.springboot;

import com.example.book.springboot.config.auth.SecurityConfig;
import com.example.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//스프링 부트 테스트와 Junit 사이에 연결자 역할.
@RunWith(SpringRunner.class)
//Web 에 집중되어 있는 애노테이션
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }
)
public class HelloControllerTest2 {
    @Autowired
    //이 클래스를 통해 http get, post 등에 대한 api 테스트를 할 수 있다.
    //테스트에 필요한 기능을 가진 객체이며 스프링 MVC 동작을 재현할 수 있다.
    private MockMvc mvc;

    @WithMockUser(roles="USER")
    @Test
    public void test() throws Exception {
        String hello = "hello";

        //perform : 요청을 전송하는 역할.
        mvc.perform(get("/hello"))
                //andExpect : 응답을 검증하는 역할.
                //status : 응답 상태 코드 검증.
                .andExpect(status().isOk())
                //content : 응답 정보 검증.
                .andExpect(content().string(hello))
                //andDo : 요청/응답 메세지 확인.
                .andDo(MockMvcResultHandlers.print());
    }
}
