package com.kh.springbootsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.kh.springbootsecurity.common.security.CustomAccessDeniedHandler;
import com.kh.springbootsecurity.common.security.CustomLoginSuccessHandler;
import com.kh.springbootsecurity.common.security.CustomNoOpPasswordEncoder;
import com.kh.springbootsecurity.common.security.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
//SpringBootwebSecurityConfiguration.WebSecurityEnablerConfiguration 자동 설정 X
public class SecurityConfig {
    @Autowired
    private DataSource dataSource;
    
    @Bean
    //SpringBootwebSecurityConfiguration.SecurityFilterChainConfiguration: 자동 설정 X
    SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
        log.info("시큐리트 환경설정 시작");
        // csrf 토큰 비활성화
        http.csrf().disable();
        // 로그인 인가 정책
        //http.authorizeHttpRequests() 로 변경시키지 말 것
        http.authorizeRequests().requestMatchers("/board/list").permitAll();
        http.authorizeRequests().requestMatchers("/board/register").hasRole("MEMBER");
        http.authorizeRequests().requestMatchers("/notice/list").permitAll();
        http.authorizeRequests().requestMatchers("/notice/register").hasRole("ADMIN");
        // 로그인 처리 자동 설정 화면 사용, 이후 만든 로그인 화면으로 대체(인증정책)
        // username: test, password: 123456, role: Manager

        // 로그인(인증, 인가)정책 실패했을 때 (403페이지, formLogin()) => 설정한 인증, 인가 실패화면 대체
        // 접근 거부 처리자에 대한 페이지 이동 URI를 지정
        // http.exceptionHandling().accessDeniedPage("/accessError");

        // 등록한 CustomAccessDeniedHandler.java를 접근 거부 처리자로 지정한다.
        http.exceptionHandling().accessDeniedHandler(createAccessDeniedHandler());

        // 1) 로그인 인증 정책
        //http.formLogin();
        // 2) 사용자가 정의한 로그인 페이지 요청(http://~:8080/login)
        // http.formLogin().loginPage("/login");
        // 3) 개발자가 정의한 로그인 페이지의 URI를 지정한다.
        // 로그인 성공 후 (시큐리티가 사용자 정보를 이미 세팅 완료, 인증, 인가 설정: VO => User) 처리를 담당하는 처리자로 지정한다.
        http.formLogin().loginPage("/login").successHandler(createAuthenticationSuccessHandler());

        // 로그아웃 처리를 위한 URI를 지정하고, 로그아웃한 후에 세션을 무효화 한다.
        http.logout().logoutUrl("/logout").invalidateHttpSession(true);

        return http.build();
    }

    /* @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 지정된 아이디와 패스워드로 로그인이 가능하도록 설정한다.
        auth.inMemoryAuthentication().withUser("member").
                          password("{noop}123456").roles("MEMBER");

               auth.inMemoryAuthentication().withUser("admin").
                          password("{noop}123456").roles("ADMIN", "MEMBER");
    } */

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(createUserDetailsService()).passwordEncoder(createPasswordEncoder());
    }

    // 스프링 시큐리티의 UserDetailsService를 구현한 클래스를 빈으로 등록한다.
    @Bean
    public UserDetailsService createUserDetailsService() {
        return new CustomUserDetailsService();
    }
    // 사용자가 정의한 비번 암호화 처리기를 빈으로 등록한다.
    @Bean
    public PasswordEncoder createPasswordEncoder() {
        return new CustomNoOpPasswordEncoder();
    }

    // CustomAccessDeniedHandler를 빈으로 등록한다.
    @Bean
    public AccessDeniedHandler createAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    // CustomLoginSuccessHandler를 빈으로 등록한다.
    @Bean
    public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
        return new CustomLoginSuccessHandler();
    }
}
