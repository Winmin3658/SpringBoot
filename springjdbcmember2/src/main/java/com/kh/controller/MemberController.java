package com.kh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.domain.Member;
import com.kh.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	// 게시판 입력화면 요청
	@GetMapping("/registerForm")
	public String registerForm(Member member) throws Exception {
		log.info("registerForm");
		return "member/register";
	}

	// 게시판 내용 입력
	@PostMapping("/register")
	public String register(Member member, Model model) throws Exception {
		log.info("register");
		memberService.insert(member);
		model.addAttribute("msg", "등록이 완료되었습니다.");
		return "member/success";
	}

    // 게시판 수정 화면 요청
	@GetMapping("/modify")
	public void modifyForm(Member member, Model model) throws Exception {
		log.info("modifyForm");
		model.addAttribute(memberService.selectByNo(member));
	}

	// 게시판 수정내용 저장
	@PostMapping("/modify")
	public String modify(Member member, Model model) throws Exception {
		log.info("modify");
		memberService.update(member);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "member/success";
	}
	
	// 게시판 내용 memberNo로 조회
	@GetMapping("/read")
	public void read(Member member, Model model) throws Exception {
		log.info("read");
		model.addAttribute(memberService.selectByNo(member));
	}

    // 게시판 내용 전체 조회
	@GetMapping("/list")
	public void list(Model model) throws Exception {
		log.info("list");
		model.addAttribute("list", memberService.selectAll());
	}

	// 게시판 삭제
	@PostMapping("/remove")
	public String remove(Member member, Model model) throws Exception {
		log.info("remove");
		memberService.delete(member);
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "member/success";
	}

}
