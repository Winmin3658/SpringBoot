package com.kh.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.domain.Member;
import com.kh.service.MemberService;

@Repository
public class MemberDAO implements MemberService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String insertMember = "INSERT INTO MEMBER VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?)";
	private String updateMember = "UPDATE MEMBER SET ID = ?, PW = ? , NAME= ? WHERE NO = ?";
	private String selectMember = "SELECT * FROM MEMBER WHERE NO > 0 ORDER BY NO DESC";
	private String selectByNo = "SELECT * FROM MEMBER WHERE NO = ?";
	private String deleteMember = "DELETE FROM MEMBER WHERE NO = ?";

	// 게시판 삽입
	@Override
	public void insert(Member member) throws Exception {
		jdbcTemplate.update(insertMember, member.getId(), member.getPw(), member.getName());
	}

	// 게시판 수정
	@Override
	public void update(Member member) throws Exception {
		jdbcTemplate.update(updateMember, member.getId(), member.getPw(), member.getName(),
				member.getNo());
	}

	// 게시판 조회(All)
	@Override
	public List<Member> selectAll() throws Exception {
		List<Member> results = jdbcTemplate.query(selectMember, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				member.setNo(rs.getInt("NO"));
				member.setId(rs.getString("ID"));
				member.setPw(rs.getString("PW"));
				member.setName(rs.getString("NAME"));
				return member;
			}
		});
		return results.isEmpty() ? null : results;
	}

	// 게시판 조회(one)
	@Override
	public Member selectByNo(Member member) throws Exception {
		List<Member> results = jdbcTemplate.query(selectByNo, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				member.setNo(rs.getInt("NO"));
				member.setId(rs.getString("ID"));
				member.setPw(rs.getString("PW"));
				member.setName(rs.getString("NAME"));
				return member;
			}
		}, member.getNo());

		return results.isEmpty() ? null : results.get(0);
	}

	// 게시판 삭제
	public void delete(Member member) throws Exception {
		jdbcTemplate.update(deleteMember, member.getNo());
	}

}
