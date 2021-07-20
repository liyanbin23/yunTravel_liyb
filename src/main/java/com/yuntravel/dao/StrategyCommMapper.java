package com.yuntravel.dao;

import com.yuntravel.po.StrategyComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StrategyCommMapper {

    List<StrategyComment> getCommListByStrId(@Param("strategyId") int strategyId);

    List<StrategyComment> getCommListByKey(@Param("content") String content);

    int  getMaxId();

    int addStrategyComm(StrategyComment strategyComment);

}
