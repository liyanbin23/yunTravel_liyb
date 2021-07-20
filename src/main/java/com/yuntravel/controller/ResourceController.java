package com.yuntravel.controller;

import com.github.pagehelper.PageInfo;
import com.yuntravel.bean.*;
import com.yuntravel.po.*;
import com.yuntravel.service.*;
import com.yuntravel.utils.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/resources")
public class ResourceController {

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
    @Autowired
    NewsService newsService;


    @RequestMapping(value = "/getHomeBanners",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<List<Banners>> getHomeBanner(){
       List<Banners> ls= bannersService.getHomeBanner();
       if(ls.size()>0){
           return new BaseMessage<>(0,ls,"获取成功！");
       }
       return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getSightBanner",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<List<Banners>> getSightBanner(){
        List<Banners> ls= bannersService.getSightBanner();
        if(ls.size()>0){
            return new BaseMessage<>(0,ls,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getSights",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<PageInfo<Sights>> getSights(@RequestParam("pageSize") int pageSize ,@RequestParam("currentPage") int currentPage,@RequestParam("key") String key){
        System.out.println("进来到这里了");
        PageInfo<Sights> ls= sightsService.qryAllSightsByCity(pageSize,currentPage,key);
        if(ls.getSize()>0){
            return new BaseMessage<>(0,ls,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getSightById",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<Sights> getSightById(@RequestParam("sightsId") int sightsId){
        System.out.println("进来到这里了");
        int addViewsNum=sightsService.addViewsNum(sightsId);
        Sights sights= sightsService.qrySightsById(sightsId);
        if(sights!=null){
            int cityId=Integer.parseInt(sights.getCity());
            String city=cityService.getCityNameById(cityId);
            if(city!=null||city!=""){
                sights.setCity(city);
            }

            return new BaseMessage<>(0,sights,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getStrategyList",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<PageInfo<StrategyBean>> getStrategyList(@RequestParam("pageSize") int pageSize , @RequestParam("currentPage") int currentPage, @RequestParam("travelType") int travelType, @RequestParam("city") String city, @RequestParam("travelDay") int travelDay, @RequestParam("uId") int currentUId ){
        System.out.println("进来到这里了");
        StrategyBean strategyBean =null;//返回数据封装
        List<StrategyBean> resList=new ArrayList<>();//返回结果集
        //获得攻略信息
        PageInfo<Strategy> ls= strategyService.getStrategyList(pageSize,currentPage,city,travelType,travelDay);

        if(ls.getSize()>0){
            long total=ls.getTotal();
            System.out.println(total);
           List<Strategy> list= ls.getList();
           if(list.size()>0){
               //绑定攻略相关信息
               StrategyLike sl=new StrategyLike();
               StrategyColl sc=new StrategyColl();
               for(Strategy strategy:list){
                   strategyBean =new StrategyBean();
                   int id=strategy.getUserId();
                   int stId=strategy.getStrategyId();
                   Users us=userService.qryById(id);
                   if(us!=null){
                       strategyBean.setUsers(us);
                   }
                   strategyBean.setStrategy(strategy);
                   if( currentUId==0) {
                       strategyBean.setLike(false);
                       strategyBean.setCollect(false);
                   }else{
                       sc=collectService.qryByIds(stId,currentUId);
                       if(sc!=null){
                           strategyBean.setCollect(true);
                       }else {
                           strategyBean.setCollect(false);
                       }
                       sl=likesService.qryByIds(stId,currentUId);
                       if(sl!=null){
                           strategyBean.setLike(true);
                       }else{
                           strategyBean.setLike(false);
                       }

                   }
                   int slNum=likesService.getCountNum(stId);
                   int scNum=collectService.getCountNum(stId);
                   strategyBean.setLikeNum(slNum);
                   strategyBean.setCollectNum(scNum);
                   String cityName=cityService.getCityNameById(Integer.parseInt(strategy.getCitys()));
                   strategyBean.setCity(cityName);
                   String typeName=typeService.getNameById(strategy.getTypes());
                   strategyBean.setTravelType(typeName);
                   resList.add(strategyBean);
               }

           }
            PageInfo<StrategyBean> resultPageInfo=new PageInfo<>(resList);
            resultPageInfo.setPageSize(pageSize);
            resultPageInfo.setPageNum(currentPage);
            resultPageInfo.setTotal(total);

            return new BaseMessage<>(0,resultPageInfo,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getStrategyById",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<StrategyBean> getStrategyById(@RequestParam("strategyId") int strategyId , @RequestParam("uId") int currentUId ){
        System.out.println("进来到这里了");
        StrategyBean strategyBean =new StrategyBean();;//返回数据封装
        //获得攻略信息
      Strategy strategy= strategyService.getStrategyById(strategyId);
        StrategyLike sl=new StrategyLike();
        StrategyColl sc=new StrategyColl();
        if(strategy!=null){
                    int id=strategy.getUserId();
                    int stId=strategy.getStrategyId();
                    Users us=userService.qryById(id);
                    if(us!=null){
                        strategyBean.setUsers(us);
                    }
                    strategyBean.setStrategy(strategy);
            if( currentUId==0) {
                strategyBean.setLike(false);
                strategyBean.setCollect(false);
            }else{
                sc=collectService.qryByIds(stId,currentUId);
                if(sc!=null){
                    strategyBean.setCollect(true);
                }else {
                    strategyBean.setCollect(false);
                }
                sl=likesService.qryByIds(stId,currentUId);
                if(sl!=null){
                    strategyBean.setLike(true);
                }else{
                    strategyBean.setLike(false);
                }

            }
            int slNum=likesService.getCountNum(stId);
            int scNum=collectService.getCountNum(stId);
            strategyBean.setLikeNum(slNum);
            strategyBean.setCollectNum(scNum);
            String cityName=cityService.getCityNameById(Integer.parseInt(strategy.getCitys()));
            strategyBean.setCity(cityName);
            String typeName=typeService.getNameById(strategy.getTypes());
            strategyBean.setTravelType(typeName);
            return new BaseMessage<>(0, strategyBean,"获取成功！");
                }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getStrategyListByUserId",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<List<StrategyBean>> getStrategyListByUserId(@RequestParam("uId") int uId){
        System.out.println("进来到这里了");
        StrategyBean strategyBean =null;//返回数据封装
        List<StrategyBean> resList=new ArrayList<>();//返回结果集
        //获得攻略信息
        List<Strategy> ls= strategyService.getStrategyListByUserId(uId);

        if(ls.size()>0){
            StrategyLike sl=new StrategyLike();
            StrategyColl sc=new StrategyColl();
                //绑定攻略相关信息
                for(Strategy strategy:ls) {
                    strategyBean = new StrategyBean();
                    int id = strategy.getUserId();
                    int stId=strategy.getStrategyId();
                    Users us = userService.qryById(id);
                    if (us != null) {
                        strategyBean.setUsers(us);
                    }
                    strategyBean.setStrategy(strategy);
                    if( uId==0) {
                        strategyBean.setLike(false);
                        strategyBean.setCollect(false);
                    }else{
                        sc=collectService.qryByIds(stId,uId);
                        if(sc!=null){
                            strategyBean.setCollect(true);
                        }else {
                            strategyBean.setCollect(false);
                        }
                        sl=likesService.qryByIds(stId,uId);
                        if(sl!=null){
                            strategyBean.setLike(true);
                        }else{
                            strategyBean.setLike(false);
                        }

                    }
                    int slNum=likesService.getCountNum(stId);
                    int scNum=collectService.getCountNum(stId);
                    strategyBean.setLikeNum(slNum);
                    strategyBean.setCollectNum(scNum);
                    String cityName=cityService.getCityNameById(Integer.parseInt(strategy.getCitys()));
                    strategyBean.setCity(cityName);
                    String typeName=typeService.getNameById(strategy.getTypes());
                    strategyBean.setTravelType(typeName);
                    resList.add(strategyBean);
                }
            return new BaseMessage<>(0,resList,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getCitiesList",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<List<Cities>> getCitiesList(){
        List<Cities> ls= cityService.getCitiesList();
        if(ls.size()>0){
            return new BaseMessage<>(0,ls,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getCommentList",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<List<CommentBean>> getCommentList(@RequestParam("strategyId") int strategyId){

        //外层评论列表
        List<CommentBean> commentList=new ArrayList<>();


        //从攻略评论表获取数据
        List<StrategyComment> ls= strategyCommentService.getCommListByStrId(strategyId);
        if(ls!=null&&ls.size()>0){
            for(StrategyComment s:ls){
               //外层评论封装
                CommentBean comb=new CommentBean();
                Users us=userService.qryById(s.getUserId());
                //外层评论用户封装
                CommentUser commentUser=new CommentUser();
                //用于内层被评论用户
                TargetUser targetUser=new TargetUser();
                if(us!=null){
                    commentUser.setId(us.getUserId());
                    targetUser.setId(us.getUserId());
                    commentUser.setNickName(us.getNickName());
                    targetUser.setNickName(us.getNickName());
                    commentUser.setAvatar("http://localhost:8088/yunTravel_liyb"+us.getUsImage());
                    targetUser.setAvatar("http://localhost:8088/yunTravel_liyb"+us.getUsImage());
                    comb.setCommentUser(commentUser);
                }
                comb.setContent(s.getContent());
                comb.setCreateDate(s.getCreateDate());
                comb.setId(s.getId());
                //从子评论列表获取内层评论
                List<StrategyComment_child> list=strategyCommentService.getChildCommById(s.getId());
                if(list!=null&&list.size()>0){
                    //内层评论列表
                    List<CommentBean> childrenList=new ArrayList<>();
                    for(StrategyComment_child child:list){
                        //内层评论封装
                        CommentBean childComb=new CommentBean();
                        Users childUser=userService.qryById(child.getUserId());
                        //内层评论用户
                        CommentUser childCommentUser=new CommentUser();
                        if(childUser!=null){
                            childCommentUser.setId(childUser.getUserId());
                            childCommentUser.setNickName(childUser.getNickName());
                            childCommentUser.setAvatar("http://localhost:8088/yunTravel_liyb"+childUser.getUsImage());
                            childComb.setCommentUser(childCommentUser);
                        }
                        childComb.setContent(child.getContent());
                        childComb.setCreateDate(child.getCreateDate());
                        childComb.setTargetUser(targetUser);
                        childComb.setId(child.getId());
                        childrenList.add(childComb);
                }
                    comb.setChildrenList(childrenList);
            }
                commentList.add(comb);
        }
            return new BaseMessage<>(0,commentList,"获取成功！");
        }
        return new BaseMessage<>(1,commentList,"获取失败！");
    }

    @RequestMapping(value = "/getNoticeList",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<List<Notice>> getNoticeList(){
        List<Notice> ls= noticeService.getNoticeList();
        if(ls.size()>0){
            return new BaseMessage<>(0,ls,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getNewsList",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<List<News>> getNewsList(){
        List<News> ls= newsService.getNewsList();
        if(ls.size()>0){
            return new BaseMessage<>(0,ls,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getAllNotice",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<PageInfo<Notice>> getAllNotice(@RequestParam("pageSize") int pageSize , @RequestParam("currentPage") int currentPage){
        PageInfo<Notice> ls= noticeService.getAllNotice(pageSize,currentPage);
        if(ls.getSize()>0){
            return new BaseMessage<>(0,ls,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getAllNews",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<PageInfo<News>> getAllNews(@RequestParam("pageSize") int pageSize , @RequestParam("currentPage") int currentPage){
        PageInfo<News> ls= newsService.getAllNews(pageSize,currentPage);
        if(ls.getSize()>0){
            return new BaseMessage<>(0,ls,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }
    @RequestMapping(value = "/getNoticeById",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<Notice> getNoticeById(@RequestParam("noticeId") int noticeId){
        Notice notice= noticeService.getNoticeById(noticeId);
        if(notice!=null){
            return new BaseMessage<>(0,notice,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }

    @RequestMapping(value = "/getNewsById",method = RequestMethod.GET)
    public @ResponseBody
    BaseMessage<News> getNewsById(@RequestParam("newsId") int newsId){
       News news=newsService.getNewsById(newsId);
        if(news!=null){
            return new BaseMessage<>(0,news,"获取成功！");
        }
        return new BaseMessage<>(1,null,"获取失败！");
    }



}
