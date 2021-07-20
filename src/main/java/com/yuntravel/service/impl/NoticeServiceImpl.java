package com.yuntravel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuntravel.dao.NoticeMapper;
import com.yuntravel.po.Notice;
import com.yuntravel.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> getNoticeList() {
        return noticeMapper.getNoticeList();
    }

    @Override
    public PageInfo<Notice> getAllNotice(int pageSize,int currentPage) {
        PageHelper.startPage(currentPage,pageSize);
        List<Notice> ls=noticeMapper.getAllNotice();
        PageInfo<Notice> pageInfo=new PageInfo<>(ls);
        return pageInfo;
    }

    @Override
    public Notice getNoticeById(int id) {
        return noticeMapper.getNoticeById(id);
    }
}
