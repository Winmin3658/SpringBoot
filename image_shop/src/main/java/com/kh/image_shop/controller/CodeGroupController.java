package com.kh.image_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.image_shop.domain.CodeGroup;
import com.kh.image_shop.service.CodeGroupService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;





@Slf4j
@Controller
@RequestMapping("/codegroup")
public class CodeGroupController {

    @Autowired
    private CodeGroupService service;

    // 등록페이지
    @GetMapping("/register")
    public String registerForm(HttpServletRequest request,Model model) throws Exception{
        log.info("요청 URI = {}", request.getRequestURI());
        CodeGroup codeGroup = new CodeGroup();
        model.addAttribute("codeGroup", codeGroup);
        return "codegroup/register";
    }

    @PostMapping("/register")
    public String register(CodeGroup codeGroup, RedirectAttributes rttr) throws Exception{
        service.register(codeGroup);
        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/codegroup/list";
    }
    
    // 목록 페이지
    @GetMapping("/list")
    public String list(Model model) throws Exception{
        model.addAttribute("list", service.list());
        return "codegroup/list";
    }
    
    // 상세 페이지
    @GetMapping("/read")
    public String read(String groupCode, Model model) throws Exception{
        model.addAttribute(service.read(groupCode));
        return "codegroup/read";
    }

    //수정 페이지
    @GetMapping("/modify")
    public String modifyForm(String groupCode, Model model) throws Exception{
        model.addAttribute(service.read(groupCode));
        return "codegroup/modify";
    }
    
    @PostMapping("/modify")
    public String modify(CodeGroup codeGroup, RedirectAttributes rttr) throws Exception{
        service.modify(codeGroup);
        rttr.addAttribute("msg", "SUCCESS");
        return "redirect:/codegroup/list";
    }
    
    @PostMapping("/remove")
    public String remove(CodeGroup codeGroup, RedirectAttributes rttr) throws Exception{
        service.remove(codeGroup);
        rttr.addAttribute("msg", "SUCCESS");
        return "redirect:/codegroup/list";
    }

    



}
