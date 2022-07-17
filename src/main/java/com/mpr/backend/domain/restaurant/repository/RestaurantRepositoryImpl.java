package com.mpr.backend.domain.restaurant.repository;

import com.mpr.backend.domain.restaurant.Restaurant;
import com.mpr.backend.domain.restaurant.dto.CateListDTO;
import com.mpr.backend.domain.restaurant.dto.CategorySearch;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {
    private final MongoTemplate mongoTemplate;

    public List<Restaurant> findAllBySearch(CategorySearch categorySearch) {
        Query query = new Query();

        //station 조건 필수 사항
        query.addCriteria(Criteria.where("station").is(categorySearch.getStation()));

        // 선택 사항
        Optional.ofNullable(categorySearch.getCate_1())
                .ifPresent(category -> query.addCriteria(
                        Criteria.where("cate_1").is(categorySearch.getCate_1())));
        Optional.ofNullable(categorySearch.getCate_2())
                .ifPresent(category -> query.addCriteria(
                        Criteria.where("cate_2").is(categorySearch.getCate_2())));
        Optional.ofNullable(categorySearch.getCate_3())
                .ifPresent(category -> query.addCriteria(
                        Criteria.where("cate_3").is(categorySearch.getCate_3())));
        Optional.ofNullable(categorySearch.getCate_4())
                .ifPresent(category -> query.addCriteria(
                        Criteria.where("cate_4").is(categorySearch.getCate_4())));

        return mongoTemplate.find(query, Restaurant.class);
    }

    public CateListDTO findCateListDistinct(String station){
        Query query = new Query();
        query.addCriteria(Criteria.where("station").is(station));

        query.fields().include("cate_1");
        query.fields().include("cate_2");
        query.fields().include("cate_3");
        query.fields().include("cate_4");


        List<String> cate_1 = mongoTemplate.findDistinct(query, "cate_1", "station_to_restaurant", String.class);

//        List<String> tmp = new ArrayList<>();
//        mongoTemplate.getCollection("station_to_restaurant")
//                .distinct("cate_1", String.class).forEach(tmp::add);

        List<String> cate_2 = mongoTemplate.findDistinct(query, "cate_2", "station_to_restaurant", String.class);
        List<String> cate_3 = mongoTemplate.findDistinct(query, "cate_3", "station_to_restaurant", String.class);
        List<String> cate_4 = mongoTemplate.findDistinct(query, "cate_4", "station_to_restaurant", String.class);


        return new CateListDTO(cate_1, cate_2, cate_3, cate_4);
    }
}
