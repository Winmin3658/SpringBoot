package com.zeus.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.zeus.domain.Board;

import ch.qos.logback.core.model.Model;
import lombok.extern.java.Log;


// 사용자 정보를 받는다. 해당되는 db 연동한다. 뷰를 불러준다.
@Log
@Controller
public class Test2Controller {
    // gohome06 get 요청 => 디비 연동 처리하고 => /gohome05 redirect =>
    // gohome05 요청 => gohome07 view Resolver 통해서 보여준다
    @GetMapping("/sub/gohome06")
    public String gohome06() {
        log.info("/sub/gohome06");

        return "redirect:/sub/gohome05";
    }
    // gohome05 요청 => gohome07 view Resolver 통해서 보여준다
    @GetMapping("/sub/gohome05")
    public String gohome05() {
        log.info("gohome05");

        return "sub/gohome07";
    }

    @GetMapping(value = "/gohome08")
    public Map<String, Board> home08(Model model) {
        log.info("자바빈즈 클래스 타입 home08");
        Map<String, Board> map = new HashMap<>();
        Board board = new Board();
        board.setBoardNo(20);
        map.put("key1", board);
        
        Board board2 = new Board();
        board2.setBoardNo(30);
        map.put("key2", board2);

        return map;
    }

}
