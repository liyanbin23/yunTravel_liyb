package com.yuntravel.dao;

import com.yuntravel.po.Cities;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityMapper {


    List<Cities> getCitiesList();

    String getCityNameById(@Param("cityId") int cityId);
}
