package com.book.service;

import com.book.entity.CollegeStudentReport;

import java.util.List;

/**
 * @Author: 一点点
 * @Date: 2019/3/4 19:41
 * @Version 1.0
 */
public interface CollegeStudentService {

    List<CollegeStudentReport> findCollegeStudentList(CollegeStudentReport collegeStudentReport);

    CollegeStudentReport save(CollegeStudentReport collegeStudentReport);
}
