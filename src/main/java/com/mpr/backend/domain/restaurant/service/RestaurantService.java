package com.mpr.backend.domain.restaurant.service;

import com.mpr.backend.domain.restaurant.Restaurant;
import com.mpr.backend.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> findRestaurantByStation(String station) {
        return restaurantRepository.findByStation(station);
    }

    public List<String> filterUniqueCate(String station){
        return restaurantRepository.filterUniqueCate(station);
    }
}
