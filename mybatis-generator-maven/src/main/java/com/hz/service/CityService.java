package com.hz.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hz.mapper.CityMapper;
import com.hz.domain.City;
@Service
public class CityService{

    @Resource
    private CityMapper cityMapper;

    
    public int insert(City record) {
        return cityMapper.insert(record);
    }

    
    public int insertSelective(City record) {
        return cityMapper.insertSelective(record);
    }

}
