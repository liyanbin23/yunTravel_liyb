package com.yuntravel.dao;

import com.yuntravel.po.Users;

import java.util.List;

public interface UserMapper {
     Users login(String userPhone);

     Users qryById(int id);
     int register(Users us);

     List<Users> qryAll();

     List<Users> qryByPhone(String userPhone);

     List<Users> qryByName(String nickName);

     int updateByUserId(Users us);

     int getMaxId();


}
