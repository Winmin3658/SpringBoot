package com.kh.springbootintercepter.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String userId;
    private String userPw;
    private String userName;
    private String email;
}
