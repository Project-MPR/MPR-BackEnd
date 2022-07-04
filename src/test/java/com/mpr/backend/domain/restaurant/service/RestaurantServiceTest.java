package com.mpr.backend.domain.restaurant.service;

import com.mpr.backend.domain.restaurant.dto.CategorySearch;
import com.mpr.backend.domain.restaurant.dto.RestaurantDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.list;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RestaurantServiceTest {

    @Autowired
    private RestaurantService restaurantService;

    @Test
    @DisplayName("카테고리 검색 테스트 1 : 카테고리 내용이 전부 null 인 경우 station으로 식당을 검색하는 것과 동일한 결과가 나와야함")
    void test1() throws Exception{

        String station = "역삼역";
        CategorySearch categorySearch = new CategorySearch();
        categorySearch.setStation(station);

        List<RestaurantDto> listByStation = restaurantService.findRestaurantByStation(station);
        List<RestaurantDto> listByCategory = restaurantService.findRestaurantByStationByCategory(categorySearch);

        assertThat(listByStation.size()).isEqualTo(listByCategory.size());
    }

    @Test
    @DisplayName("카테고리 검색 테스트 2 : station 이름이 없는 경우 예외 발생")
    void test2() throws Exception{
        String station = "역삼역";
        CategorySearch categorySearch = new CategorySearch();
        categorySearch.setStation(station);
        categorySearch.setCate_2("한식");

        List<RestaurantDto> listByCategory = restaurantService.findRestaurantByStationByCategory(categorySearch);

        assertThat(listByCategory.size()).isGreaterThan(0);
        //listByCategory.stream().limit(10).forEach(System.out::println);
    }
}