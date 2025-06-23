package com.kh.springjpaboard.domain;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 매개변수 생성자
@NoArgsConstructor // 디폴트 생성자
@Entity
@SequenceGenerator(name="JPABOARD_SEQ_GEN", sequenceName="JPABOARD_SEQ", initialValue=1, allocationSize=1)
public class Board {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JPABOARD_SEQ_GEN")
    @Column(name="NO")
    private int no;
    @Column(name="TITLE")
    private String title;
    @Column(name="CONTENT")
    private String content;
    @Column(name="WRITER")
    private String writer;
    @CreationTimestamp
    @Column(name="reg_date")
    private Date regDate;
}
