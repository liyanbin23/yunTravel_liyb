package com.yuntravel.service.impl;


import com.yuntravel.dao.CityMapper;
import com.yuntravel.po.Cities;
import com.yuntravel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    public CityMapper getCityMapper() {
        return cityMapper;
    }

    public void setCityMapper(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @Override
    public List<Cities> getCitiesList() {
        return cityMapper.getCitiesList();
    }

    @Override
    public String getCityNameById(int cityId) {
        return cityMapper.getCityNameById(cityId);
    }
}
