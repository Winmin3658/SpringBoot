package com.board.springjdbcboard.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.board.springjdbcboard.domain.Board;

@Repository
public class BoardDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String insertBoard = "INSERT INTO Board(board_no, title, content, writer) VALUES(Board_seq.NEXTVAL, ?, ?, ?)";
    private String selectByNoBoard = "SELECT board_no, title, content, writer, reg_date FROM Board WHERE board_no = ?";
    private String updateBoard = "UPDATE Board SET title =?, writer =?, content =? WHERE board_no = ?";
    private String deleteBoard = "delete from Board where board_no = ?";
    private String selectBoard = "SELECT board_no, title, content, writer, reg_date FROM Board WHERE board_no > 0 ORDER BY board_no desc, reg_date DESC";

    // 게시판 삽입
    public void insert(Board board) throws Exception {
        jdbcTemplate.update(insertBoard, board.getTitle(), board.getContent(), board.getWriter());
    }

    // 게시판 출력(one)
    public Board select(Board board) throws Exception {
        List<Board> results = jdbcTemplate.query(selectByNoBoard,
                new RowMapper<Board>() {
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Board board = new Board();
                        board.setBoardNo(rs.getInt("board_no"));
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));
                        board.setRegDate(rs.getDate("reg_date"));
                        return board;
                    }
                }, board.getBoardNo());
        return results.isEmpty() ? null : results.get(0);
    }

    // 게시판 수정
    public void update(Board board) throws Exception {
        jdbcTemplate.update(updateBoard, board.getTitle(), board.getWriter(), board.getContent(),
                board.getBoardNo());
    }

    // 게시판 삭제
    public void delete(Board board) throws Exception {
        jdbcTemplate.update(deleteBoard, board.getBoardNo());
    }

    // 게시판 출력(All 전체)
    public List<Board> selectAll() throws Exception {
        List<Board> results = jdbcTemplate.query(
                selectBoard,
                new RowMapper<Board>() {
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Board board = new Board();
                        board.setBoardNo(rs.getInt("board_no"));
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));
                        board.setRegDate(rs.getDate("reg_date"));
                        return board;
                    }
                });
        return results.isEmpty() ? null : results;
    }
}
