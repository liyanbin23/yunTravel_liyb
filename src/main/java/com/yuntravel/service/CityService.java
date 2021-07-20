package com.yuntravel.service;

import com.yuntravel.po.Cities;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {
    List<Cities> getCitiesList();

   String getCityNameById(int cityId);

}
