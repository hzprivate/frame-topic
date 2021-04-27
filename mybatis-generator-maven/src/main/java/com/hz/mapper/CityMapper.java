package com.hz.mapper;

import com.hz.domain.City;

public interface CityMapper {
    int insert(City record);

    int insertSelective(City record);
}