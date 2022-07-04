package com.mpr.backend.domain.restaurant.service;

import com.mpr.backend.domain.restaurant.Restaurant;
import com.mpr.backend.domain.restaurant.dto.CategorySearch;
import com.mpr.backend.domain.restaurant.dto.RestaurantDto;
import com.mpr.backend.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final ModelMapper modelMapper;

    public List<RestaurantDto> findRestaurantByStation(String station) {
        return restaurantRepository.findRestaurantByStation(station)
                .stream()
                .map(restaurant -> modelMapper.map(restaurant, RestaurantDto.class))
                .collect(Collectors.toList());
    }

    public List<RestaurantDto> findRestaurantByStationByCategory(CategorySearch categorySearch) {
        return restaurantRepository.findAllBySearch(categorySearch)
                .stream()
                .map(restaurant -> modelMapper.map(restaurant, RestaurantDto.class))
                .collect(Collectors.toList());
    }
}
