package com.yuntravel.po;

import java.sql.Date;

public class News {
    private int newsId;
    private String newsPath;
    private String newsTitle;
    private String newsCont;
    private Date createTime;
    private String status;

    public News() {
    }

    public News(int newsId, String newsPath, String newsTitle, String newsCont, Date createTime, String status) {
        this.newsId = newsId;
        this.newsPath = newsPath;
        this.newsTitle = newsTitle;
        this.newsCont = newsCont;
        this.createTime = createTime;
        this.status = status;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsPath() {
        return newsPath;
    }

    public void setNewsPath(String newsPath) {
        this.newsPath = newsPath;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsCont() {
        return newsCont;
    }

    public void setNewsCont(String newsCont) {
        this.newsCont = newsCont;
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
