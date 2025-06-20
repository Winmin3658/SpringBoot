package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.domain.Member;
import com.kh.repository.MemberDAO;

@Service
public class MemberServiceimpl implements MemberService {
	@Autowired
	// 의존성 주입
	private MemberDAO md;

	@Override
    @Transactional
	public void insert(Member member) throws Exception {
		md.insert(member);
	}

    @Override
    @Transactional
    public void update(Member member) throws Exception {
        md.update(member);
    }

	@Override
	public Member selectByNo(Member member) throws Exception {
		return md.selectByNo(member);
	}

    @Override
    public List<Member> selectAll() throws Exception {
        return md.selectAll();
    }

    @Transactional
	public void delete(Member member) throws Exception {
		md.delete(member);
	}

}

