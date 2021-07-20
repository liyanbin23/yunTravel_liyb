package com.yuntravel.po;

import java.sql.Timestamp;

public class Admin {
    private int adminId;
    private String phone;
    private String nickName;
    private String password;
    private String email;
    private String usImage;
    private int roleNum;

    public Admin() {
    }

    public Admin(int adminId, String phone, String nickName, String password, String email, String usImage, int roleNum) {
        this.adminId = adminId;
        this.phone = phone;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
        this.usImage = usImage;
        this.roleNum = roleNum;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public int getRoleNum() {
        return roleNum;
    }

    public void setRoleNum(int roleNum) {
        this.roleNum = roleNum;
    }
}
