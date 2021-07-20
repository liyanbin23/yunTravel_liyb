package com.yuntravel.service;

import com.github.pagehelper.PageInfo;
import com.yuntravel.po.StrategyComment;
import com.yuntravel.po.StrategyComment_child;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StrategyCommentService {

    List<StrategyComment> getCommListByStrId(int strategyId);

    List<StrategyComment_child> getChildCommById(int id);

    PageInfo<StrategyComment> getCommentListByKey(int pageSize,int currentPage,String content);

    PageInfo<StrategyComment_child> getChildCommentListByKey(int pageSize,int currentPage,String content);

    int  getMaxId();

    int getMaxChildId();

    int addStrategyComm(StrategyComment strategyComment);

    int addChildComm(StrategyComment_child strategyComment_child);

}
