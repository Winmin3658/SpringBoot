package com.kh.springbootaop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.springbootaop.domain.AOPBoard;

@Mapper
public interface BoardDAO {

    // 게시판 삽입
    public void insert(AOPBoard board) throws Exception;

    // 게시판 출력(one)
    public AOPBoard select(AOPBoard board) throws Exception;
    
    // 게시판 수정
    public void update(AOPBoard board) throws Exception;

    // 게시판 삭제
    public void delete(AOPBoard board) throws Exception;

    // 게시판 출력(All 전체)
    public List<AOPBoard> selectAll() throws Exception;
}
