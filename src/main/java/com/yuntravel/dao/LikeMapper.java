package com.yuntravel.dao;

import com.yuntravel.po.StrategyLike;
import org.apache.ibatis.annotations.Param;

public interface LikeMapper {
    StrategyLike qryByIds(@Param("strategyId") int strategyId, @Param("userId") int userId);

    int delByIds(@Param("strategyId")int strategyId,@Param("userId")int userId);

    int addNew(@Param("strategyId")int strategyId,@Param("userId")int userId);

    int getCountNum(@Param("strategyId")int strategyId);
}
