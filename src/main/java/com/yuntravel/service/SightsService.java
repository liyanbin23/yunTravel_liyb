package com.yuntravel.service;

import com.github.pagehelper.PageInfo;
import com.yuntravel.po.Sights;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface SightsService {
    PageInfo<Sights> qryAllSights(int pageSize,int currentPage);

    PageInfo<Sights> qryAllSightsByCity(int pageSize,int currentPage,String key);

    PageInfo<Sights> qryAllSightsWithKey(int pageSize,int currentPage,String city,String title);

    Sights qrySightsById(int id);

    int addNewSights(Sights sights);

    int getMaxId();

    int updateSights(Sights sights);

    int addViewsNum(int id);

}
