package com.yuntravel.controller;

import com.sun.net.httpserver.HttpContext;
import com.yuntravel.bean.BaseMessage;
import com.yuntravel.bean.MsgUserBean;
import com.yuntravel.po.Users;
import com.yuntravel.service.UserService;
import com.yuntravel.utils.PasswordUtil;
import com.yuntravel.utils.SendMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import java.util.List;


@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    private String msgCode;


    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    BaseMessage login(@RequestBody Users u, HttpSession session) {
        Users users = userService.login(u.getUserPhone().trim());
        if (users != null && users.getPassword().equals(u.getPassword().trim())) {
            session.setAttribute("user", users);
            return new BaseMessage<Users>(0, users);
        }
        return new BaseMessage<Object>(1, u);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody BaseMessage register(@RequestBody Users u, HttpSession session) {
        System.out.println(u.toString());
//        HttpSession session = request.getSession();
        //获得发送的验证码
//        String code1 = (String) session.getAttribute("code");
         //注册前检验号码是否已被注册
        List<Users> us=userService.qryByPhone(u.getUserPhone().trim());
        //
//        if (u.getCode().trim().equals(code1)&& us.size()==0 ) {
        if (us.size()==0 ) {
            int regRes=userService.register(u);
            if (regRes > 0) {
                return new BaseMessage<Users>(0,u,"注册成功！");
            }else{
                return new BaseMessage<Users>(1, u,"注册失败");
            }
        }else{
            return new BaseMessage<Users>(1, u,"号码已被注册！");
        }

    }

    @RequestMapping(value = "/qryById", method = RequestMethod.GET)
    public @ResponseBody BaseMessage qryById(@RequestParam("uId") int id, HttpSession session) {

        Users us=userService.qryById(id);
        if (us!=null) {
            return new BaseMessage<Users>(0, us,"获取成功");

        }else{
            return new BaseMessage<Users>(1, us,"获取失败！");
        }

    }

    @RequestMapping(value = "/getMsgCode",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage getMsgCode(@RequestParam("phone") String phone, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (phone != null&&phone!="") {
            String str = "";
            for (int i = 0; i < 5; i++) {
                str += (int) (Math.random() * 9);
            }
            SendMessage.send(phone, str);
            session.setAttribute("code", str);
//            HttpContext.Current.Session["code"] = str;
            String reCode= PasswordUtil.md5(str);
            System.out.println(str);
            return new BaseMessage(0, reCode,"发送成功");
        }
        return new BaseMessage(1, null,"发送失败");
    }
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public @ResponseBody BaseMessage updateUser(@RequestBody Users u, HttpSession session) {
        System.out.println(u.toString());
//        HttpSession session = request.getSession();
        //获得发送的验证码
//        String code1 = (String) session.getAttribute("code");
        //注册前检验号码是否已被注册
        int res=userService.updateByUserId(u);
        //
//        if (u.getCode().trim().equals(code1)&& us.size()==0 ) {
        if (res>0) {
                return new BaseMessage<Users>(0, u,"修改成功");
        }else{
            return new BaseMessage<Users>(1, u,"修改失败！");
        }

    }
    @RequestMapping(value = "/updateUserWithMsg", method = RequestMethod.PUT)
    public @ResponseBody BaseMessage updateUserWithMsg(@RequestBody MsgUserBean msgUserBean, HttpServletRequest request) {
             System.out.println(msgUserBean.toString());
        HttpSession session = request.getSession();
        //获得发送的验证码
        //注册前检验号码是否已被注册
        Users users=msgUserBean.getUsers();
        if(users!=null) {
            List<Users> us = userService.qryByPhone(users.getUserPhone().trim());
            if (us.size()==0) {
                int res = userService.updateByUserId(msgUserBean.getUsers());
                if (res > 0) {
                    return new BaseMessage(0, msgUserBean, "修改成功");
                } else {
                    return new BaseMessage(1, msgUserBean, "修改失败！");
                }
            }else{
                return new BaseMessage(1, msgUserBean, "号码已有注册！");
            }
        }
        return new BaseMessage(1, msgUserBean, "验证码不正确！");
    }

    @RequestMapping(value = "/updateUserPass", method = RequestMethod.PUT)
    public @ResponseBody BaseMessage updateUserPass(@RequestParam("phone") String  phone, @RequestParam("pass") String  pass) {

        //注册前检验号码是否已被注册
        Users users = userService.login(phone.trim());
            if (users!=null) {
                users.setPassword(pass);
                int res = userService.updateByUserId(users);
                if (res > 0) {
                    return new BaseMessage(0, users, "修改成功");
                } else {
                    return new BaseMessage(1, users, "修改失败！");
                }
            }else{
                return new BaseMessage(1, users, "号码还未注册！");
            }
    }

}
