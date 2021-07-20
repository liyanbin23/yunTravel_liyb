package com.yuntravel.dao;

import com.yuntravel.po.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeMapper {

    List<Notice> getNoticeList();

    List<Notice> getAllNotice();

    Notice getNoticeById(@Param("noticeId") int noticeId);

}
