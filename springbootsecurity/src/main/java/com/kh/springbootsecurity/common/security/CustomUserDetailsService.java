package com.kh.springbootsecurity.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kh.springbootsecurity.common.security.domain.CustomUser;
import com.kh.springbootsecurity.domain.Member;
import com.kh.springbootsecurity.mapper.MemberDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    private MemberDAO memberDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("Load User By UserName : " + userName);
        
        // userName은 사용자명이 아니라 사용자 아이디이다.
        Member member = new Member();
        member.setId(userName);
        Member _member = null;
        try {
            _member = memberDAO.selectJoin(member);
            log.info("queried by member mapper: " + _member);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (_member == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + userName);
        }
        return new CustomUser(_member);

    }
}
