package com.kh.image_shop.mapper;

import java.util.List;

import com.kh.image_shop.domain.Member;
import com.kh.image_shop.domain.MemberAuth;

public interface MemberMapper {

    public void create(Member member) throws Exception;

    public void createAuth(MemberAuth memberAuth) throws Exception;

    public void deleteAuth(int userNo) throws Exception;

    public List<Member> list() throws Exception;

    public Member read(int userNo) throws Exception;

    public void update(Member member) throws Exception;

    public void modifyAuth(MemberAuth memberAuth) throws Exception;

    public void delete(int userNo);

    public int countAll() throws Exception;

    public Member readByUserId(String userId);

}
