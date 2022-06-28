package com.mpr.backend.domain.StationToRestaurant.controller;


import com.mpr.backend.domain.StationToRestaurant.StationToRestaurant;
import com.mpr.backend.domain.StationToRestaurant.dto.RestaurantDto;
import com.mpr.backend.domain.StationToRestaurant.service.StationToRestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class StationToRestaurantController {
    private final StationToRestaurantService stationToRestaurantService;

    @GetMapping("/api/restaurant/{station}")
    @CrossOrigin
    public List<RestaurantDto> test(@PathVariable("station") String station) {
        List<StationToRestaurant> stationToRestaurantList = stationToRestaurantService.findRestaurantByStation(station);
        return stationToRestaurantList.stream()
                .map(RestaurantDto::from)
                .collect(Collectors.toList());
    }
}
