package com.yuntravel.service;

import com.github.pagehelper.PageInfo;
import com.yuntravel.po.Banners;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BannersService {
    PageInfo<Banners> getAllBanner(int pageSize, int currentPage);

    List<Banners> getHomeBanner();

    List<Banners> getSightBanner();

    int addBanner(Banners banners);

    int updBanner();

    int delBanner(int id);

    int getMaxBannerId();
}
