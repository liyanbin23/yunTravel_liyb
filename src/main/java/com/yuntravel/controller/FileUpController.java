package com.yuntravel.controller;

import com.yuntravel.bean.BaseMessage;
import com.yuntravel.po.Banners;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/filesController")
public class FileUpController {

    @RequestMapping(value = "/upFiles")
    public @ResponseBody
    BaseMessage  upFiles(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) {

        //获取文件上传目录
        System.out.println("files"+files);
        String path =request.getServletContext().getRealPath("/WEB-INF/");
        path = path +File.separator + "static" + File.separator + "images"+File.separator+"uploadImg";
        System.out.println(path);
        System.out.println(files.length);
        if (files != null && files.length > 0) {
            //封装返回数据
            System.out.println("进来了");
            System.out.println("进来了"+request.getContextPath());
            String imgUrls[] = new String[files.length];
            for (int i = 0; i < files.length; i++) {
                //获取文件扩展名
                String extName = FilenameUtils.getExtension(files[i].getOriginalFilename());
                //生成新的文件名
                String fileName = UUID.randomUUID().toString() + FilenameUtils.EXTENSION_SEPARATOR + extName;
                //创建空文件对象
                File targetFile = new File(path, fileName);
                // 检测是否存在目录
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }
                //上传图片
                try {
                    files[i].transferTo(targetFile);
                    System.out.println("图片插入成功");
                } catch (Exception e) {
                    System.out.println("图片插入失败");
                    e.printStackTrace();
                }
                //拼装上传后的图片地址
                String url ="/static/images/uploadImg/" + fileName;
                //存储到字符串数组
                imgUrls[i] = url;
            }
//            map.put("error", 0);
//            map.put("data", imgUrls);
//            return JSONArray.toJSONString(map);
            return new BaseMessage(0,imgUrls,"成功");
        }
        return new BaseMessage(1,null,"失败");
    }

    @RequestMapping(value = "/upVideo")
    public @ResponseBody
    BaseMessage  upVideo(@RequestParam("video") MultipartFile file, HttpServletRequest request) {

        //获取文件上传目录
        System.out.println("files"+file);
        String path =request.getServletContext().getRealPath("/WEB-INF/");
        path = path +File.separator + "static" + File.separator + "video";
        System.out.println(path);

        if (file != null) {
            //封装返回数据
            System.out.println("进来了");
            System.out.println("进来了"+request.getContextPath());


                //获取文件扩展名
                String extName = FilenameUtils.getExtension(file.getOriginalFilename());
                //生成新的文件名
                String fileName = UUID.randomUUID().toString() + FilenameUtils.EXTENSION_SEPARATOR + extName;
                //创建空文件对象
                File targetFile = new File(path, fileName);
                // 检测是否存在目录
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }
                //上传图片
                try {
                    file.transferTo(targetFile);
                    System.out.println("图片插入成功");
                } catch (Exception e) {
                    System.out.println("图片插入失败");
                    e.printStackTrace();
                }
                //拼装上传后的图片地址
                String url ="/static/video/" + fileName;
                //存储到字符串数组
               String videoUrl = url;

//            map.put("error", 0);
//            map.put("data", imgUrls);
//            return JSONArray.toJSONString(map);
            return new BaseMessage(0,videoUrl,"成功");
        }
        return new BaseMessage(0,null,"失败");
    }
}
