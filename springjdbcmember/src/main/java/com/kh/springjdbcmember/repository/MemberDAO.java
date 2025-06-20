package com.kh.springjdbcmember.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.springjdbcmember.domain.Member;

@Repository
public class MemberDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String insertMember = "INSERT INTO Member(no, id, pwd, name) VALUES(Member_seq.NEXTVAL, ?, ?, ?)";
    private String selectByNoMember = "SELECT no, id, pwd, name, reg_date FROM Member WHERE no = ?";
    private String updateMember = "UPDATE Member SET id =?, pwd =?, name =? WHERE no = ?";
    private String deleteMember = "delete from Member where no = ?";
    private String selectMember = "SELECT no, id, pwd, name, reg_date FROM Member WHERE no > 0 ORDER BY no desc, reg_date DESC";

    // 게시판 삽입
    @Override
    public void insert(Member member) throws Exception {
        jdbcTemplate.update(insertMember, member.getId(), member.getPwd(), member.getName());
    }

    // 게시판 출력(one)
    @Override
    public Member select(Member member) throws Exception {
        List<Member> results = jdbcTemplate.query(selectByNoMember,
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();
                        member.setNo(rs.getInt("no"));
                        member.setId(rs.getString("id"));
                        member.setPwd(rs.getString("pwd"));
                        member.setName(rs.getString("name"));
                        member.setRegDate(rs.getDate("reg_date"));
                        return member;
                    }
                }, member.getNo());
        return results.isEmpty() ? null : results.get(0);
    }

    // 게시판 수정
    @Override
    public void update(Member member) throws Exception {
        jdbcTemplate.update(updateMember, member.getId(), member.getPwd(), member.getName(),
                member.getNo());
    }

    // 게시판 삭제
    @Override
    public void delete(Member member) throws Exception {
        jdbcTemplate.update(deleteMember, member.getNo());
    }

    // 게시판 출력(All 전체)
    @Override
    public List<Member> selectAll() throws Exception {
        List<Member> results = jdbcTemplate.query(
                selectMember,
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();
                        member.setNo(rs.getInt("no"));
                        member.setId(rs.getString("id"));
                        member.setPwd(rs.getString("pwd"));
                        member.setName(rs.getString("name"));
                        member.setRegDate(rs.getDate("reg_date"));
                        return member;
                    }
                });
        return results.isEmpty() ? null : results;
    }
}
