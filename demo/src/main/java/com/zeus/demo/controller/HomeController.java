package com.zeus.demo.controller;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.demo.DemoApplication;
import com.zeus.domain.Board;

import lombok.extern.java.Log;


// 사용자 정보를 받는다. 해당되는 db 연동한다. 뷰를 불러준다.
@Log
@Controller
public class HomeController {

    private final DemoApplication demoApplication;

    HomeController(DemoApplication demoApplication) {
        this.demoApplication = demoApplication;
    }
    // http://127.0.0.1:8080/home get방식
    // Model, (Request, Session, Application: 생명주기)
    @GetMapping(value = "/home")
    public String home(Locale locale, Model model) {
        log.info("여기는 HomeController home() 입니다." + locale.toString());
        log.info("여기는 HomeController home() 입니다." + model.toString());
        // 디비 연동하지 않는다
        // 뷰를 불러준다(~: view Resolver)
        Date date = new Date();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formatDate = df.format(date);
        // 모델(Request)
        model.addAttribute("serverTime", formatDate);

        return "home01";
    }
    @GetMapping(value = "/sub")
    public String home(Model model) {
        Board board = new Board(10, "kdj", "zeus", "김동진", null);
        model.addAttribute("board", board);
        return "home01";
    }

    @GetMapping(value = "/home03")
    public String home03() {
        return "home03";
    }

    @GetMapping(value = "/home04")
    public String home04(Locale locale, Model model) {
        // 문자열 배열, ArrayList => VO, DB
        String[] name = {"홍길동", "제우스", "톰캣"};
        List<String> nameList = Arrays.asList("홍길동", "제우스", "톰캣");
        model.addAttribute("name", name);
        model.addAttribute("nameList", nameList);
        return "home04";
    }
    @GetMapping(value = "/home05")
    public String home05(Model model) {
        // HashMap 만들어서(디비, 사용자 입력) 화면으로 보냄. id, pwd, email, name, date
        Map memMap = new HashMap<>();
        memMap.put("id", "rlaeogus");
        memMap.put("pwd", "123456");
        memMap.put("email", "rlaeogus@naver.com");
        memMap.put("name", "kdj");
        memMap.put("date", new Date());
        model.addAttribute("mMap", memMap);
        return "home05";
    }
    
    @GetMapping("/home0303")
        public String home0303(Model model) {
            Board board = new Board();
            board.setTitle(" ");
            model.addAttribute(board);
            return "home0303";
    }

    @GetMapping("/home0202")
        public String home0202(Model model) {
            Board board = new Board();
            board.setTitle("spring boot2");
            model.addAttribute("board", board);
            return "home0202";
    }
    // WEB-INF/view/home0901.jsp, get(함수명은 오버로딩 위배조건 안 되면 됨)
    @GetMapping("/home0901")
        public String home0901() {
            return "home0901";
    }

    // WEB-INF/view/boardjstl/search.jsp, get, parameter value, model 전달해서 출력
    @RequestMapping("/boardjstl/search")
        public void search1(Board board, String title, Model model) {
        log.info("search keyword = " + board);
        log.info("search keyword title = " + title);
        model.addAttribute("board", board);
    }
    @RequestMapping("/boardjstl/list")
        public void list() {
        log.info("/boardjstl/list");
    }
    @RequestMapping("/home1001")
        public void home1001() {
        log.info("/home1001");
    }
}
