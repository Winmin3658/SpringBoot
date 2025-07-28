package com.kh.diaryapi.service;

import org.springframework.transaction.annotation.Transactional;

import com.kh.diaryapi.dto.PageRequestDTO;
import com.kh.diaryapi.dto.PageResponseDTO;
import com.kh.diaryapi.dto.ProductDTO;

@Transactional
public interface ProductService {
    PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO);

    Long register(ProductDTO productDTO);

    ProductDTO get(Long pno);

    void modify(ProductDTO productDTO);

    void remove(Long pno);
}