package com.yuntravel.po;

import java.sql.Date;

public class Notice {

    private int noticeId;
    private String noticePath;
    private String noticeTitle;
    private String noticeCont;
    private Date createTime;
    private String status;


    public Notice() {
    }

    public Notice(int noticeId, String noticePath, String noticeTitle, String noticeCont, Date createTime, String status) {
        this.noticeId = noticeId;
        this.noticePath = noticePath;
        this.noticeTitle = noticeTitle;
        this.noticeCont = noticeCont;
        this.createTime = createTime;
        this.status = status;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticePath() {
        return noticePath;
    }

    public void setNoticePath(String noticePath) {
        this.noticePath = noticePath;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeCont() {
        return noticeCont;
    }

    public void setNoticeCont(String noticeCont) {
        this.noticeCont = noticeCont;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
