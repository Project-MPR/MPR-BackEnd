package com.mpr.backend.domain.StationToRestaurant.repository;

import com.mpr.backend.domain.StationToRestaurant.StationToRestaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Optional;

@EnableMongoRepositories
public interface StationToRestaurantRepository extends MongoRepository<StationToRestaurant, Long> {
    List<StationToRestaurant> findByStation(String station);
}
