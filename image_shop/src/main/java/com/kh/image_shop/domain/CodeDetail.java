package com.kh.image_shop.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeDetail {
    private String groupCode;
    private String codeValue;
    private String codeName;
    private int sortSeq;
    private String useYn;
    private Date regDate;
    private Date updDate;
}
