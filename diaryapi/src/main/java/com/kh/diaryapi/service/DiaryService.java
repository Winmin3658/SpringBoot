package com.kh.diaryapi.service;

import com.kh.diaryapi.dto.DiaryDTO;
import com.kh.diaryapi.dto.PageRequestDTO;
import com.kh.diaryapi.dto.PageResponseDTO;

public interface DiaryService {
    Long register(DiaryDTO diaryDTO);

    DiaryDTO get(Long tno);

    void modify(DiaryDTO diaryDTO);

    void remove(Long tno);

    PageResponseDTO<DiaryDTO> list(PageRequestDTO pageRequestDTO);
}
