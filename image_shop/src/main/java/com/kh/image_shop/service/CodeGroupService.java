package com.kh.image_shop.service;

import java.util.List;

import com.kh.image_shop.domain.CodeGroup;

public interface CodeGroupService {

    // 등록처리
    public void register(CodeGroup codeGroup) throws Exception;
    // 목록 페이지
    public List<CodeGroup> list() throws Exception;
    // 상세 페이지
    public CodeGroup read(String groupCode) throws Exception;
    // 수정 처리
    public void modify(CodeGroup codeGroup) throws Exception;
    // 삭제 처리
    public void remove(CodeGroup codeGroup) throws Exception;
}
