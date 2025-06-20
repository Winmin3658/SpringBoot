package com.kh.springjdbcmember.service;

import java.util.List;

import com.kh.springjdbcmember.domain.*;

public interface MemberService {
    // 게시판 삽입
    public void insert(Member member) throws Exception;
    // 게시판 출력(one)
    public Member select(Member member) throws Exception;
    // 게시판 수정
    public void update(Member member) throws Exception;
    // 게시판 삭제
    public void delete(Member member) throws Exception;
    // 게시판 출력(전체)
    public List<Member> selectAll() throws Exception;
}

