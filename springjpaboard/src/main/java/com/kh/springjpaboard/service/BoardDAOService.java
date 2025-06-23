package com.kh.springjpaboard.service;

import java.util.List;

import com.kh.springjpaboard.domain.Board;

public interface BoardDAOService {

    public void insert(Board board) throws Exception;

    public Board select(Board board) throws Exception;

    public void update(Board board) throws Exception;

    public void delete(Board board) throws Exception;

    public List<Board> selectAll() throws Exception;
}
