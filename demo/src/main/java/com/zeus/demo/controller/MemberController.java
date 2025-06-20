package com.zeus.demo.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.zeus.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping
public class MemberController {

    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String registerForm() {
        log.info("registerForm");
        return "registerForm";
    }
    @PostMapping(value = "/register")
    public String register(Member member, int userId) {
        log.info("register");
        log.info("userId = " + userId);
        log.info("member = " + member);
        log.info("member = " + member.getDateOfBirth());
        return "member/success";
    }
    @PostMapping(value = "/registerBoard")
    public String registerBoard(Member member) {
        log.info("registerBoard");
        log.info("ember.getUserId() = " + member.getUserId());
        log.info("ember.getPassword() = " + member.getPassword());
        log.info("ember.getDateOfBirth() = " + member.getDateOfBirth());
        log.info("member.getBoard().getBoardNo() = " + member.getBoard().getBoardNo());
        return "member/success";
    }
    @PostMapping(value = "/registerSelect")
    public String registerSelect(List<String> nationality) {
        log.info("registerSelect");
        for(int i = 0; i < nationality.size(); i++) {
            log.info("nationality = " + nationality.get(i));
        }
        return "member/success";
    }
    @PostMapping(value = "/registerFileupload")
    public String registerFileupload(MultipartFile[] picture) throws IllegalStateException, IOException {
        log.info("registerFileupload");

        for (MultipartFile data : picture) {
            log.info("serverUseName: " + data.getName());
            log.info("originalName: " + data.getOriginalFilename());
            log.info("size: " + data.getSize());
            log.info("contentType: " + data.getContentType());
            data.transferTo(new File("/Users/iseungmin/eclipse-workspace/SpringBootUploadFile/"+data.getOriginalFilename()));
        }
        return "member/success";
    }
}

