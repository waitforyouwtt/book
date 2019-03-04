package com.book.controller;

import com.book.entity.CollegeStudentReport;
import com.book.entity.UserInfo;
import com.book.service.CollegeStudentService;
import com.book.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 一点点
 * @Date: 2019/3/4 18:35
 * @Version 1.0
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

    @ApiOperation(value = "获取大学生调查问卷列表")
    @GetMapping("/collegeStudentList")
    @ResponseBody
    public List<CollegeStudentReport> collegeStudentList(){
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
        CollegeStudentReport result = collegeStudentService.save(collegeStudentReport);
        Map<String,String> map = new HashMap<>();
        if(result != null){
            map.put("code","200");
            map.put("message","保存成功");
        }else{
            map.put("code","555");
            map.put("message","保存失败");
        }
        return map;
    }
}
