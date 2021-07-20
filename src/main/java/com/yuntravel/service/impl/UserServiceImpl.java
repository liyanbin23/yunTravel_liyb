package com.yuntravel.service.impl;

import com.yuntravel.dao.UserMapper;
import com.yuntravel.po.Users;
import com.yuntravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
@Component
public class UserServiceImpl implements com.yuntravel.service.UserService {

    @Autowired
    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public UserMapper getUserMapper() {
        return userMapper;
    }

    @Override
    public Users login(String phone) {
        return userMapper.login(phone);
    }

    @Override
    public Users qryById(int id) {
        return userMapper.qryById(id);
    }

    @Override
    public int register(Users us) {
        int maxId=getMaxId();
        if(maxId>0){
            us.setUserId(maxId+1);
        }
        us.setGrade("1");
        Date date=new Date(System.currentTimeMillis());
        Timestamp tim=new Timestamp(date.getTime());
        us.setRegistDate(tim);
        return userMapper.register(us);
    }

    @Override
    public List<Users> qryAll() {
        return null;
    }

    @Override
    public List<Users> qryByPhone(String userPhone) {
        return userMapper.qryByPhone(userPhone);
    }

    @Override
    public int updateByUserId(Users us) {
        return userMapper.updateByUserId(us);
    }


    public int getMaxId() {
        return  userMapper.getMaxId();
    }
}
