package com.kh.springbootsecurity.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestParam;


@Log
@MapperScan("com.kh.springframework.mapper")
@Controller
public class LoginController {
    // 에러 메시지와 로그아웃 메시지를 파라미터로 사용한다.
    @GetMapping("/login")
    public String loginForm(String error, String logout, Model model) {
    log.info("error: " + error);
    log.info("logout: " + logout);
    if (error != null) {
        model.addAttribute("error", "로그인 에러!!!");
    }
    if (logout != null) {
        model.addAttribute("logout", "로그아웃!!!");
    }
    return "login/loginForm";
    }

    @GetMapping("/logout")
    public String logoutForm() {
        log.info("logoutForm");
        return "login/logoutForm";
    }
    
}
