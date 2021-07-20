package com.yuntravel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuntravel.dao.StrategyChildCommMapper;
import com.yuntravel.dao.StrategyCommMapper;
import com.yuntravel.po.StrategyComment;
import com.yuntravel.po.StrategyComment_child;
import com.yuntravel.service.StrategyCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StrategyCommentServiceImpl implements StrategyCommentService {

    @Autowired
    StrategyCommMapper strategyCommMapper;
    @Autowired
    StrategyChildCommMapper strategyChildCommMapper;

    @Override
    public List<StrategyComment> getCommListByStrId(int strategyId) {
        return strategyCommMapper.getCommListByStrId(strategyId);
    }

    @Override
    public List<StrategyComment_child> getChildCommById(int id) {
        return strategyChildCommMapper.getChildCommById(id);
    }

    @Override
    public PageInfo<StrategyComment> getCommentListByKey(int pageSize, int currentPage, String content) {
        PageHelper.startPage(currentPage,pageSize);
        List<StrategyComment> ls= strategyCommMapper.getCommListByKey(content);
        PageInfo pageInfo=new PageInfo(ls);
        return pageInfo;
    }

    @Override
    public PageInfo<StrategyComment_child> getChildCommentListByKey(int pageSize, int currentPage, String content) {
        PageHelper.startPage(currentPage,pageSize);
        List<StrategyComment_child> ls= strategyChildCommMapper.getChildCommListByKey(content);
        PageInfo pageInfo=new PageInfo(ls);
        return pageInfo;
    }

    @Override
    public int getMaxId() {
        return strategyCommMapper.getMaxId();
    }

    @Override
    public int getMaxChildId() {
        return strategyChildCommMapper.getMaxChildId();
    }

    @Override
    public int addStrategyComm(StrategyComment strategyComment) {
        return strategyCommMapper.addStrategyComm(strategyComment);
    }

    @Override
    public int addChildComm(StrategyComment_child strategyComment_child) {
        return strategyChildCommMapper.addChildComm(strategyComment_child);
    }
}
