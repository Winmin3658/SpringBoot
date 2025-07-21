package com.kh.mallapi.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable // 1 : n, ProductDTO.pno FK
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {
    private String fileName;
    private int ord;

    public void setOrd(int ord) {
        this.ord = ord;
    }
}
