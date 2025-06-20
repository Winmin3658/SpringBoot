package com.board.springjdbcboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.springjdbcboard.domain.Board;

import lombok.extern.slf4j.Slf4j;
import com.board.springjdbcboard.service.BoardService;

// 게시판에서 공통의 주소는 /board 가진다
// Ajax 방식이다. (@RestController)
// 데이타베이스를 연동한다

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    // DB 연동
    @Autowired
    private BoardService boardService;

    // 게시판 입력 화면요청
    @GetMapping("/registerForm")
    public String registerForm(Board board) throws Exception {
        log.info("registerForm");
        return "board/register";
    }

    // 게시판 내용 DB입력
    @PostMapping("/register")
    public String register(Board board, Model model) throws Exception {
        log.info("register");
        boardService.insert(board);
        model.addAttribute("msg", "등록이 완료되었습니다.");
        return "board/success";
    }

    // 게시판 내용 전체 출력
    @GetMapping("/list")
    public void list(Model model) throws Exception {
        log.info("list");
        model.addAttribute("list", boardService.selectAll());
    }

    // 게시판 출력(No)
    @RequestMapping("/read")
    public String read(Board board, Model model) throws Exception {
        log.info("read");
        model.addAttribute(boardService.select(board));
        return "board/read";
    }

    // 게시판 삭제
    @PostMapping("/remove")
    public String remove(Board board, Model model) throws Exception {
        log.info("remove");
        boardService.delete(board);
        model.addAttribute("msg", "삭제가 완료되었습니다.");
        return "board/success";
    }

    // 게시판 수정 화면 요청
    @GetMapping("/modify")
    public String modifyForm(Board board, Model model) throws Exception {
        log.info("modifyForm");
        model.addAttribute(boardService.select(board));
        return "board/modify";
    }

    // 게시판 수정내용 DB 저장
    @PostMapping("/modify")
    public String modify(Board board, Model model) throws Exception {
        log.info("modify");
        boardService.update(board);
        model.addAttribute("msg", "수정 완료되었습니다.");
        return "board/success";
    }
}
