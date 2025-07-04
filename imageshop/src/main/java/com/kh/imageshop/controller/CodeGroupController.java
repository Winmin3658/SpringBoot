package com.kh.imageshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.imageshop.domain.CodeGroup;
import com.kh.imageshop.service.CodeGroupService;

@Controller
@RequestMapping("/codegroup")
public class CodeGroupController {
    @Autowired
    private CodeGroupService service;

    // 등록 페이지
    @GetMapping("/register")
    public void registerForm(Model model) throws Exception {
        CodeGroup codeGroup = new CodeGroup();
        model.addAttribute(codeGroup);
    }

    // 등록 처리
    @PostMapping("/register")
    public String register(CodeGroup codeGroup, RedirectAttributes rttr)
    throws Exception {
        service.register(codeGroup);

        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/codegroup/list";
    }

    // 목록 페이지
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        model.addAttribute("list", service.list());
        return "codegroup/list";
    }

    // 상세 페이지
    @GetMapping("/read")
    public void read(String codeGroup, Model model) throws Exception {
        model.addAttribute(service.read(codeGroup));
    }

    // 수정 페이지
    @GetMapping("/modify")
    public void modifyForm(String groupCode, Model model) throws Exception {
        model.addAttribute(service.read(groupCode));
    }

    // 수정 처리
    @PostMapping("/modify")
    public String modify(CodeGroup codeGroup, RedirectAttributes rttr) throws Exception {
        service.modify(codeGroup);
        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/codegroup/list";
    }

    // 삭제 처리
    @PostMapping("/remove")
    public String remove(String codeGroup, RedirectAttributes rttr) throws Exception {
        service.remove(codeGroup);
        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/codegroup/list";
    }
}
