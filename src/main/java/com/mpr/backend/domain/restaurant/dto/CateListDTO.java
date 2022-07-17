package com.mpr.backend.domain.restaurant.dto;

import lombok.Data;

import java.util.List;

@Data
public class CateListDTO {
    private List<String> cate_1;
    private List<String> cate_2;
    private List<String> cate_3;
    private List<String> cate_4;

    public CateListDTO(List<String> cate_1, List<String> cate_2, List<String> cate_3, List<String> cate_4) {
        this.cate_1 = cate_1;
        this.cate_2 = cate_2;
        this.cate_3 = cate_3;
        this.cate_4 = cate_4;
    }
}
