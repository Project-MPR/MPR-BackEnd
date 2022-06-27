package com.mpr.backend.domain.StationToRestaurant;


import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "station_to_restaurant")
public class StationToRestaurant {
    @Id
    private String id;
    private String Column1;
    private String name;

    private String cate1;
    private String cate2;
    private String cate3;
    private String cate4;

    private String station;
    private Double distance;
    private String dong;

    private Double lon;
    private Double lot;
}
