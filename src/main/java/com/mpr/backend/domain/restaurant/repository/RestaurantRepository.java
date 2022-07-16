package com.mpr.backend.domain.restaurant.repository;

import com.mpr.backend.domain.restaurant.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
public interface RestaurantRepository extends MongoRepository<Restaurant, Long>, RestaurantRepositoryCustom {
    List<Restaurant> findByStation(String station);
}
