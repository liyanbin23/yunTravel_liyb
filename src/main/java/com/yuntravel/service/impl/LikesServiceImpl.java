package com.yuntravel.service.impl;


import com.yuntravel.dao.LikeMapper;
import com.yuntravel.po.StrategyLike;
import com.yuntravel.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LikesServiceImpl implements LikesService {


    @Autowired
    private LikeMapper likeMapper;

    public LikeMapper getLikesMapper() {
        return likeMapper;
    }

    public void setLikesMapper(LikeMapper likesMapper) {
        this.likeMapper = likesMapper;
    }

    @Override
    public StrategyLike qryByIds(int strategyId, int userId) {
        return likeMapper.qryByIds(strategyId,userId);
    }

    @Override
    public int delByIds(int strategyId, int userId) {
        return likeMapper.delByIds(strategyId,userId);
    }

    @Override
    public int addNew(int strategyId, int userId) {
        return likeMapper.addNew(strategyId,userId);
    }

    @Override
    public int getCountNum(int strategyId) {
        return likeMapper.getCountNum(strategyId);
    }

}
