package com.kh.springmybatismember.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.springmybatismember.domain.Member;
import com.kh.springmybatismember.domain.MemberAuth;
import com.kh.springmybatismember.domain.MemberEmail;
import com.kh.springmybatismember.mapper.MemberDAO;

@Service
public class MemberDAOServiceImpl implements MemberDAOService {
    @Autowired
    private MemberDAO md;
    
    @Override
    @Transactional
    // 회원 삽입
    public void insert(Member member) throws Exception {
        md.insert(member);
        // Auth 부분
        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setNo(member.getNo());
        memberAuth.setAuth("ROLE_USER");
        md.insertAuth(memberAuth);
        // Email 부분
        MemberEmail memberEmail = new MemberEmail();
        memberEmail.setNo(member.getNo());
        memberEmail.setEmail("ROLE_USER");
        md.insertEmail(memberEmail);
    }

    @Override
    @Transactional
    // 회원 권한 삽입
    public void insertAuth(MemberAuth memberAuth) throws Exception {
        md.insertAuth(memberAuth);
    }

    @Override
    @Transactional
    // 회원 권한 삽입
    public void insertEmail(MemberEmail memberEmail) throws Exception {
        md.insertEmail(memberEmail);
    }
    @Override
    @Transactional
    // 회원 정보 출력(회원, 권한 조인)
    public List<Member> selectAll() throws Exception {
        return md.selectAll();
    }

    @Override
    // 회원 정보 출력
    public Member selectJoin(Member member) throws Exception {
        return md.selectJoin(member);
    }
    @Override
    @Transactional
    // 회원 정보 수정
    public void update(Member member) throws Exception {
        md.update(member);
        md.deleteAuth(member);
        md.deleteEmail(member);

        // Auth 부분
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
            md.insertAuth(memberAuth);
        }

        // Email 부분
        List<MemberEmail> emailList = member.getEmailList();
        for (int i = 0; i < emailList.size(); i++) {
            MemberEmail memberEmail = emailList.get(i);
            String email = memberEmail.getEmail();
            if (email == null) {
                continue;
            }
            if (email.trim().length() == 0) {
                continue;
            }
            memberEmail.setNo(member.getNo());
            md.insertEmail(memberEmail);
        }
    }

    @Override
    @Transactional
    // 회원 정보 삭제
    public void delete(Member member) throws Exception {
        md.deleteAuth(member);
        md.deleteEmail(member);
        md.delete(member);
    }

    @Override
    @Transactional
    // 회원 권한 삭제
    public void deleteAuth(Member member) throws Exception {
        md.deleteAuth(member);
    }
    
    @Override
    @Transactional
    // 회원 권한 삭제
    public void deleteEmail(Member member) throws Exception {
        md.deleteEmail(member);
    }
}
