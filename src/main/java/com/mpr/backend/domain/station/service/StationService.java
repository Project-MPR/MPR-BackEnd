package com.mpr.backend.domain.station.service;

import com.mpr.backend.domain.station.Station;
import com.mpr.backend.domain.station.dto.StationDto;
import com.mpr.backend.domain.station.repository.StationRepository;
import com.mpr.backend.global.error.NoStationException;
import com.mpr.backend.global.error.message.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StationService {
    private final StationRepository stationRepository;

    public StationDto findStationByStationName(String stationName) {
        Station station = stationRepository.findStationBySubwayLocation(stationName)
                .orElseThrow(() -> new NoStationException(ErrorMessage.NO_STATION_ERROR.toString()));
        return StationDto.from(station);
    }

    public List<StationDto> findAll() {
        List<Station> stations = stationRepository.findAll();

        return stations.stream()
                .map(StationDto::from)
                .collect(Collectors.toList());
    }
}
