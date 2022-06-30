package com.mpr.backend.domain.restaurant.dto;

import com.mpr.backend.domain.restaurant.Restaurant;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RestaurantDto {
    private final String id;
    private final String name;
    private final String cate1;
    private final String cate2;
    private final String cate3;
    private final String cate4;
    private final String station;
    private final Double distance;
    private final String dong;
    private final Double lon;
    private final Double lat;

    @Builder
    public RestaurantDto(String id, String name, String cate1, String cate2, String cate3, String cate4, String station, Double distance, String dong, Double lon, Double lat) {
        this.id = id;
        this.name = name;
        this.cate1 = cate1;
        this.cate2 = cate2;
        this.cate3 = cate3;
        this.cate4 = cate4;
        this.station = station;
        this.distance = distance;
        this.dong = dong;
        this.lon = lon;
        this.lat = lat;
    }

    public static RestaurantDto from(Restaurant restaurant){
        return RestaurantDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .cate1(restaurant.getCate_1())
                .cate2(restaurant.getCate_2())
                .cate3(restaurant.getCate_3())
                .cate4(restaurant.getCate_4())
                .station(restaurant.getStation())
                .distance(restaurant.getDistance())
                .dong(restaurant.getDong())
                .lon(restaurant.getLon())
                .lat(restaurant.getLat())
                .build();
    }
}
