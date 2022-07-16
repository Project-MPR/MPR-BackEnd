package com.mpr.backend.domain.restaurant.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {
    private final MongoTemplate mongoTemplate;

    public List<String> filterUniqueCate(String station){
        List<String> res = new ArrayList<>();
        Query query = new Query();

        // 현재 입력으로 들어온 역에 대해서만 카테고리 정보가 필요하기 때문에 해당 부분 설정
        query.addCriteria(Criteria.where("station").is(station));
        query.fields().include("cate_2");

        // 유니크하게 카테고리를 가져오기 위해서 코트 작성
        mongoTemplate.getCollection("station_to_restaurant")
                .distinct("cate_2", query.getQueryObject(), String.class)
                .forEach(res::add);
        return res;
    }
}
