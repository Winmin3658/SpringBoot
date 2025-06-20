package com.zeus.demo.controller;



import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.domain.Board;
import com.zeus.domain.Member;

import lombok.extern.java.Log;



// 사용자 정보를 받는다. 해당되는 db 연동한다. 뷰를 불러준다.
@Log
@Controller
@RequestMapping(value="/board")
public class BoardController {
    //http://~:8080/board/read/100 -> url 마지막 경로(path)값을 int boardNo 입력하고, /board/read.jsp
    // Model 전송하고 출력화면을 전송
    @GetMapping("/read/{boardNo}")
    public String getRead(@PathVariable("boardNo") String boardNo, Model model) {
        log.info("게시글 번호: "+ boardNo);
        model.addAttribute("boardNo", boardNo);
        return "/board/read";
    }

    @GetMapping(value = "/ajaxHome")
    public String ajaxHome() {
        log.info("headers 속성 매핑 ajaxHome");
        return "/board/ajaxHome";
    }
    @GetMapping(value = "/ajaxArrayHome")
    public String ajaxArrayHome() {
        log.info("headers 속성 매핑 ajaxArrayHome");
        return "/board/ajaxArrayHome";
    }
    @GetMapping(value = "/xmlHttpRequest")
    public String xmlHttpRequest() {
        log.info("headers 속성 매핑 xmlHttpRequest");
        return "/board/xmlHttpRequest";
    }
    @GetMapping(value = "/ajaxHomeAccpet")
    public String ajaxHomeAccpetRequest() {
        log.info("Accept 속성 매핑 ajaxHomeAccpet");
        return "/board/ajaxHomeAccpet";
    }

    @PutMapping(value = "/{boardNo}")
    public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
        log.info("수정 Board = " +board);
        log.info("수정 Board No = "+boardNo);
        // 디비 연동 => 업데이트 => 리턴값 주고 => 리턴값을 ResponseEntity<String> 클라이언트 전송
        ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        return entity;
    }
    // produces 속성값에 클라이언트에 보낼 "application/xml" 미디어 타입을 지정.
    @GetMapping(value = "/{boardNo}", produces = "application/xml")
    public ResponseEntity<Board> readToXml(@PathVariable("boardNo") int boardNo) {
    log.info("readToXml");
    Board board = new Board();
    board.setBoardNo(boardNo);
    board.setTitle("제목");
    board.setContent("내용입니다.");
    board.setWriter("홍길동");
    board.setRegDate(new Date());
    ResponseEntity<Board> entity = new ResponseEntity<Board>(board,
    HttpStatus.OK);
    return entity;
    }

    @PostMapping(value = "/{boardNo}", consumes = "application/json")
    public ResponseEntity<String> modifyPost(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
        log.info("수정 post Board = " +board);
        log.info("수정 post Board No = "+boardNo);
        // 디비 연동 => 업데이트 => 리턴값 주고 => 리턴값을 ResponseEntity<String> 클라이언트 전송
        ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        return entity;
    }

    // X-HTTP-Method-Override 요청 헤더 값을 "PUT"으로 지정
    @PutMapping(value = "/{boardNo}", headers = "X-HTTP-Method-Override=PUT")
    public ResponseEntity<String> modifyByHeader(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
        log.info("수정 Header Board = " +board);
        log.info("수정 Header Board No = "+boardNo);
        ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        return entity;
    }

    @PostMapping(value = "/{boardNo}", consumes = "application/json")
    public ResponseEntity<String> registerArray(@RequestBody List<Member> memberList) {
        log.info("registerArray");
        for (Member member : memberList) {
            log.info("userId = " + member.getUserId());
            log.info("password = " + member.getPassword());
        }
        // 디비 연동 => 업데이트 => 리턴값주고 => 리턴값을 ResponseEntity<String> 클라이언트 전송
        ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        return entity;
    }

}