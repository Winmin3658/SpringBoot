package com.board.springjdbcboard.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {
    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
}