package com.kh.springmemberaopjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.springmemberaopjpa.domain.Member;
import com.kh.springmemberaopjpa.persistance.MemberRepository;

@Service
public class MemberDAOServiceImpl implements MemberDAOService {
    @Autowired
    private MemberRepository mr;

    @Override
    @Transactional
    public void insert(Member member) throws Exception {
        mr.save(member);
    }

    @Override
    @Transactional(readOnly = true)
    public Member select(Member member) throws Exception {
        return mr.getOne(member.getNo());
    }
    @Override
    @Transactional
    public void update(Member member) throws Exception {
        Member memberEntity = mr.getOne(member.getNo());
        memberEntity.setId(member.getId());
        memberEntity.setPw(member.getPw());
        memberEntity.setName(member.getName());
    }

    @Override
    @Transactional
    public void delete(Member member) throws Exception {
        mr.deleteById(member.getNo());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Member> selectAll() throws Exception {
        return mr.findAll(Sort.by(Direction.ASC, "no"));
    }
}
