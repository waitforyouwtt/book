package com.book.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @Author: 一点点
 * @Date: 2019/3/4 17:56
 * @Version 1.0
 * 大学生调查问卷
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Builder
@Table(name = "college_student_report")
@org.hibernate.annotations.Table(appliesTo = "college_student_report",comment="大学生调查问卷信息表")
public class CollegeStudentReport  implements Serializable{
    private static final long serialVersionUID = -7375295676952608744L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "user_Id",columnDefinition="varchar(255) COMMENT '用户Id'")
    private String userId;

    @Basic
    @Column(name = "user_name",columnDefinition="varchar(50) COMMENT '用户名'")
    private String userName;
    @Basic
    @Column(name = "gender",columnDefinition="varchar(10) COMMENT '性别'")
    private String gender;
    @Basic
    @Column(name = "address",columnDefinition="varchar(50) COMMENT '用户地址'")
    private String address ;
    @Basic
    @Column(name = "phone",columnDefinition="varchar(12) COMMENT '手机号'")
    private String phone;
    @Basic
    @Column(name = "proposal",columnDefinition="varchar(100) COMMENT '用户提议'")
    private String proposal;

    @Basic
    @Column(name = "leisure_activities",columnDefinition="varchar(10) COMMENT '业余活动'")
    private String leisureActivities;
    @Basic
    @Column(name = "work_resource",columnDefinition="varchar(10) COMMENT '兼职途径'")
    private String workResource;
    @Basic
    @Column(name = "labour_type",columnDefinition="varchar(10) COMMENT '兼职类型：01 体力，02 脑力'")
    private String labourType;
    @Basic
    @Column(name = "career_direction",columnDefinition="varchar(100) COMMENT '职业方向'")
    private String careerDirection;
    @Basic
    @Column(name = "pay_type",columnDefinition="varchar(10) COMMENT '费用结算方式：01 收入费用，02 固定薪酬，03无所谓'")
    private String payType;
    @Basic
    @Column(name = "pay_frequency",columnDefinition="varchar(10) COMMENT '费用结算频率：01 周清，02 月清，03无所谓'")
    private String payFrequency;
    @Basic
    @Column(name = "service_population",columnDefinition="varchar(10) COMMENT '服务人群：01 小学生，02 中学生，03高中生，04外国人，05无所谓'")
    private String servicePopulation;
    @Basic
    @Column(name = "service_cus_gender",columnDefinition="varchar(10) COMMENT '乐意服务人群性别：01 男，02 女，03，无所谓'")
    private String serviceCusGender;

    @Column(name = "create_time",columnDefinition="DATETIME COMMENT '创建时间'",insertable=true, updatable=false)
    private LocalDate createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time",columnDefinition="DATETIME COMMENT '修改时间'")
    private LocalDate updateTime;



}
