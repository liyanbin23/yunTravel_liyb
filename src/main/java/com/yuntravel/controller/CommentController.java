package com.yuntravel.controller;


import com.yuntravel.bean.BaseMessage;
import com.yuntravel.po.StrategyComment;
import com.yuntravel.po.StrategyComment_child;
import com.yuntravel.service.StrategyCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    StrategyCommentService strategyCommentService;


    @RequestMapping(value = "/addStrategyComm",method = RequestMethod.PUT)
    public @ResponseBody
    BaseMessage addStrategyComm(@RequestBody StrategyComment strategyComment){

        int maxId=strategyCommentService.getMaxId();
        if(maxId!=0){
            strategyComment.setId(maxId+1);
        }
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String date=format.format(new Date());
        strategyComment.setCreateDate(date);
        strategyComment.setStatus(0);
        int result=strategyCommentService.addStrategyComm(strategyComment);
        if(result>0){
            return new BaseMessage(0,null,"评论成功");
        }
        return new BaseMessage(1,null,"评论失败");
    }

    @RequestMapping(value = "/addChildComm",method = RequestMethod.PUT)
    public @ResponseBody
    BaseMessage addChildComm(@RequestBody StrategyComment_child strategyComment_child){
        int maxId=strategyCommentService.getMaxChildId();
        if(maxId!=0){
            strategyComment_child.setId(maxId+1);
        }
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String date=format.format(new Date());
        strategyComment_child.setCreateDate(date);
        strategyComment_child.setStatus(0);
        int result=strategyCommentService.addChildComm(strategyComment_child);
        if(result>0){
            return new BaseMessage(0,null,"评论成功");
        }
        return new BaseMessage(1,null,"评论失败");
    }

}
