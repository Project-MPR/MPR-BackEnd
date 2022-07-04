package com.mpr.backend.domain.station.service;

import com.mpr.backend.domain.station.Station;
import com.mpr.backend.domain.station.dto.StationDto;
import com.mpr.backend.domain.station.repository.StationRepository;
import com.mpr.backend.global.error.NoStationException;
import com.mpr.backend.global.error.message.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StationService {
    private final StationRepository stationRepository;
    private final ModelMapper modelMapper;
    public StationDto findStationByStationName(String stationName){
        Station station  = stationRepository.findStationBySubwayLocation(stationName)
                .orElseThrow(() -> new NoStationException(ErrorMessage.NO_STATION_ERROR.toString()));
        return modelMapper.map(station, StationDto.class);
    }

    public List<StationDto> findStationByRegex(String regex){
        return stationRepository.findStationListByRegex(regex)
                .stream()
                .map(station -> modelMapper.map(station, StationDto.class))
                .collect(Collectors.toList());
    }

}
