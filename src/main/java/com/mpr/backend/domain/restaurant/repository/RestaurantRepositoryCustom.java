package com.mpr.backend.domain.restaurant.repository;

import com.mpr.backend.domain.restaurant.Restaurant;
import com.mpr.backend.domain.restaurant.dto.CateListDTO;
import com.mpr.backend.domain.restaurant.dto.CategorySearch;

import java.util.List;

public interface RestaurantRepositoryCustom {
    List<Restaurant> findAllBySearch(CategorySearch categorySearch);
    CateListDTO findCateListDistinct(String station);
}
