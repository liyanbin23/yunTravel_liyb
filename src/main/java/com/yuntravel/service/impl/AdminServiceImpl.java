package com.yuntravel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuntravel.dao.AdminMapper;
import com.yuntravel.po.Admin;
import com.yuntravel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String phone) {
        return adminMapper.login(phone);
    }

    @Override
    public Admin qryById(int id) {
        return null;
    }

    @Override
    public int register(Admin us) {

        return adminMapper.register(us);
    }

    @Override
    public PageInfo<Admin> qryAll(int pageSize,int currentPage) {
        PageHelper.startPage(currentPage,pageSize);
        List<Admin> ls=adminMapper.qryAll();
        PageInfo pageInfo=new PageInfo(ls);
        return pageInfo;
    }

    @Override
    public List<Admin> qryByPhone(String userPhone) {
        return null;
    }

    @Override
    public int updateByUserId(Admin us) {
        return 0;
    }

    @Override
    public int getMaxAdminId() {
        return adminMapper.getMaxAdminId();
    }
}
