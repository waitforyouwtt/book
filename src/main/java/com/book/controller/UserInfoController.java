package com.book.controller;

import com.alibaba.fastjson.JSONObject;
import com.book.entity.UserInfo;
import com.book.jpaRepository.UserInfoMapper;
import com.book.service.UserInfoService;
import com.book.utils.JsonView;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 一点点
 * @Date: 2018/10/2 14:22
 * @Version 1.0
 */
@Controller
@RequestMapping("/mvc")
public class UserInfoController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserInfoMapper userInfoMapper ;

    @Autowired
    UserInfoService infoService;

    @Value("${static.resources.domain}")
    private String staticResourceDomain;

    @PostMapping("/userInfoList")
    @ApiOperation(value = "获取用户集合",notes = "根据url的参数获取信息")
    public List<UserInfo> userInfoList(){

        List<UserInfo> userInfos = userInfoMapper.findAll();

        return userInfos;
    }
   @RequestMapping(value = "/save",method = RequestMethod.POST,produces="application/json; utf-8")
    @ApiOperation(value = "添加用户信息",notes = "根据url的参数添加用户信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "userName",value = "用户实体",required = false,dataType = "UserInfo")
    )
    public String save(UserInfo userInfo,Model model){
        infoService.addUserInfo(userInfo);
        return "success";
    }

    @RequestMapping("/test")
    public  String test(Model model) {
        model.addAttribute("staticResourceDomain", staticResourceDomain);
       return "save";
    }


    @RequestMapping("/toExcel")
    public  String toExcel(Model model) {
        model.addAttribute("staticResourceDomain", staticResourceDomain);
        return "excel";
    }

    @RequestMapping("/importExcel")
    public  String importExcel(@RequestParam("myfile")MultipartFile myFile) {
        ModelAndView modelAndView = new ModelAndView();

        Integer nums = infoService.importExcel(myFile);
        modelAndView.addObject("msg","导入数成功");
        return "success";
    }



}
