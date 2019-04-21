package com.book.controller;

import com.book.aop.CheckToken;
import com.book.entity.UserInfo;
import com.book.jpaRepository.UserInfoMapper;
import com.book.service.OtherService;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    OtherService infoService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    private RedisToken redisToken;

    @Value("${static.resources.domain}")
    private String staticResourceDomain;

    @RequestMapping(value = "/userInfoList",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户集合",notes = "根据url的参数获取信息")
    public String userInfoList(Model model){
        List<UserInfo> userInfos = userInfoMapper.findAll();
        model.addAttribute("userInfos",userInfos);
        return "userInfoList";
    }
   @RequestMapping(value = "/save",method = RequestMethod.POST,produces="application/json; utf-8")
    @ApiOperation(value = "添加用户信息",notes = "根据url的参数添加用户信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "userName",value = "用户实体",required = false,dataType = "UserInfo")
    )
   @CheckToken(type = ConstantUtils.EXTAPIHEAD)
    public String save(UserInfo userInfo,Model model){
       // infoService.addUserInfo(userInfo);
       //userInfoMapper.save(userInfo);
       return "success";
    }
     @ApiOperation(value = "前往注册页面")
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public  String test(Model model) {
        model.addAttribute("staticResourceDomain", staticResourceDomain);
        model.addAttribute("token",redisToken.getToken());
       return "add";
    }


    @GetMapping("/layer")
    @RequestMapping(value="valid-login",method=RequestMethod.GET)
    @ResponseBody
    public Map<String,String> validImage(HttpServletRequest request, HttpSession session, UserInfo userInfo){
        Map<String,String> result = new HashMap<>(16);
        //UserInfo userInfo1
        return result;
    }

    @ApiOperation(value = "前往注册页面")
    @RequestMapping(value = "/to-register",method = RequestMethod.GET)
    public  String toRegister(Model model) {
        model.addAttribute("staticResourceDomain", staticResourceDomain);
        model.addAttribute("token",redisToken.getToken());
        return "sendEmail";
    }

    @RequestMapping(value = "/register-with-email")
    @ResponseBody
    public Map<String,String> registerWithEmail(UserInfo userInfo,Model model){
       Map<String,String> result = new HashMap<>( 16 );
       UserInfo user = userInfoService.addUserInfo(userInfo);
       if (user.getUserId() != null){
           result.put("rCode","200");
           result.put("message","成功");
       }else{
           result.put("rCode","1001");
           result.put("message","失败");
       }
        return result;
    }





}
