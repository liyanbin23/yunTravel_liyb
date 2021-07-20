package com.yuntravel.dao;

import com.yuntravel.po.Banners;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannersMapper {

    List<Banners> getAllBanner();

    List<Banners> getHomeBanner();

    List<Banners> getSightBanner();

    int addBanner(Banners banners);

    int updBanner();

    int delBanner(@Param("imgId") int imgId);

    int getMaxId();
}
