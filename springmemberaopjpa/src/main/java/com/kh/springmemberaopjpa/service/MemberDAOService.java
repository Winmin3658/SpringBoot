package com.kh.springmemberaopjpa.service;

import java.util.List;

import com.kh.springmemberaopjpa.domain.Member;

public interface MemberDAOService {

    public void insert(Member member) throws Exception;

    public Member select(Member member) throws Exception;

    public void update(Member member) throws Exception;

    public void delete(Member member) throws Exception;

    public List<Member> selectAll() throws Exception;
}
