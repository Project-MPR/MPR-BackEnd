package com.mpr.backend.domain.restaurant;


import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "station_to_restaurant")
public class Restaurant {
    @Id
    private String id;
    private String Column1;
    private String name;

    private String cate_1;
    private String cate_2;
    private String cate_3;
    private String cate_4;

    private String station;
    private Double distance;
    private String dong;

    private Double lon;
    private Double lat;
}
