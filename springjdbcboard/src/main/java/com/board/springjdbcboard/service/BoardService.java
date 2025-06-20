package com.board.springjdbcboard.service;

import java.util.List;

import com.board.springjdbcboard.domain.Board;

public interface BoardService {
    public void insert(Board board) throws Exception;

    public Board select(Board board) throws Exception;

    public void update(Board board) throws Exception;

    public void delete(Board board) throws Exception;

    public List<Board> selectAll() throws Exception;

}