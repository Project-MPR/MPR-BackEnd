package com.mpr.backend.domain.restaurant.repository;

import java.util.List;

public interface RestaurantRepositoryCustom {
    List<String> filterUniqueCate(String station);
}
