package com.mpr.backend;

import com.mpr.backend.domain.restaurant.Restaurant;
import com.mpr.backend.domain.restaurant.dto.RestaurantDto;
import com.mpr.backend.domain.restaurant.service.RestaurantService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ModelMapperTest {

    @Autowired
    private ModelMapper mm;

    @Autowired
    private RestaurantService restaurantService;

    @Test
    @DisplayName("modelMapper가 정상적으로 변환해주는지 확인하기")
    void modelMapper1() throws Exception {
        String station = "광운대역";

        List<Restaurant> restaurantList = restaurantService.findRestaurantByStation(station);

        List<RestaurantDto> resultList = restaurantList.stream()
                .map(restaurant -> mm.map(restaurant, RestaurantDto.class))
                .collect(Collectors.toList());

        assertThat(resultList.size()).isGreaterThan(0);
        assertThat(resultList.get(0).getName()).isNotEqualTo(null);
        assertThat(resultList.get(0).getStation()).isNotEqualTo(null);
        assertThat(resultList.get(0).getLon()).isNotEqualTo(null);
        assertThat(resultList.get(0).getLat()).isNotEqualTo(null);
        assertThat(resultList.get(0).getCate_1()).isNotEqualTo(null);
        assertThat(resultList.get(0).getCate_2()).isNotEqualTo(null);
        assertThat(resultList.get(0).getCate_3()).isNotEqualTo(null);
        assertThat(resultList.get(0).getCate_4()).isNotEqualTo(null);
    }
}
