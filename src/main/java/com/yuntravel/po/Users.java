package com.yuntravel.po;

import java.sql.Timestamp;

public class Users {
    private int userId;
    private String userPhone;
    private String nickName;
    private String password;
    private String email;
    private String usImage;
    private Timestamp registDate;
    private String safeDetail;
    private String grade;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsImage() {
        return usImage;
    }

    public void setUsImage(String usImage) {
        this.usImage = usImage;
    }

    public Timestamp getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Timestamp registDate) {
        this.registDate = registDate;
    }

    public String getSafeDetail() {
        return safeDetail;
    }

    public void setSafeDetail(String safeDetail) {
        this.safeDetail = safeDetail;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userPhone='" + userPhone + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", usImage='" + usImage + '\'' +
                ", registDate=" + registDate +
                ", safeDetail='" + safeDetail + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
