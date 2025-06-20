package com.kh.springmybatismemberproject.mapper;

import java.util.List;

import com.kh.springmybatismemberproject.domain.MybatisMember;

public interface MemberDAO {

    // 게시판 삽입
    public void insert(MybatisMember member) throws Exception;

    // 게시판 출력(one)
    public MybatisMember select(MybatisMember member) throws Exception;
    
    // 게시판 수정
    public void update(MybatisMember member) throws Exception;

    // 게시판 삭제
    public void delete(MybatisMember member) throws Exception;

    // 게시판 출력(All 전체)
    public List<MybatisMember> selectAll() throws Exception;
}
