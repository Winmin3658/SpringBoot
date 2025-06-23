package com.kh.springmemberaopjpa.domain;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name="MEMBER_SEQ_GEN", sequenceName="MEMBER_SEQ", initialValue=1, allocationSize=1)
public class Member {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEMBER_SEQ_GEN")
    @Column(name="NO")
    private int no;
    @Column(name="ID")
    private String id;
    @Column(name="PW")
    private String pw;
    @Column(name="NAME")
    private String name;
    @CreationTimestamp
    @Column(name="reg_date")
    private Date regDate;
}
