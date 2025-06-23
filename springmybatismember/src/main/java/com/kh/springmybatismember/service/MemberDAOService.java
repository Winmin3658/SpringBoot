package com.kh.springmybatismember.service;

import java.util.List;

import com.kh.springmybatismember.domain.Member;
import com.kh.springmybatismember.domain.MemberAuth;
import com.kh.springmybatismember.domain.MemberEmail;

public interface MemberDAOService {
    // 회원 삽입
    public void insert(Member member) throws Exception;

    // 회원 권한 삽입
    public void insertAuth(MemberAuth memberAuth) throws Exception;

    // 회원 권한 삽입
    public void insertEmail(MemberEmail memberEmail) throws Exception;

    // 회원 정보 출력(회원, 권한 조인)
    public List<Member> selectAll() throws Exception;

    // 회원 정보 출력
    public Member selectJoin(Member member) throws Exception;

    // 회원 정보 수정
    public void update(Member member) throws Exception;

    // 회원 정보 삭제
    public void delete(Member member) throws Exception;

    // 회원 권한 삭제
    public void deleteAuth(Member member) throws Exception;
    
    // 회원 권한 삭제
    public void deleteEmail(Member member) throws Exception;
}
