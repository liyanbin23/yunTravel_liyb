package com.yuntravel.dao;

import com.yuntravel.po.Strategy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StrategyAuditMapper {

    List<Strategy> getBaseStrategyList();
    List<Strategy> getAuditStrategyList( @Param("strategyId") int strategyId,@Param("adminId") int adminId);
    List<Strategy> getUnAuditStrategyList(@Param("titles") String titles, @Param("adminId") int adminId, @Param("auditTime") String auditTime);


    Strategy getBaseStrategyById(@Param("strategyId") int strategyId);
    Strategy getAuditStrategyById(@Param("strategyId") int strategyId);
    Strategy getUnAuditStrategyById(@Param("strategyId") int strategyId);

    List<Strategy> getBadeStrategyListByUserId(@Param("userId") int userId);
    List<Strategy> getAuditStrategyListByUserId(@Param("userId") int userId);
    List<Strategy> getUnAuditStrategyListByUserId(@Param("userId") int userId);


    int getBaseMaxStrategyId();
    int getAuditMaxStrategyId();
    int getUnAuditMaxStrategyId();

    int addBaseStrategy(Strategy strategy);
    int addAuditStrategy(Strategy strategy);
    int addUnAuditStrategy(Strategy strategy);


}
