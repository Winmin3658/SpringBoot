package com.kh.springmybatismemberproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springmybatismemberproject.domain.MybatisMember;
import com.kh.springmybatismemberproject.mapper.MemberDAO;

@Service
public class MemberDAOServiceImpl implements MemberDAOService {
    @Autowired
    private MemberDAO md;

    @Override
    public void insert(MybatisMember member) throws Exception {
        md.insert(member);
        
    }

    @Override
    public MybatisMember select(MybatisMember member) throws Exception {
        return md.select(member);
    }

    @Override
    public void update(MybatisMember member) throws Exception {
        md.update(member);
        
    }

    @Override
    public void delete(MybatisMember member) throws Exception {
        md.delete(member);
    }

    @Override
    public List<MybatisMember> selectAll() throws Exception {
        return md.selectAll();
    }

}
