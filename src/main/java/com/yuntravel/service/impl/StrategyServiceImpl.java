package com.yuntravel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuntravel.dao.StrategyAuditMapper;
import com.yuntravel.dao.StrategyMapper;
import com.yuntravel.po.Sights;
import com.yuntravel.po.Strategy;
import com.yuntravel.service.StrategyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StrategyServiceImpl implements StrategyService {

    @Autowired
    private StrategyMapper strategyMapper;
    @Autowired
    private StrategyAuditMapper strategyAuditMapper;

    public StrategyMapper getStrategyMapper() {
        return strategyMapper;
    }

    public void setStrategyMapper(StrategyMapper strategyMapper) {
        this.strategyMapper = strategyMapper;
    }

    @Override
    public PageInfo<Strategy> getStrategyList(int pageSize, int curPage, String city, int travelType, int travelDay) {
        PageHelper.startPage(curPage,pageSize);
        List<Strategy> list =strategyMapper.getStrategyList(city,travelType,travelDay);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public Strategy getStrategyById(int id) {
     return strategyMapper.getStrategyById(id);
    }

    @Override
    public List<Strategy> getStrategyListByUserId(int uId) {
        return strategyMapper.getStrategyListByUserId(uId);
    }

    @Override
    public int getMaxStrategyId() {
        return strategyMapper.getMaxStrategyId();
    }

    @Override
    public int addStrategy(Strategy strategy) {

        return strategyMapper.addStrategy(strategy);
    }

    @Override
    public  PageInfo<Strategy> getBaseStrategyList(int pageSize, int curPage) {
        PageHelper.startPage(curPage,pageSize);
        List<Strategy> list =strategyAuditMapper.getBaseStrategyList();
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public  PageInfo<Strategy> getAuditStrategyList(int pageSize, int curPage, int strategyId,int adminId) {
        PageHelper.startPage(curPage,pageSize);
        List<Strategy> list =strategyAuditMapper.getAuditStrategyList(strategyId,adminId);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public  PageInfo<Strategy> getUnAuditStrategyList(int pageSize, int curPage,String titles,int adminId, String auditTime) {
        PageHelper.startPage(curPage,pageSize);
        List<Strategy> list =strategyAuditMapper.getUnAuditStrategyList(titles, adminId, auditTime);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public Strategy getBaseStrategyById(int strategyId) {
        return strategyAuditMapper.getBaseStrategyById(strategyId);
    }

    @Override
    public Strategy getAuditStrategyById(int strategyId) {
        return strategyAuditMapper.getAuditStrategyById(strategyId);
    }

    @Override
    public Strategy getUnAuditStrategyById(int strategyId) {
        return strategyAuditMapper.getUnAuditStrategyById(strategyId);
    }

    @Override
    public List<Strategy> getBadeStrategyListByUserId(int userId) {
        return strategyAuditMapper.getBadeStrategyListByUserId(userId);
    }

    @Override
    public List<Strategy> getAuditStrategyListByUserId(int userId) {
        return strategyAuditMapper.getAuditStrategyListByUserId(userId);
    }

    @Override
    public List<Strategy> getUnAuditStrategyListByUserId(int userId) {
        return strategyAuditMapper.getUnAuditStrategyListByUserId(userId);
    }

    @Override
    public int getBaseMaxStrategyId() {
        return 0;
    }

    @Override
    public int getAuditMaxStrategyId() {
        return 0;
    }

    @Override
    public int getUnAuditMaxStrategyId() {
        return 0;
    }

    @Override
    public int addBaseStrategy(Strategy strategy) {
        return 0;
    }

    @Override
    public int addAuditStrategy(Strategy strategy) {
        return 0;
    }

    @Override
    public int addUnAuditStrategy(Strategy strategy) {
        return 0;
    }
}
