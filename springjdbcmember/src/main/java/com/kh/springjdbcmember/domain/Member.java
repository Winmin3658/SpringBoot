package com.kh.springjdbcmember.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
    private int no;
	private String id;
    private String pwd;
    private String name;
    private Date regDate;
}
