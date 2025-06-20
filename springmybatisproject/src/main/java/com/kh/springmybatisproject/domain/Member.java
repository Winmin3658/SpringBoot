package com.kh.springmybatisproject.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int no;
    private String id;
    private String pw;
    private String name;
    private int coin;
    private Date regDate;
    private Date updDate;
    private String enabled;
    // 이 부분 매우 중요. 1:N 방식
    private List<MemberAuth> authList;
}