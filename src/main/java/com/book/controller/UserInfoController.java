package com.book.controller;

import com.book.entity.UserInfo;
import com.book.jpaRepository.UserInfoMapper;
import com.book.service.UserInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 一点点
 * @Date: 2018/10/2 14:22
 * @Version 1.0
 */
@Controller
public class UserInfoController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserInfoMapper userInfoMapper ;

    @Autowired
    UserInfoService infoService;

    @PostMapping("/userInfoList")
    @ApiOperation(value = "获取用户集合",notes = "根据url的参数获取信息")
    public List<UserInfo> userInfoList(){

        List<UserInfo> userInfos = userInfoMapper.findAll();

        return userInfos;
    }
    @PostMapping("/save")
    @ApiOperation(value = "添加用户信息",notes = "根据url的参数添加用户信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "userName",value = "用户实体",required = false,dataType = "UserInfo")
    )
    public void save(@RequestBody UserInfo userInfo){
        infoService.addUserInfo(userInfo);
    }

    @PostMapping("/test")
    public  void test() {
        UserInfo info= new UserInfo();
        info.setUserName("a");
        info.setBirthday(LocalDate.now());
        info.setDeleteFlag(true);
        info.setAddress("河南沈丘");

        UserInfo info1 = new UserInfo();
        info1.setUserName("b");
        info1.setBirthday(LocalDate.now());
        info1.setDeleteFlag(true);
        info1.setAddress("江苏淮安");

        List<UserInfo> list = new ArrayList<>();
        list.add(info);
        list.add(info1);

        infoService.batchInsert(list);

    }
}
