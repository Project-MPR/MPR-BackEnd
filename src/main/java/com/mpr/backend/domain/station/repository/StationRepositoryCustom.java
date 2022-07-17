package com.mpr.backend.domain.station.repository;

import com.mpr.backend.domain.station.Station;

import java.util.List;

public interface StationRepositoryCustom {
    List<Station>  findStationListByRegex(String regex);
}
