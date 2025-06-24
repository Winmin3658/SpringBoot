package com.kh.springbootfileupload.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int price;
    private String description;
    // input type="file"
    private MultipartFile picture;
    private String pictureUrl;
}
