package com.mpr.backend.domain.station;


import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "station")
public class Station {
    @Id
    private String id;
    private String subwayLocation;
    private Double lon;
    private Double lat;
}
