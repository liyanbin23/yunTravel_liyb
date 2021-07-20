package com.yuntravel.service;

import com.github.pagehelper.PageInfo;
import com.yuntravel.po.Notice;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NoticeService {

    List<Notice> getNoticeList();

    PageInfo<Notice> getAllNotice(int pageSize,int currentPage);

    Notice getNoticeById(int id);

}
