package com.kh.springbootsecurity.mapper;

import java.util.List;

import com.kh.springbootsecurity.domain.Member;
import com.kh.springbootsecurity.domain.MemberAuth;

public interface MemberDAO {

    // 회원 삽입
    public void insert(Member member) throws Exception;

    // 회원 권한 삽입
    public void insertAuth(MemberAuth memberAuth) throws Exception;

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
}
