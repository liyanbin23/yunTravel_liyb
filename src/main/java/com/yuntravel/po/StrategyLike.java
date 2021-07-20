package com.yuntravel.po;

public class StrategyLike {

    private int slId;
    private int strategyId;
    private int userId;
    private String likeStatus;

    public StrategyLike() {
    }

    public StrategyLike(int slId, int strategyId, int userId, String likeStatus) {
        this.slId = slId;
        this.strategyId = strategyId;
        this.userId = userId;
        this.likeStatus = likeStatus;
    }

    public int getSlId() {
        return slId;
    }

    public void setSlId(int slId) {
        this.slId = slId;
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

    public String getLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(String likeStatus) {
        this.likeStatus = likeStatus;
    }
}
