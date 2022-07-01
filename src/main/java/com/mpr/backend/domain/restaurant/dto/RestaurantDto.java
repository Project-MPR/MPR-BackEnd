package com.mpr.backend.domain.restaurant.dto;

import com.mpr.backend.domain.restaurant.Restaurant;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestaurantDto {
    private String id;
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

    @Builder
    public RestaurantDto(String id, String name, String cate_1, String cate_2, String cate_3, String cate_4, String station, Double distance, String dong, Double lon, Double lat) {
        this.id = id;
        this.name = name;
        this.cate_1 = cate_1;
        this.cate_2 = cate_2;
        this.cate_3 = cate_3;
        this.cate_4 = cate_4;
        this.station = station;
        this.distance = distance;
        this.dong = dong;
        this.lon = lon;
        this.lat = lat;
    }

    public static RestaurantDto from(Restaurant restaurant) {
        return RestaurantDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .cate_1(restaurant.getCate_1())
                .cate_2(restaurant.getCate_2())
                .cate_3(restaurant.getCate_3())
                .cate_4(restaurant.getCate_4())
                .station(restaurant.getStation())
                .distance(restaurant.getDistance())
                .dong(restaurant.getDong())
                .lon(restaurant.getLon())
                .lat(restaurant.getLat())
                .build();
    }
}
