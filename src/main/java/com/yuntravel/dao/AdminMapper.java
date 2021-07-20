package com.yuntravel.dao;

import com.yuntravel.po.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    Admin login(@Param("phone") String phone);

    Admin qryById(int id);

    int register(Admin us);

    List<Admin> qryAll();

    List<Admin> qryByPhone(String userPhone);

    int updateByUserId(Admin us);

    int getMaxAdminId();
}
