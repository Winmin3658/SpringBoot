package com.kh.springjdbcmember.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springjdbcmember.domain.Member;
import com.kh.springjdbcmember.service.MemberService;

import lombok.extern.slf4j.Slf4j;

// 게시판에서 공통의 주소는 /board 가진다
// Ajax 방식이다. (@RestController)
// 데이타베이스를 연동한다

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    // DB 연동
    @Autowired
    private MemberService memberService;

    // 게시판 입력 화면요청
    @GetMapping("/registerForm")
    public String registerForm(Member member) throws Exception {
        log.info("registerForm");
        return "member/register";
    }

    // 게시판 내용 DB입력
    @PostMapping("/register")
    public String register(Member member, Model model) throws Exception {
        log.info("register");
        memberService.insert(member);
        model.addAttribute("msg", "등록이 완료되었습니다.");
        return "member/success";
    }

    // 게시판 내용 전체 출력
    @GetMapping("/list")
    public void list(Model model) throws Exception {
        log.info("list");
        model.addAttribute("list", memberService.selectAll());
    }

    // 게시판 출력(No)
    @RequestMapping("/read")
    public String read(Member member, Model model) throws Exception {
        log.info("read");
        model.addAttribute(memberService.select(member));
        return "member/read";
    }

    // 게시판 삭제
    @PostMapping("/remove")
    public String remove(Member member, Model model) throws Exception {
        log.info("remove");
        memberService.delete(member);
        model.addAttribute("msg", "삭제가 완료되었습니다.");
        return "member/success";
    }

    // 게시판 수정 화면 요청
    @GetMapping("/modify")
    public String modifyForm(Member member, Model model) throws Exception {
        log.info("modifyForm");
        model.addAttribute(memberService.select(member));
        return "member/modify";
    }

    // 게시판 수정내용 DB 저장
    @PostMapping("/modify")
    public String modify(Member member, Model model) throws Exception {
        log.info("modify");
        memberService.update(member);
        model.addAttribute("msg", "수정 완료되었습니다.");
        return "member/success";
    }
}
