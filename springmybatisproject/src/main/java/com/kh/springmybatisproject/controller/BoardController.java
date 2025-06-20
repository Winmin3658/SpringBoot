package com.kh.springmybatisproject.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springmybatisproject.domain.MybatisBoard;
import com.kh.springmybatisproject.service.BoardDAOService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MapperScan(basePackages = "com.kh.springmybatisproject.mapper")
@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardDAOService service;

    // 게시판 입력화면 요청
    @GetMapping(value = "/register")
    public String registerForm(MybatisBoard board, Model model) throws Exception {
        model.addAttribute("board", board);
        log.info("registerForm");
        return "board/register";
    }

    // 게시판 디비입력 요청
    @PostMapping(value = "/register")
    public String register(MybatisBoard board, Model model) throws Exception {
        service.insert(board);
        model.addAttribute("msg",
                "등록이 완료되었습니다.");
        return "board/success";
    }

    // 게시판 리스트 화면 요청
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        log.info("list");
        model.addAttribute("list", service.selectAll());
        return "board/list";
    }

    // 게시판 상세 화면 요청
    @GetMapping(value = "/read")
    public String read(MybatisBoard board, Model model) throws Exception {
        model.addAttribute("board",service.select(board));
        return "board/read";
    }

    // 게시판 삭제 요청
    @PostMapping(value = "/remove")
    public String remove(MybatisBoard board, Model model) throws Exception {
        service.delete(board);
        model.addAttribute("msg", "삭제가 완료되었습니다.");
        return "board/success";
    }

    // 게시판 수정 화면 요청
    @GetMapping(value = "/modify")
    public String modifyForm(MybatisBoard board, Model model) throws Exception {
        model.addAttribute("board", service.select(board));
        return "board/modify";
    }

    // 게시판 수정 요청
    @PostMapping(value = "/modify")
    public String modify(MybatisBoard board, Model model) throws Exception {
        service.update(board);
        model.addAttribute("msg", "수정이 완료되었습니다.");
        return "board/success";
    }
}