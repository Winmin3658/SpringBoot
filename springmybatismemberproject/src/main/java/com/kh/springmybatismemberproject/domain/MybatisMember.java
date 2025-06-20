package com.kh.springmybatismemberproject.domain;

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
public class MybatisMember {
    private int no;
    private String id;
    private String pw;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date regDate;
}
