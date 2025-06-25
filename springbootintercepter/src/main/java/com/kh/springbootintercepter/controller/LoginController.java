package com.kh.springbootintercepter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.springbootintercepter.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
    @GetMapping(value = "/login")
    // 1. 사용자 요청 정보받기
    public String loginForm(Model model) {
        log.info("2번 LoginController loginForm start");
        // 2. 디비 연동(mapper 인터페이스 사용. 다형성 구현)
        // 3. 디비 연동 리턴값을 화면 전달(view resolver, redirect, forward, responseBody: json)
        return "login/loginForm";
    }
    @PostMapping("/login")
    public void login(Member member, Model model) {
        log.info("2번 LoginController login start");
        log.info("login userId = " + member.getUserId());
        log.info("login userPw = " + member.getUserPw());

        member.setUserName("제우스");
        member.setEmail("zeus@zeus.com");
        model.addAttribute("user", member);

    }
}
