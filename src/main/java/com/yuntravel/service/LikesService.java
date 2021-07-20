package com.yuntravel.service;

import com.yuntravel.po.StrategyLike;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface LikesService {

    StrategyLike qryByIds(int strategyId,int userId);

    int delByIds(int strategyId,int userId);

    int addNew(int strategyId,int userId);

    int getCountNum(int strategyId);

}
