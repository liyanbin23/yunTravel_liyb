package com.yuntravel.dao;

import com.github.pagehelper.PageInfo;
import com.yuntravel.po.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    List<News> getNewsList();

    List<News> getAllNews();

    News getNewsById(@Param("newsId") int newsId);

    List<News> getNewsByKey(@Param("key") String key);

}
