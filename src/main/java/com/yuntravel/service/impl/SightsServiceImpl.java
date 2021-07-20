package com.yuntravel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuntravel.dao.SightsMapper;
import com.yuntravel.po.Sights;
import com.yuntravel.service.SightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SightsServiceImpl implements SightsService {

    @Autowired
    private SightsMapper sightsMapper;

    public SightsMapper getSightsMapper() {
        return sightsMapper;
    }

    public void setSightsMapper(SightsMapper sightsMapper) {
        this.sightsMapper = sightsMapper;
    }

    @Override
    public PageInfo<Sights> qryAllSights(int pageSize,int currentPage) {
        PageHelper.startPage(currentPage,pageSize);
        List<Sights> list =sightsMapper.qryAllSights();
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Sights> qryAllSightsByCity(int pageSize, int currentPage, String key) {
        PageHelper.startPage(currentPage,pageSize);
        List<Sights> list =sightsMapper.qryAllSightsByCity(key);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }


    @Override
    public PageInfo<Sights> qryAllSightsWithKey(int pageSize, int currentPage, String city, String title) {
        PageHelper.startPage(currentPage,pageSize);
        List<Sights> list =sightsMapper.qryAllSightsWithKey(city,title);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public Sights qrySightsById(int sightsId) {
        return sightsMapper.qrySightsById(sightsId);
    }

    @Override
    public int addNewSights(Sights sights) {
        return sightsMapper.addNewSights(sights);
    }

    @Override
    public int getMaxId() {
        return sightsMapper.getMaxId();
    }

    @Override
    public int updateSights(Sights sights) {
        return sightsMapper.updateSights(sights);
    }

    @Override
    public int addViewsNum(int id) {
        return sightsMapper.addViesNum(id);
    }
}
