package com.mpr.backend.domain.station.controller;

import com.mpr.backend.domain.station.dto.StationDto;
import com.mpr.backend.domain.station.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StationController {
    private final StationService stationService;

    @CrossOrigin
    @GetMapping("/api/station/{stationName}")
    public ResponseEntity<StationDto> findStation(@PathVariable("stationName") String stationName ){
        StationDto dto = stationService.findStationByStationName(stationName);
        return ResponseEntity.ok(dto);
    }


    @CrossOrigin
    @GetMapping("/api/stations")
    public List<StationDto> findStations(){
        return stationService.findAll();
    }
}
