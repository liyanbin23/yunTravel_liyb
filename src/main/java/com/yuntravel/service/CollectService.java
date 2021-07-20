package com.yuntravel.service;

import com.yuntravel.po.StrategyColl;
import org.springframework.stereotype.Service;

@Service
public interface CollectService {

    StrategyColl qryByIds(int strategyId, int userId);

    int delByIds(int strategyId,int userId);

    int addNew(int strategyId, int userId);

    int getCountNum(int strategyId);
}
