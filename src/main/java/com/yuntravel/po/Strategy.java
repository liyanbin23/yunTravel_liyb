package com.yuntravel.po;

import java.sql.Date;

public class Strategy {

    private int strategyId;
    private int userId;
    private String titles;
    private String headImg;
    private String citys;
    private String router;
    private float expen;
    private String articleCont;
    private int travelDays;
    private Date createTime;
    private int types;
    private int status;

    private int adminId;
    private String reason;
    private Date auditTime;

    public Strategy() {
    }

    public Strategy(int strategyId, int userId, String titles, String headImg, String citys, String router, float expen, String articleCont, int travelDays, Date createTime, int types, int status) {
        this.strategyId = strategyId;
        this.userId = userId;
        this.titles = titles;
        this.headImg = headImg;
        this.citys = citys;
        this.router = router;
        this.expen = expen;
        this.articleCont = articleCont;
        this.travelDays = travelDays;
        this.createTime = createTime;
        this.types = types;
        this.status = status;
    }

    public Strategy(int strategyId, int userId, String titles, String headImg, String citys, String router, float expen, String articleCont, int travelDays, Date createTime, int types, int status, int adminId, Date auditTime) {
        this.strategyId = strategyId;
        this.userId = userId;
        this.titles = titles;
        this.headImg = headImg;
        this.citys = citys;
        this.router = router;
        this.expen = expen;
        this.articleCont = articleCont;
        this.travelDays = travelDays;
        this.createTime = createTime;
        this.types = types;
        this.status = status;
        this.adminId = adminId;
        this.auditTime = auditTime;
    }

    public Strategy(int strategyId, int userId, String titles, String headImg, String citys, String router, float expen, String articleCont, int travelDays, Date createTime, int types, int status, int adminId, String reason, Date auditTime) {
        this.strategyId = strategyId;
        this.userId = userId;
        this.titles = titles;
        this.headImg = headImg;
        this.citys = citys;
        this.router = router;
        this.expen = expen;
        this.articleCont = articleCont;
        this.travelDays = travelDays;
        this.createTime = createTime;
        this.types = types;
        this.status = status;
        this.adminId = adminId;
        this.reason = reason;
        this.auditTime = auditTime;
    }

    public int getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(int strategyId) {
        this.strategyId = strategyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getCitys() {
        return citys;
    }

    public void setCitys(String citys) {
        this.citys = citys;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public float getExpen() {
        return expen;
    }

    public void setExpen(float expen) {
        this.expen = expen;
    }

    public String getArticleCont() {
        return articleCont;
    }

    public void setArticleCont(String articleCont) {
        this.articleCont = articleCont;
    }

    public int getTravelDays() {
        return travelDays;
    }

    public void setTravelDays(int travelDays) {
        this.travelDays = travelDays;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTypes() {
        return types;
    }

    public void setTypes(int types) {
        this.types = types;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    @Override
    public String toString() {
        return "Strategy{" +
                "strategyId=" + strategyId +
                ", userId=" + userId +
                ", titles='" + titles + '\'' +
                ", headImg='" + headImg + '\'' +
                ", citys='" + citys + '\'' +
                ", router='" + router + '\'' +
                ", expen=" + expen +
                ", articleCont='" + articleCont + '\'' +
                ", travelDays=" + travelDays +
                ", createTime=" + createTime +
                ", types=" + types +
                ", status=" + status +
                ", adminId=" + adminId +
                ", reason='" + reason + '\'' +
                ", auditTime=" + auditTime +
                '}';
    }
}
