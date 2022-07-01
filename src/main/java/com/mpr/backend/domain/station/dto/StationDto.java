package com.mpr.backend.domain.station.dto;

import com.mpr.backend.domain.station.Station;
import lombok.Builder;
import lombok.Getter;


@Getter
public class StationDto{
    private final String name;
    private final Double  lon;
    private final Double lat;

    @Builder
    public StationDto(String name, Double lon, Double lat) {
        this.name = name;
        this.lon = lon;
        this.lat = lat;
    }

    public static StationDto from(Station station){
        return StationDto.builder()
                .name(station.getSubwayLocation())
                .lat(station.getLat())
                .lon(station.getLon())
                .build();
    }
}