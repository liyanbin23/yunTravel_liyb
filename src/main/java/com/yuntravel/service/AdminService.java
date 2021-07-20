package com.yuntravel.service;

import com.github.pagehelper.PageInfo;
import com.yuntravel.po.Admin;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdminService {
    Admin login(String phone);

    Admin qryById(int id);

    int register(Admin us);

    PageInfo<Admin> qryAll(int pageSize,int currentPage);

    List<Admin> qryByPhone(String userPhone);

    int updateByUserId(Admin us);

    int getMaxAdminId();
}
