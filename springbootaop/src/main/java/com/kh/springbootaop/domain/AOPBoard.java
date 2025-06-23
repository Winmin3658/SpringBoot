package com.kh.springbootaop.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AOPBoard {
    private int no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
}
