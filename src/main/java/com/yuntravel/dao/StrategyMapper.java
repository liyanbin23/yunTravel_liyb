package com.yuntravel.dao;

import com.yuntravel.po.Strategy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StrategyMapper {
    List<Strategy> getStrategyList(@Param("city") String city,@Param("travelType") int travelType,@Param("travelDay") int travelDay);

    Strategy getStrategyById(@Param("strategyId") int strategyId);

    List<Strategy> getStrategyListByUserId(@Param("userId") int userId);

    int getMaxStrategyId();

    int addStrategy(Strategy strategy);


}
