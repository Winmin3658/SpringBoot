package com.kh.springjdbcmember.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.springjdbcmember.domain.Member;
import com.kh.springjdbcmember.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
    // 의존성 주입
    @Autowired
    private MemberDAO memberDAO;

    @Override
    @Transactional
    public void insert(Member member) throws Exception {
        memberDAO.insert(member);
    }

    @Override
    public Member select(Member member) throws Exception {
        return memberDAO.select(member);
    }

    @Override
    public void update(Member member) throws Exception {
        memberDAO.update(member);
    }

    @Override
    public void delete(Member member) throws Exception {
        memberDAO.delete(member);
    }

    @Override
    public List<Member> selectAll() throws Exception {
        return memberDAO.selectAll();
    }

}