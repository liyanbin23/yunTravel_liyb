package com.yuntravel.controller;

import com.github.pagehelper.PageInfo;
import com.yuntravel.bean.BaseMessage;
import com.yuntravel.bean.StrategyBean;
import com.yuntravel.po.*;
import com.yuntravel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ManageController {

    @Autowired
    BannersService bannersService;
    @Autowired
    SightsService sightsService;
    @Autowired
    StrategyService strategyService;
    @Autowired
    UserService userService;
    @Autowired
    CityService cityService;
    @Autowired
    LikesService likesService;
    @Autowired
    CollectService collectService;
    @Autowired
    TypeService typeService;
    @Autowired
    StrategyCommentService strategyCommentService;
    @Autowired
    NoticeService noticeService;


    //获得景点列表
    @RequestMapping(value = "/getSights",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<PageInfo<Sights>> getSights(@RequestParam("pageSize") int pageSize , @RequestParam("currentPage") int currentPage,@RequestParam("city") String city,@RequestParam("title") String title){
        System.out.println("进来到这里了");
        PageInfo<Sights> ls= sightsService.qryAllSightsWithKey(pageSize,currentPage,city,title);
        if(ls.getSize()>0){
            return new BaseMessage<>(0,ls,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getSightById",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<Sights> getSightById(@RequestParam("sightsId") int sightsId){

        Sights sights= sightsService.qrySightsById(sightsId);
        if(sights!=null){
            return new BaseMessage<>(0,sights,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

     //景点
    @RequestMapping(value = "/addNewSights",method = RequestMethod.PUT)
    public @ResponseBody
    BaseMessage addNewSights( @RequestBody Sights sights){
        System.out.println("进来到这里了");
        int maxId=sightsService.getMaxId();
        if(maxId!=0){
            sights.setSightsId(maxId+1);
        }
        sights.setCreateDate(new Date(System.currentTimeMillis()));
        sights.setGrade(0);
        sights.setViewsNum(0);
        int res= sightsService.addNewSights(sights);
        if(res>0){
            return new BaseMessage<>(0,res,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    //景点更新
    @RequestMapping(value = "/updateSights",method = RequestMethod.PUT)
    public @ResponseBody
    BaseMessage updateSights( @RequestBody Sights sights){
        System.out.println("进来到这里了");

        int res= sightsService.updateSights(sights);
        if(res>0){
            return new BaseMessage<>(0,res,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    //待审核攻略
    @RequestMapping(value = "/getBaseStrategyList",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<PageInfo<Strategy>> getBaseStrategyList(@RequestParam("pageSize") int pageSize , @RequestParam("currentPage") int currentPage){
        System.out.println("进来到这里了");
        //获得攻略信息
        PageInfo<Strategy> ls= strategyService.getBaseStrategyList(pageSize,currentPage);
        if(ls.getSize()>0){

            return new BaseMessage<>(0,ls,"获取成功！");

            }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getBaseStrategyById",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<StrategyBean> getBaseStrategyById(@RequestParam("strategyId") int strategyId ){
        System.out.println("进来到这里了");
        StrategyBean strategyBean =new StrategyBean();;//返回数据封装
        //获得攻略信息
        Strategy strategy= strategyService.getBaseStrategyById(strategyId);
        if(strategy!=null){
            strategyBean.setStrategy(strategy);
            String cityName=cityService.getCityNameById(Integer.parseInt(strategy.getCitys()));
            strategyBean.setCity(cityName);
            String typeName=typeService.getNameById(strategy.getTypes());
            strategyBean.setTravelType(typeName);
            return new BaseMessage<>(0, strategyBean,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }
    //已审核攻略
    @RequestMapping(value = "/getAuditStrategyList",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<PageInfo<Strategy>> getAuditStrategyList(@RequestParam("pageSize") int pageSize , @RequestParam("currentPage") int currentPage,@RequestParam("strategyId") int strategyId,@RequestParam("adminId") int adminId){
        System.out.println("进来到这里了");
        //获得攻略信息
        PageInfo<Strategy> ls= strategyService.getAuditStrategyList(pageSize,currentPage,strategyId,adminId);
        if(ls.getSize()>0){

            return new BaseMessage<>(0,ls,"获取成功！");

        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getAuditStrategyById",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<StrategyBean> getAuditStrategyById(@RequestParam("strategyId") int strategyId ){
        System.out.println("进来到这里了");
        StrategyBean strategyBean =new StrategyBean();;//返回数据封装
        //获得攻略信息
        Strategy strategy= strategyService.getAuditStrategyById(strategyId);
        if(strategy!=null){
            strategyBean.setStrategy(strategy);
            String cityName=cityService.getCityNameById(Integer.parseInt(strategy.getCitys()));
            strategyBean.setCity(cityName);
            String typeName=typeService.getNameById(strategy.getTypes());
            strategyBean.setTravelType(typeName);
            return new BaseMessage<>(0, strategyBean,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getUnAuditStrategyList",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<PageInfo<Strategy>> getUnAuditStrategyList(@RequestParam("pageSize") int pageSize , @RequestParam("currentPage") int currentPage,@RequestParam("titles") String titles,@RequestParam("adminId") int adminId,@RequestParam("auditTime") String auditTime){
        System.out.println("进来到这里了");
        //获得攻略信息
        PageInfo<Strategy> ls= strategyService.getUnAuditStrategyList(pageSize,currentPage,titles,adminId,auditTime);
        if(ls.getSize()>0){

            return new BaseMessage<>(0,ls,"获取成功！");

        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getUnAuditStrategyById",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<StrategyBean> getUnAuditStrategyById(@RequestParam("strategyId") int strategyId ){
        System.out.println("进来到这里了");
        StrategyBean strategyBean =new StrategyBean();;//返回数据封装
        //获得攻略信息
        Strategy strategy= strategyService.getUnAuditStrategyById(strategyId);
        if(strategy!=null){
            strategyBean.setStrategy(strategy);
            String cityName=cityService.getCityNameById(Integer.parseInt(strategy.getCitys()));
            strategyBean.setCity(cityName);
            String typeName=typeService.getNameById(strategy.getTypes());
            strategyBean.setTravelType(typeName);
            return new BaseMessage<>(0, strategyBean,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }


    @RequestMapping(value = "/getAllBanners",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<PageInfo<Banners>> getAllBanners(@RequestParam("pageSize") int pageSize , @RequestParam("currentPage") int currentPage){
        System.out.println("进来到这里了");
        StrategyBean strategyBean =new StrategyBean();//返回数据封装
        //获得攻略信息
        PageInfo<Banners> bannList = bannersService.getAllBanner(pageSize,currentPage);
        if(bannList!=null&&bannList.getSize()>0){

            return new BaseMessage<>(0, bannList,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/addBanners",method = RequestMethod.PUT)
    public @ResponseBody
    BaseMessage addBanners(@RequestBody Banners banners){

        int maxId=bannersService.getMaxBannerId();
        if(maxId!=0){
            banners.setImgId(maxId+1);
        }
        int res=bannersService.addBanner(banners);
        if(res>0){

            return new BaseMessage<>(0, banners,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/deleteBanner",method = RequestMethod.PUT)
    public @ResponseBody
    BaseMessage deleteBanner(@RequestBody Banners banners){
        if(banners!=null){
            int res=bannersService.delBanner(banners.getImgId());
            if(res>0){

                return new BaseMessage<>(0, banners,"操作成功！");
            }
            return new BaseMessage<>(1,null,"获取失败！");
        }
        return new BaseMessage<>(1,null,"参数错误！");
    }

    @RequestMapping(value = "/getCommentList",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<PageInfo<StrategyComment>> getCommentList(@RequestParam("pageSize") int pageSize , @RequestParam("currentPage") int currentPage,@RequestParam("content") String content){

        StrategyBean strategyBean =new StrategyBean();//返回数据封装
        //获得攻略信息
        PageInfo<StrategyComment> commentList = strategyCommentService.getCommentListByKey(pageSize,currentPage,content);
        if(commentList.getSize()>0){

            return new BaseMessage<>(0, commentList,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }


    @RequestMapping(value = "/getChildCommentList",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<PageInfo<StrategyComment_child>> getChildCommentList(@RequestParam("pageSize") int pageSize , @RequestParam("currentPage") int currentPage,@RequestParam("content") String content){

        StrategyBean strategyBean =new StrategyBean();//返回数据封装
        //获得攻略信息
        PageInfo<StrategyComment_child> commentList = strategyCommentService.getChildCommentListByKey(pageSize,currentPage,content);
        if(commentList.getSize()>0){

            return new BaseMessage<>(0, commentList,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getNoticeList",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<PageInfo<Notice>> getNoticeList(@RequestParam("pageSize") int pageSize , @RequestParam("currentPage") int currentPage){

        StrategyBean strategyBean =new StrategyBean();//返回数据封装
        //获得攻略信息
        PageInfo<Notice> noticeList = noticeService.getAllNotice(pageSize,currentPage);
        if(noticeList.getSize()>0){

            return new BaseMessage<>(0, noticeList,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/strategyAudit",method = RequestMethod.PUT)
    public @ResponseBody
    BaseMessage strategyAudit(@RequestParam("strategy") Strategy strategy,@RequestParam("adminId") int adminId ){

        if(strategy!=null&&adminId!=0){
            strategy.setAdminId(adminId);
            int maxAuditId=strategyService.getAuditMaxStrategyId();
            if(maxAuditId!=0){
                strategy.setStrategyId(maxAuditId);
            }
            strategy.setAuditTime(new Date(System.currentTimeMillis()));
            int res=strategyService.addAuditStrategy(strategy);
            if(res>0){
                return new BaseMessage<>(0, null,"审核成功！");
            }
            return new BaseMessage<>(1, null,"参数错误！");
        }
        return new BaseMessage<>(1,null,"审核失败！");
    }

}
