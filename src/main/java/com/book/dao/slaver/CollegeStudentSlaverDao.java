package com.book.dao.slaver;

import com.book.entity.CollegeStudentReport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 一点点
 * @Date: 2019/3/4 19:43
 * @Version 1.0
 */
public interface CollegeStudentSlaverDao {
    /**
     * 根据条件查询大学生调研报告
     * @param collegeStudentReport
     * @return
     */
    List<CollegeStudentReport> findCollegeStudentList(CollegeStudentReport collegeStudentReport);
}
