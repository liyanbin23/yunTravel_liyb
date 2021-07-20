package com.yuntravel.service;

import com.github.pagehelper.PageInfo;
import com.yuntravel.po.News;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NewsService {
    List<News> getNewsList();

    PageInfo<News> getAllNews(int pageSize, int currentPage);

    News getNewsById(int id);

}
