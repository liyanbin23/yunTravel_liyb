package com.yuntravel.po;

public class StrategyColl {

    private int scId;
    private int strategyId;
    private int userId;
    private String collectStatus;

    public StrategyColl() {
    }

    public StrategyColl(int scId, int strategyId, int userId, String collectStatus) {
        this.scId = scId;
        this.strategyId = strategyId;
        this.userId = userId;
        this.collectStatus = collectStatus;
    }

    public int getScId() {
        return scId;
    }

    public void setScId(int scId) {
        this.scId = scId;
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

    public String getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(String collectStatus) {
        this.collectStatus = collectStatus;
    }
}
