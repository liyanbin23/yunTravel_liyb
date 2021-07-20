package com.yuntravel.service.impl;


import com.yuntravel.dao.CollectMapper;
import com.yuntravel.po.StrategyColl;
import com.yuntravel.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    public CollectMapper getCollectMapper() {
        return collectMapper;
    }

    public void setCollectMapper(CollectMapper collectMapper) {
        this.collectMapper = collectMapper;
    }

    @Override
    public StrategyColl qryByIds(int strategyId, int userId) {
        return collectMapper.qryByIds(strategyId,userId);
    }

    @Override
    public int delByIds(int strategyId, int userId) {
        return collectMapper.delByIds(strategyId,userId);
    }

    @Override
    public int addNew(int strategyId, int userId) {
        return collectMapper.addNew(strategyId,userId);
    }

    @Override
    public int getCountNum(int strategyId) {
        return collectMapper.getCountNum(strategyId);
    }
}
