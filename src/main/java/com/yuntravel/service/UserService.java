package com.yuntravel.service;

import com.yuntravel.po.Users;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    Users login(String phone);

    Users qryById(int id);

    int register(Users us);

    List<Users> qryAll();

    List<Users> qryByPhone(String userPhone);

    int updateByUserId(Users us);

}
