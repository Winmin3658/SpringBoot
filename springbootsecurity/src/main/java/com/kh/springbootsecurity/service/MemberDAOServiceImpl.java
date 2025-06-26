package com.kh.springbootsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.springbootsecurity.domain.Member;
import com.kh.springbootsecurity.domain.MemberAuth;
import com.kh.springbootsecurity.mapper.MemberDAO;

@Service
public class MemberDAOServiceImpl implements MemberDAOService {
    @Autowired
    private MemberDAO memberDAO;

    @Override
    @Transactional
    // 회원 입력 처리, 회원 권한 처리
    public void insert(Member member) throws Exception {
        // 회원 등록 처리
        memberDAO.insert(member);
        // 회원 권한 객체 생성
        MemberAuth memberAuth = new MemberAuth();
        // 회원 권한 설정
        memberAuth.setNo(member.getNo());
        memberAuth.setAuth("ROLE_USER");
        // 회원 권한 처리
        memberDAO.insertAuth(memberAuth);
    }

    @Override
    @Transactional
    // 회원 권한 입력 처리
    public void insertAuth(MemberAuth memberAuth) throws Exception {
        memberDAO.insertAuth(memberAuth);
    }

    @Override
    // 회원 정보 출력(회원, 권한 조인)
    public Member selectJoin(Member member) throws Exception {
        return memberDAO.selectJoin(member);
    }
    
    @Override
    // 회원 정보 전체 출력
    public List<Member> selectAll() throws Exception {
        return memberDAO.selectAll();
    }

    @Override
    @Transactional
    // 회원 정보 수정
    public void update(Member member) throws Exception {
        // 회원 정보 수정 입력
        memberDAO.update(member);
        // 회원 권한 삭제
        memberDAO.deleteAuth(member);

        List<MemberAuth> authList = member.getAuthList();
        for (int i = 0; i < authList.size(); i++) {
            MemberAuth memberAuth = authList.get(i);
            String auth = memberAuth.getAuth();
            if (auth == null) {
                continue;
            }
            if (auth.trim().length() == 0) {
                continue;
            }
            memberAuth.setNo(member.getNo());
            memberDAO.insertAuth(memberAuth);
        }
    }

    @Override
    @Transactional
    // 회언 정보 삭제
    public void delete(Member member) throws Exception {
        memberDAO.deleteAuth(member);
        memberDAO.delete(member);
    }

    @Override
    @Transactional
    // 회원 권한 삭제
    public void deleteAuth(Member member) throws Exception {
        memberDAO.deleteAuth(member);
    }

}
