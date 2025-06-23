package com.kh.springjpaboard.persitance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springjpaboard.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    
}
