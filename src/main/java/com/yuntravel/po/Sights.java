package com.yuntravel.po;

import java.sql.Date;

public class Sights {
    private int sightsId;
    private String sightsName;
    private String sightDetail;
    private String author;
    private String city;
    private String cityLocation;
    private String headerImg;
    private String aboutVideo;
    private String article;
    private float grade;
    private int viewsNum;
    private Date createDate;

    public Sights() {

    }

    public Sights(int sightsId, String sightsName, String sightDetail, String author, String city, String cityLocation, String headerImg, String aboutVideo, String article, float grade, int viewsNum, Date createDate) {
        this.sightsId = sightsId;
        this.sightsName = sightsName;
        this.sightDetail = sightDetail;
        this.author = author;
        this.city = city;
        this.cityLocation = cityLocation;
        this.headerImg = headerImg;
        this.aboutVideo = aboutVideo;
        this.article = article;
        this.grade = grade;
        this.viewsNum = viewsNum;
        this.createDate = createDate;
    }

    public int getSightsId() {
        return sightsId;
    }

    public void setSightsId(int sightsId) {
        this.sightsId = sightsId;
    }

    public String getSightsName() {
        return sightsName;
    }

    public void setSightsName(String sightsName) {
        this.sightsName = sightsName;
    }

    public String getSightDetail() {
        return sightDetail;
    }

    public void setSightDetail(String sightDetail) {
        this.sightDetail = sightDetail;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityLocation() {
        return cityLocation;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

    public String getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    public String getAboutVideo() {
        return aboutVideo;
    }

    public void setAboutVideo(String aboutVideo) {
        this.aboutVideo = aboutVideo;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getViewsNum() {
        return viewsNum;
    }

    public void setViewsNum(int viewsNum) {
        this.viewsNum = viewsNum;
    }
}
