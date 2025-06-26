package com.kh.springbootsecurity.common.security;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommonController {
    @RequestMapping("/accessError")
    public String accessDenied(Authentication auth, Model model) {
        log.info("access Denied : " + auth);
        model.addAttribute("msg", "접근 불가");
        return "accessError";
    }
}
