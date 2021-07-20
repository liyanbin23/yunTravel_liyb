package com.yuntravel.dao;


import com.github.pagehelper.PageInfo;
import com.yuntravel.po.Sights;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SightsMapper {
    List<Sights> qryAllSights();

    List<Sights> qryAllSightsByCity(@Param("key")String key);

    List<Sights> qryAllSightsWithKey(@Param("city") String city,@Param("sightsName") String sightsName);

    Sights qrySightsById(int sightsId);

    int addNewSights(Sights sights);

    int getMaxId();

    int updateSights(Sights sights);

    int addViesNum(@Param("sightsId") int sightsId);

}
