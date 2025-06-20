package com.zeus.domain;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok annotation
@Getter // getter 생성자
@Setter // setter 생성자
@ToString // ToString
@NoArgsConstructor
@AllArgsConstructor // 모든 생성자 만들기
public class Member {
    // 멤버변수
    private String userId;
    private String password;
    // Date 타입 필드 변환처리
    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date dateOfBirth;
    private List<String> nationality;
    private Board board;
}
