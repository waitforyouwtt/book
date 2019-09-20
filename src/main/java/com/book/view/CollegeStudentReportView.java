package com.book.view;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/19 18:01
 * @Email: 15290810931@163.com
 */
@Data
public class CollegeStudentReportView implements Serializable {

    private Integer id;

    private String userId;

    private String userName;

    private String gender;
    private String genderName;

    private String address ;

    private String phone;

    private String proposal;

    private String leisureActivities;

    private String workResource;
    private List<String> workResourceName;

    private List<String> labourType;

    private String careerDirection;

    private String payType;

    private String payFrequency;
    private List<String> payFrequencyName;

    private String servicePopulation;

    private List<String> servicePopulationName;

    private String serviceCusGender;

    private LocalDate createTime;

    private LocalDate updateTime;
}
