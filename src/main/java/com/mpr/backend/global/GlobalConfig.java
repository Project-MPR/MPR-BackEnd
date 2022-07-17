package com.mpr.backend.global;

import com.mpr.backend.domain.station.Station;
import com.mpr.backend.domain.station.dto.StationDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {
    private static final ModelMapper mm = new ModelMapper();

    @Bean
    public ModelMapper modelMapper(){
        mm.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        mm.typeMap(Station.class, StationDto.class)
                .addMappings(mapper->{
            mapper.map(Station::getSubwayLocation, StationDto::setName);
        });

        return mm;
    }
}
