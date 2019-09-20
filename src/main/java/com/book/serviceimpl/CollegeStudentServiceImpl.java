package com.book.serviceimpl;

import com.book.dao.slaver.CollegeStudentSlaverDao;
import com.book.entity.CollegeStudentReport;
import com.book.enums.GenderEnum;
import com.book.jpaRepository.CollegeStudentReportMapper;
import com.book.service.CollegeStudentService;

import com.book.tools.StringOperation;
import com.book.view.CollegeStudentReportView;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;

/**
 * @Author: 一点点
 * @Date: 2019/3/4 19:42
 * @Version 1.0
 */
@Service
public class CollegeStudentServiceImpl implements CollegeStudentService {

    @Autowired
    CollegeStudentSlaverDao collegeStudentSlaverDao;
    @Autowired
    CollegeStudentReportMapper collegeStudentReportMapper;
    @Override
    public List<CollegeStudentReportView> findCollegeStudentList(CollegeStudentReport collegeStudentReport) {
        List<CollegeStudentReport> collegeStudentReports = collegeStudentSlaverDao.findCollegeStudentList(collegeStudentReport);
        if (CollectionUtils.isEmpty(collegeStudentReports)) {
            return null;
        }
        List<CollegeStudentReportView> reportViewList = Lists.newArrayList();
        collegeStudentReports.forEach(o -> {
            CollegeStudentReportView view = new CollegeStudentReportView();
            BeanCopier beanCopier = BeanCopier.create(CollegeStudentReport.class,CollegeStudentReportView.class,false);
            beanCopier.copy(o,view,null);
            view.setGenderName(GenderEnum.fromValue(o.getGender()).getName());
            /*view.setLabourTypeName(GenderEnum.fromValue(o.getLabourType()).getName());*/
            reportViewList.add(view);
        });
        return reportViewList;
    }

    @Override
    @Transactional(value = "transactionManager")
    public CollegeStudentReport save(CollegeStudentReport collegeStudentReport){
        collegeStudentReport.setUserId(String.valueOf( StringOperation.generateSixNumber()));
        collegeStudentReport.setCreateTime( LocalDate.now());
        collegeStudentReport.setUpdateTime(LocalDate.now());
        CollegeStudentReport result = collegeStudentReportMapper.save(collegeStudentReport);
        return result;
    }
}
