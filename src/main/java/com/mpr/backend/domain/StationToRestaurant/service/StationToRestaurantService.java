package com.mpr.backend.domain.StationToRestaurant.service;

import com.mpr.backend.domain.StationToRestaurant.StationToRestaurant;
import com.mpr.backend.domain.StationToRestaurant.repository.StationToRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StationToRestaurantService {
    private final StationToRestaurantRepository stationToRestaurantRepository;

    public List<StationToRestaurant> findRestaurantByStation(String station) {
        return stationToRestaurantRepository.findByStation(station);
    }
}
