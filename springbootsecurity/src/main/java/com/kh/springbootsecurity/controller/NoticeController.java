package com.kh.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Log
@RequestMapping("/notice")
@Controller
public class NoticeController {
    @GetMapping("/list")
    public String list() {
        log.info("list : 모두가 접근 가능");
        return "notice/list";
    }
    @GetMapping("/register")
    public String registerForm() {
        log.info("registerForm : 로그인한 관리자만 접근 가능");
        return "notice/register";
    }
}
