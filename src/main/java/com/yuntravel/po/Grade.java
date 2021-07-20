package com.yuntravel.po;

public class Grade {
    private int grId;
    private int sightsId;
    private int userId;
    private Float grade;

    public Grade() {
    }

    public Grade(int grId, int sightsId, int userId, Float grade) {
        this.grId = grId;
        this.sightsId = sightsId;
        this.userId = userId;
        this.grade = grade;
    }

    public int getGrId() {
        return grId;
    }

    public void setGrId(int grId) {
        this.grId = grId;
    }

    public int getSightsId() {
        return sightsId;
    }

    public void setSightsId(int sightsId) {
        this.sightsId = sightsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }
}
