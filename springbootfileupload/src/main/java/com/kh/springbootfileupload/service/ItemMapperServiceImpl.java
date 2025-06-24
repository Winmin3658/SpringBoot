package com.kh.springbootfileupload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.springbootfileupload.domain.Item;
import com.kh.springbootfileupload.mapper.ItemMapper;

@Service
public class ItemMapperServiceImpl implements ItemMapperService {
    @Autowired
    private ItemMapper im;

    @Override
    @Transactional
    public void create(Item item) throws Exception {
        im.create(item);
    }

    @Override
    @Transactional(readOnly=true)
    public Item read(Item item) throws Exception {
        return im.read(item);
    }

    @Override
    public void update(Item item) throws Exception {
        im.update(item);
    }

    @Override
    public void delete(Item item) throws Exception {
        im.delete(item);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Item> list() throws Exception {
        return im.list();
    }

    @Override
    public Item getPicture(Item item) throws Exception {
        return im.getPicture(item);
    }
}
