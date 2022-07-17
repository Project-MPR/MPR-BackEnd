package com.mpr.backend.domain.station.repository;

import com.mpr.backend.domain.station.Station;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StationRepositoryImpl implements StationRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<Station> findStationListByRegex(String regex) {
        Query query = new Query();
        query.addCriteria(Criteria.where("subwayLocation").regex(regex));
        return mongoTemplate.find(query, Station.class);
    }
}
