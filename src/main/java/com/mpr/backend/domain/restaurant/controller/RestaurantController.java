package com.mpr.backend.domain.restaurant.controller;


import com.mpr.backend.domain.restaurant.Restaurant;
import com.mpr.backend.domain.restaurant.dto.CateListDTO;
import com.mpr.backend.domain.restaurant.dto.CategorySearch;
import com.mpr.backend.domain.restaurant.dto.RestaurantDto;
import com.mpr.backend.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/api/restaurant/{station}")
    @CrossOrigin
    public List<RestaurantDto> findByStation(
            @PathVariable("station") String station
    ) {
        return restaurantService.findRestaurantByStation(station);
    }

    public List<RestaurantDto> findByCategory(
            @RequestBody CategorySearch categorySearch
    ){
        return restaurantService.findRestaurantByStationByCategory(categorySearch);
    }

    @GetMapping("/api/restaurant/cate/{station}")
    public CateListDTO findCateListDistinct(@PathVariable("station") String station){
        return restaurantService.findCateListDistinct(station);
    }
}
