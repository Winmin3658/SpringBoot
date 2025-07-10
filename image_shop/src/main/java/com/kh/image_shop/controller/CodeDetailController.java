package com.kh.image_shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.image_shop.domain.CodeDetail;
import com.kh.image_shop.domain.CodeLabelValue;
import com.kh.image_shop.service.CodeDetailService;
import com.kh.image_shop.service.CodeService;

@Controller
@RequestMapping("/codedetail")
public class CodeDetailController {
    @Autowired
    private CodeDetailService codeDetailService;
    @Autowired
    private CodeService codeService;

    // 등록 페이지
    @GetMapping("/register")
    public String registerForm(Model model) throws Exception {
        CodeDetail codeDetail = new CodeDetail();
        model.addAttribute(codeDetail);
        List<CodeLabelValue> groupCodeList = codeService.getCodeGroupList();
        model.addAttribute("groupCodeList", groupCodeList);
        return "codedetail/register";
    }

    // 등록 처리
    @PostMapping("/register")
    public String register(CodeDetail codeDetail, RedirectAttributes rttr) throws Exception {
        codeDetailService.register(codeDetail);
        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/codedetail/list";
    }

    // 목록 페이지
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        model.addAttribute("list", codeDetailService.list());
        return "codedetail/list";
    }

    // 상세 페이지
    @GetMapping("/read")
    public String read(CodeDetail codeDetail, Model model) throws Exception {
        model.addAttribute(codeDetailService.read(codeDetail));
        List<CodeLabelValue> groupCodeList = codeService.getCodeGroupList();
        model.addAttribute("groupCodeList", groupCodeList);
        return "codedetail/read";
    }

    // 수정 페이지
    @GetMapping("/modify")
    public String modifyForm(CodeDetail codeDetail, Model model) throws Exception {
        model.addAttribute(codeDetailService.read(codeDetail));
        // 그룹코드 목록을 조회하여 뷰에 전달
        List<CodeLabelValue> groupCodeList = codeService.getCodeGroupList();
        model.addAttribute("groupCodeList", groupCodeList);
        return "codedetail/modify";
    }

    // 수정 처리
    @PostMapping("/modify")
    public String modify(CodeDetail codeDetail, RedirectAttributes rttr) throws Exception {
        codeDetailService.modify(codeDetail);
        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/codedetail/list";
    }

    // 삭제 처리
    @PostMapping("/remove")
    public String remove(CodeDetail codeDetail, RedirectAttributes rttr) throws Exception {
        codeDetailService.remove(codeDetail);
        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/codedetail/list";
    }
}
