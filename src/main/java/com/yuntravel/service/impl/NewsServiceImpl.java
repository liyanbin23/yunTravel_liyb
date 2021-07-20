package com.yuntravel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuntravel.dao.NewsMapper;
import com.yuntravel.po.News;
import com.yuntravel.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsMapper newsMapper;

    @Override
    public List<News> getNewsList() {
        return newsMapper.getNewsList();
    }

    @Override
    public PageInfo<News> getAllNews(int pageSize, int currentPage) {
        PageHelper.startPage(currentPage,pageSize);
        List<News> ls=newsMapper.getAllNews();
        PageInfo<News> pageInfo=new PageInfo<>(ls);
        return pageInfo;
    }

    @Override
    public News getNewsById(int id) {
        return newsMapper.getNewsById(id);
    }
}
