package com.kh.springjpaboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.springjpaboard.domain.Board;
import com.kh.springjpaboard.persitance.BoardRepository;

@Service
public class BoardDAOServiceImpl implements BoardDAOService {
    @Autowired
    private BoardRepository bd;

    @Override
    public void insert(Board board) throws Exception {
        bd.save(board);
    }

    @Override
    public Board select(Board board) throws Exception {
        return bd.getOne(board.getNo());
    }
    @Override
    public void update(Board board) throws Exception {
        Board boardEntity = bd.getOne(board.getNo());
        boardEntity.setContent(board.getContent());
        boardEntity.setTitle(board.getTitle());
        boardEntity.setWriter(board.getWriter());
    }

    @Override
    public void delete(Board board) throws Exception {
        bd.deleteById(board.getNo());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Board> selectAll() throws Exception {
        return bd.findAll(Sort.by(Direction.ASC, "no"));
    }
}
