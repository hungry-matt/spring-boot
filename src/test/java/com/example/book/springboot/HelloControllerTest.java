package com.example.book.springboot;

import com.example.book.springboot.config.auth.SecurityConfig;
import com.example.book.springboot.web.HelloController;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//스프링 부트 테스트와 Junit 사이에 연결자 역할.
@RunWith(SpringRunner.class)
//Web(Spring mvc)에 집중되어 있는 어노테이션
//선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있다.
//Service, Repository 는 사용 불가.
@WebMvcTest(controllers = HelloController.class,
        // @WebMvcTest는 WebSecurityConfigurerAdapter, WebMvcConfigurer, @ControllerAdvice, @Controller를 읽는다.
        // 하지만 Service, Repository는 스캔 대상이 아니기 때문에 SecurityConfig는 읽었지만 CustomOAuth2UserService는 읽을수가 없다.
        // 그래서 다음과 같이 스캔 대상에서 SecurityConfig를 제외 하였다.
        excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }
        // @WebMvcTest의 secure 옵션은 2.1부터 Deprecated 되었다.
)
public class HelloControllerTest {

    //스프링 빈 주입.
    @Autowired
    //스프링 mvc 테스트의 시작점.
    //이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.
    private MockMvc mvc;

    @WithMockUser(roles="USER")
    @Test
    public void hello_return() throws Exception {
        String hello = "hello";

        //MockMvc 를 통해 /hello 주소로 HTTP Get 요청.
        mvc.perform(get("/hello"))
                //mvc.perform 의 결과를 검증 한다.
                //status 가 200 인지 검증.
                .andExpect(status().isOk())
                //응답 본문의 내용을 검증한다.
                .andExpect(content().string(hello))
                //test 응답 결과에 대한 모든 내용 출력.
                .andDo(MockMvcResultHandlers.print());
    }

    @WithMockUser(roles="USER")
    @Test
    public void hell_dto_test() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("name", name)
                        .param("amount", String.valueOf(amount))
                )
                //jsonPath : JSON 응답값을 필드별로 검증 할 수 있는 메소드 이다.
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is(name)))
                .andExpect(jsonPath("$.amount", Matchers.is(amount)))
                .andDo(MockMvcResultHandlers.print());
    }
}
