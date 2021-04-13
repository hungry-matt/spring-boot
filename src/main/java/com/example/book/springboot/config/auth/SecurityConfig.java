package com.example.book.springboot.config.auth;

import com.example.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests() // URL별 권한 관리를 설정하는 옵션의 시작점.
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // 권한 관리 대상을 지정. USER 권한을 가진 사람만 해당 URL 접근 가능.
                    .anyRequest().authenticated() // 나머지 URL들은 모두 인증된 사용자만 허용.
                .and()
                    .logout()
                        .logoutSuccessUrl("/") // 로그아웃 성공시 설정된 주소로 이동.
                .and()
                    .oauth2Login() // OAuth2 로그인 기능에 대한 여러 설정의 진입점.
                        .userInfoEndpoint() // OAuth2 로그인 성공 시 사용자 정보를 가져올 때의 설정들을 담당.
                            .userService(customOAuth2UserService); // 로그인 성공 시 후속 조치를 담당할 UserService 인터페이스의 구현체 등록.
    }
}
