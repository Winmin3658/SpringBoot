package com.kh.springbootaop.service;

import java.util.List;

import com.kh.springbootaop.domain.AOPBoard;

public interface BoardDAOService {

    public void insert(AOPBoard board) throws Exception;

    public AOPBoard select(AOPBoard board) throws Exception;

    public void update(AOPBoard board) throws Exception;

    public void delete(AOPBoard board) throws Exception;

    public List<AOPBoard> selectAll() throws Exception;
}
