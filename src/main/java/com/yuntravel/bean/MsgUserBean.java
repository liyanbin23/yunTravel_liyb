package com.yuntravel.bean;

import com.yuntravel.po.Users;

public class MsgUserBean {
    private Users users;
    private String code;

    public MsgUserBean() {
    }

    public MsgUserBean(Users users, String code) {
        this.users = users;
        this.code = code;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "MsgUserBean{" +
                "users=" + users.toString() +
                ", code='" + code + '\'' +
                '}';
    }
}
