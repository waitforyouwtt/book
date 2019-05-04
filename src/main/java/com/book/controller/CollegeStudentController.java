package com.book.controller;

import com.book.entity.CollegeStudentReport;
import com.book.entity.UserInfo;
import com.book.service.CollegeStudentService;
import com.book.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 一点点
 * @Date: 2019/3/4 18:35
 * @Version 1.0
 * 大学生调研resource
 */
@Controller
@Slf4j
public class CollegeStudentController {

    @Autowired
    CollegeStudentService collegeStudentService;

    @Autowired
    UserInfoService userInfoService;
    @GetMapping("/findcollegeStudentList")
    public ModelAndView findcollegeStudentList(){
        ModelAndView modelAndView = new ModelAndView("college-student-list");
        return modelAndView;
    }

    @GetMapping("/sendEmail")
    public ModelAndView sendEmail(){
        ModelAndView mv = new ModelAndView( "sendEmail" );
        return mv;
    }

    @GetMapping("/Rotate")
    public ModelAndView Rotate(){
        ModelAndView mv = new ModelAndView( "360Rotate" );
        return mv;
    }

    @ApiOperation(value = "获取大学生调查问卷列表")
    @GetMapping("/collegeStudentList")
    @ResponseBody
    public List<CollegeStudentReport> collegeStudentList(HttpSession session){
        CollegeStudentReport collegeStudentReport = new CollegeStudentReport();
        List<CollegeStudentReport> collegeStudentReports = collegeStudentService.findCollegeStudentList(collegeStudentReport);
        return collegeStudentReports;
    }

    @GetMapping("/collegeStudentAdd")
    public String collegeStudentAdd(){
      return "college-student-add";
    }

    @RequestMapping("/collegeStudentSave")
    @ResponseBody
    public Map<String,String> collegeStudentSave(CollegeStudentReport collegeStudentReport){
        CollegeStudentReport college = collegeStudentService.save(collegeStudentReport);
        Map<String,String> result = new HashMap<>();
        if(college != null){
            result.put("code","200");
            result.put("message","保存成功");
        }else{
            result.put("code","555");
            result.put("message","保存失败");
        }
        return result;
    }

   @GetMapping("/queryAll")
    public String query(){
        List<UserInfo> fd = userInfoService.findAll();
      return "fd";
    }

}
