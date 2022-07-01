package com.mpr.backend.domain.station.repository;


import com.mpr.backend.domain.station.Station;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Optional;

@EnableMongoRepositories
public interface StationRepository extends MongoRepository<Station, String> {
    Optional<Station> findStationBySubwayLocation(String station);
}
