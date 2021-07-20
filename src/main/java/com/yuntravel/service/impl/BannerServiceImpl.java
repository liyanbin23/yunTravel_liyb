package com.yuntravel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuntravel.dao.BannersMapper;
import com.yuntravel.po.Banners;
import com.yuntravel.po.Sights;
import com.yuntravel.service.BannersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
@Component
public class BannerServiceImpl implements BannersService {
    @Autowired
    private BannersMapper bannersMapper;

    public BannersMapper getBannersMapper() {
        return bannersMapper;
    }
    public void setBannersMapper(BannersMapper bannersMapper) {
        this.bannersMapper = bannersMapper;
    }

    @Override
    public PageInfo<Banners> getAllBanner(int pageSize, int currentPage) {
        PageHelper.startPage(currentPage,pageSize);
        List<Banners> list =bannersMapper.getAllBanner();
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public List<Banners> getHomeBanner() {
        System.out.println(bannersMapper);
        List<Banners> ban=bannersMapper.getHomeBanner();
        if(ban==null){

            return new ArrayList<>();
        }
        return ban;
    }

    @Override
    public List<Banners> getSightBanner() {
        List<Banners> ban=bannersMapper.getSightBanner();
        if(ban==null){

            return new ArrayList<>();
        }
        return ban;
    }

    @Override
    public int addBanner(Banners banners) {

        return bannersMapper.addBanner(banners);
    }

    @Override
    public int updBanner() {
        return 0;
    }

    @Override
    public int delBanner(int id) {

        return bannersMapper.delBanner(id);
    }

    @Override
    public int getMaxBannerId() {
        return bannersMapper.getMaxId();
    }
}
