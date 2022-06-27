package com.mpr.backend.domain.StationToRestaurant.dto;

import com.mpr.backend.domain.StationToRestaurant.StationToRestaurant;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class RestaurantDto {
    @Id
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
    private final Double lot;

    @Builder
    public RestaurantDto(String id, String name, String cate1, String cate2, String cate3, String cate4, String station, Double distance, String dong, Double lon, Double lot) {
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
        this.lot = lot;
    }

    public static RestaurantDto from(StationToRestaurant stationToRestaurant){
        return RestaurantDto.builder()
                .id(stationToRestaurant.getId())
                .name(stationToRestaurant.getName())
                .cate1(stationToRestaurant.getCate1())
                .cate2(stationToRestaurant.getCate2())
                .cate3(stationToRestaurant.getCate3())
                .cate4(stationToRestaurant.getCate4())
                .station(stationToRestaurant.getStation())
                .distance(stationToRestaurant.getDistance())
                .lon(stationToRestaurant.getLon())
                .lot(stationToRestaurant.getLot())
                .build();
    }
}
