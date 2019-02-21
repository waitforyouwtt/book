package com.book.controller;

import com.book.aop.CheckToken;
import com.book.entity.UserInfo;
import com.book.jpaRepository.UserInfoMapper;
import com.book.service.UserInfoService;
import com.book.utils.ConstantUtils;
import com.book.utils.RedisToken;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: 一点点
 * @Date: 2018/10/2 14:22
 * @Version 1.0
 */
@Controller
@RequestMapping("/mvc")
public class IndexController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${static.resources.domain}")
    private String staticResourceDomain;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/layer")
    public String layer(){
        return "layer";
    }



}
