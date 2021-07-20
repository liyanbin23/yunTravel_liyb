package com.yuntravel.dao;

import com.yuntravel.po.StrategyComment;
import com.yuntravel.po.StrategyComment_child;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StrategyChildCommMapper {
    List<StrategyComment_child> getChildCommById(@Param("parentId") int parentId);

    List<StrategyComment_child> getChildCommListByKey(@Param("content") String content);

    int getMaxChildId();

    int addChildComm(StrategyComment_child strategyComment_child);

}
