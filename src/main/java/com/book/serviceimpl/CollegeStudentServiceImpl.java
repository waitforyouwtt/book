package com.book.serviceimpl;

import com.book.entity.CollegeStudentReport;
import com.book.service.CollegeStudentService;

import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @Author: 一点点
 * @Date: 2019/3/4 19:42
 * @Version 1.0
 */
@Service
public class CollegeStudentServiceImpl implements CollegeStudentService {

   /* @Autowired
    CollegeStudentDao collegeStudentDao;
    @Autowired
    CollegeStudentReportMapper collegeStudentReportMapper;*/
    @Override
    public List<CollegeStudentReport> findCollegeStudentList(CollegeStudentReport collegeStudentReport) {
       /* List<CollegeStudentReport> collegeStudentReports =  collegeStudentDao.findCollegeStudentList(collegeStudentReport);
        return collegeStudentReports;*/
       return null;
    }

    @Override
    public CollegeStudentReport save(CollegeStudentReport collegeStudentReport){
       /* collegeStudentReport.setUserId(String.valueOf(StringOperation.generateSixNumber()));
        collegeStudentReport.setCreateTime(LocalDate.now());
        collegeStudentReport.setUpdateTime(LocalDate.now());
        CollegeStudentReport result = collegeStudentReportMapper.save(collegeStudentReport);
        return result;*/
       return null;
    }
}
