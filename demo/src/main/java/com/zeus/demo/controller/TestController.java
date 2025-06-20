package com.zeus.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zeus.domain.Board;

import lombok.extern.slf4j.Slf4j;


// 사용자 정보를 받는다. 해당되는 db 연동한다. 뷰를 불러준다.
@Slf4j
@Controller
//@Controller + @ResponseBody
public class TestController {
    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    // 클래스 선언할 때 @RestController 선언할경우 여기서 @ResponseBody 생략해도 된다.
    public String hello(String name) {
        return "hello" + name;
    }

    @RequestMapping(value = "/getBoard", method = RequestMethod.GET )
    public @ResponseBody Board getBoard() {
        Board board = new Board();
        board.setBoardNo(0);
        board.setTitle("Hello");
        board.setContent("zeus");
        board.setWriter("kdj");
        board.setRegDate(new Date());
    return board;
    }

}
