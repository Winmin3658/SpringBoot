package com.kh.image_shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.image_shop.domain.CodeLabelValue;
import com.kh.image_shop.mapper.CodeMapper;

@Service
public class CodeServiceImpl implements CodeService{
    
    @Autowired
    private CodeMapper mapper;

    @Override
    public List<CodeLabelValue> getCodeGroupList() throws Exception {
        return mapper.getCodeGroupList();
    }

    @Override
    public List<CodeLabelValue> getCodeList(String groupCode) throws Exception {
        return mapper.getCodeList(groupCode);
    }
}
