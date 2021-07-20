package com.yuntravel.service;

import com.github.pagehelper.PageInfo;
import com.yuntravel.po.Strategy;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StrategyService {
    PageInfo<Strategy> getStrategyList(int pageSize, int curPage, String city, int travelType, int travelDay);

    Strategy getStrategyById(int id);

    List<Strategy> getStrategyListByUserId(int uId);

    int getMaxStrategyId();

    int addStrategy(Strategy strategy);

    PageInfo<Strategy> getBaseStrategyList(int pageSize, int curPage);
    PageInfo<Strategy> getAuditStrategyList(int pageSize, int curPage,int strategyId,int adminId);
    PageInfo<Strategy> getUnAuditStrategyList(int pageSize, int curPage, String titles, int adminId, String auditTime);


    Strategy getBaseStrategyById( int strategyId);
    Strategy getAuditStrategyById(int strategyId);
    Strategy getUnAuditStrategyById( int strategyId);

    List<Strategy> getBadeStrategyListByUserId( int userId);
    List<Strategy> getAuditStrategyListByUserId(int userId);
    List<Strategy> getUnAuditStrategyListByUserId( int userId);


    int getBaseMaxStrategyId();
    int getAuditMaxStrategyId();
    int getUnAuditMaxStrategyId();

    int addBaseStrategy(Strategy strategy);
    int addAuditStrategy(Strategy strategy);
    int addUnAuditStrategy(Strategy strategy);



}
