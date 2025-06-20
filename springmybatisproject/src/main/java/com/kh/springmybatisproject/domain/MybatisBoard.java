package com.kh.springmybatisproject.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MybatisBoard {
    private int no;
    private String title;
    private String content;
    private String writer;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date regDate;
}