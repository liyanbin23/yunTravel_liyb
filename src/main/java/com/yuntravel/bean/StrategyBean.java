package com.yuntravel.bean;

import com.yuntravel.po.Strategy;
import com.yuntravel.po.Users;
import org.apache.poi.ss.formula.functions.T;

public class StrategyBean {
    private Strategy strategy;
    private Users users;
    private boolean isLike;
    private boolean isCollect;
    private int likeNum;
    private int collectNum;
    private String city;
    private String travelType;

    public StrategyBean() {
    }

    public StrategyBean(Strategy strategy, Users users, boolean isLike, boolean isCollect, int likeNum, int collectNum, String city, String travelType) {
        this.strategy = strategy;
        this.users = users;
        this.isLike = isLike;
        this.isCollect = isCollect;
        this.likeNum = likeNum;
        this.collectNum = collectNum;
        this.city = city;
        this.travelType = travelType;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public boolean isCollect() {
        return isCollect;
    }

    public void setCollect(boolean collect) {
        isCollect = collect;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }
}
