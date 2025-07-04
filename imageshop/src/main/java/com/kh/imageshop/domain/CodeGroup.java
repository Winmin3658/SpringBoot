package com.kh.imageshop.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CodeGroup {
    private String groupCode;
    private String groupName;
    private String useYn;
    private Date regDate;
    private Date updDate;
}
