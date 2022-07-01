package com.mpr.backend.domain.restaurant.controller;

import com.mpr.backend.domain.restaurant.dto.RestaurantDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RestaurantControllerTest {

    @Autowired
    private RestaurantController restaurantController;

    @Test
    @DisplayName("컨트롤러 동작 test 1 : 정상적인 입력에 대해서 컨트롤러 동작 여부")
    void controllerTest1() throws Exception{
        //given
        String station = "역삼역";

        //when
        List<RestaurantDto> resultList = restaurantController.findByStation(station);

        //then
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

    @Test
    @DisplayName("컨트롤러 동작 test 2 : 존재하지 않는 역에 대해서 처리")
    void controllerTest2() throws Exception{
        //given
        String station = "가나다라마다사";

        //when
        List<RestaurantDto> resultList = restaurantController.findByStation(station);

        //then
        assertThat(resultList.size()).isEqualTo(0);
    }
}