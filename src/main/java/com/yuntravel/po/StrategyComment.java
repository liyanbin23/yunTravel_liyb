package com.yuntravel.po;

public class StrategyComment {

    private int id;
    private int strategyId;
    private int userId;
    private String content;
    private String createDate;
    private int status;

    public StrategyComment() {
    }

    public StrategyComment(int id, int strategyId, int userId, String content, String createDate, int status) {
        this.id = id;
        this.strategyId = strategyId;
        this.userId = userId;
        this.content = content;
        this.createDate = createDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
