package com.yuntravel.controller;

import com.github.pagehelper.PageInfo;
import com.yuntravel.bean.BaseMessage;
import com.yuntravel.bean.StrategyBean;
import com.yuntravel.po.Admin;
import com.yuntravel.po.StrategyComment_child;
import com.yuntravel.po.Users;
import com.yuntravel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    BaseMessage login(@RequestBody Admin admin, HttpSession session) {
        Admin admin1 = adminService.login(admin.getPhone().trim());
        if (admin1 != null && admin1.getPassword().equals(admin.getPassword().trim())) {
            session.setAttribute("user", admin1);
            return new BaseMessage<Admin>(0, admin1);
        }
        return new BaseMessage<Object>(1, admin1);
    }

    @RequestMapping(value = "/getAllAdmin",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<PageInfo<Admin>> getAllAdmin(@RequestParam("pageSize") int pageSize , @RequestParam("currentPage") int currentPage){
        //获得攻略信息
        PageInfo<Admin> adminList = adminService.qryAll(pageSize,currentPage);
        if(adminList.getSize()>0){

            return new BaseMessage<>(0, adminList,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/register", method = RequestMethod.PUT)
    public @ResponseBody
    BaseMessage register(@RequestBody Admin admin) {
        int maxId=adminService.getMaxAdminId();
        if(maxId!=0){
            admin.setAdminId(maxId+1);
            admin.setRoleNum(1);

            int res=adminService.register(admin);
            if(res>0){
                return new BaseMessage<Admin>(0, admin,"注册成功");
            }
            return new BaseMessage<Admin>(1, null,"注册失败");
        }
            return new BaseMessage<Admin>(1, null,"未获得正确ID");
        }

}
