package com.yuntravel.controller;

import com.yuntravel.bean.BaseMessage;
import com.yuntravel.po.Banners;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @RequestMapping(value = "/saveArticle",method = RequestMethod.POST)
    public @ResponseBody
    BaseMessage<String> saveArticle(@RequestBody String s){
        String s1=s;
        System.out.println(s);
        System.out.println(s1);
        return new BaseMessage<>(1,null,s);
    }

}
