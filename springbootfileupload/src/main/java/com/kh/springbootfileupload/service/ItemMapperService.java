package com.kh.springbootfileupload.service;

import java.util.List;

import com.kh.springbootfileupload.domain.Item;

public interface ItemMapperService {
    // 파일 삽입
    public void create(Item item) throws Exception;

    // 파일 출력(one)
    public Item read(Item item) throws Exception;

    // 파일 수정
    public void update(Item item) throws Exception;

    // 파일 삭제
    public void delete(Item item) throws Exception;

    // 파일 출력(전체)
    public List<Item> list() throws Exception;

    // 파일 경로
    public Item getPicture(Item item) throws Exception;
}
