package com.yuntravel.controller;

import com.yuntravel.bean.BaseMessage;
import com.yuntravel.po.Strategy;
import com.yuntravel.po.Users;
import com.yuntravel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
@CrossOrigin
@RequestMapping("/strategy")
public class StrategyController {

    @Autowired
    StrategyService strategyService;
    @Autowired
    LikesService likesService;
    @Autowired
    CollectService collectService;
    @Autowired
    CityService cityService;
    @Autowired
    TypeService typeService;

    @RequestMapping(value = "/addLike", method = RequestMethod.PUT)
    public @ResponseBody
    BaseMessage addLike(@RequestParam("strategyId") int strategyId, @RequestParam("uId") int currentUId, @RequestParam("method") String method) {

        if("add".equals(method)){
            int dl= likesService.delByIds(strategyId,currentUId);
            int add=likesService.addNew(strategyId,currentUId);
            if(add>0){
                return new BaseMessage<Users>(0, null,"添加成功");
            }else{
                return new BaseMessage<Users>(0, null,"失败");
            }
        }else if("del".equals(method)){
            int dl= likesService.delByIds(strategyId,currentUId);
            if(dl>0){
                return new BaseMessage<Users>(0, null,"添加成功");
            }else{
                return new BaseMessage<Users>(0, null,"失败");
            }
        }
        return new BaseMessage<Object>(1, null,"无方法值");
    }

    @RequestMapping(value = "/addCollect", method = RequestMethod.PUT)
    public @ResponseBody
    BaseMessage addCollect(@RequestParam("strategyId") int strategyId, @RequestParam("uId") int currentUId, @RequestParam("method") String method) {

        if("add".equals(method)){
            int dl= collectService.delByIds(strategyId,currentUId);
            int add=collectService.addNew(strategyId,currentUId);
            if(add>0){
                return new BaseMessage<Users>(0, null,"添加成功");
            }else{
                return new BaseMessage<Users>(0, null,"失败");
            }
        }else if("del".equals(method)){
            int dl= collectService.delByIds(strategyId,currentUId);
            if(dl>0){
                return new BaseMessage<Users>(0, null,"添加成功");
            }else{
                return new BaseMessage<Users>(1, null,"失败");
            }
        }
        return new BaseMessage<Object>(1, null,"无方法值");
    }

    @RequestMapping(value = "addStrategy" ,method = RequestMethod.PUT)
    public @ResponseBody BaseMessage addStrategy(@RequestBody Strategy strategy){

        System.out.println(strategy.toString());
        //id列自增在后端服务处理
        int strategyId=strategyService.getMaxStrategyId();
        System.out.println(strategyId);
        strategy.setStrategyId(strategyId+1);
        strategy.setCreateTime(new Date(System.currentTimeMillis()));
        strategy.setStatus(0);
          //根据消费人均日消费获得旅游类型
        float expen=0;
        if(strategy.getExpen()!=0&&strategy.getTravelDays()!=0){
            expen=strategy.getExpen()/strategy.getTravelDays();
        }
        int typeId=typeService.getId(expen);
        if(typeId!=0){
            strategy.setTypes(typeId);
        }
        int result=strategyService.addStrategy(strategy);
        System.out.println(result);
        if(result>0){
            return new BaseMessage<Users>(0, null,"添加成功");
        }
        return new BaseMessage<Object>(1, null,"无方法值");
    }
}
