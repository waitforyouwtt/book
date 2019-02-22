package com.book.entity;

import lombok.*;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @Author: 一点点
 * @Date: 2018/10/2 13:23
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Builder
@Table(name = "user_info")
@org.hibernate.annotations.Table(appliesTo = "user_info",comment="用户信息表")
public class UserInfo implements Serializable{
    private static final long serialVersionUID = 2820705730106743572L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "user_Id",columnDefinition="varchar(255) COMMENT '用户Id'")
    private String userId;

    @Pattern(regexp = "^[\u4E00-\u9FA5]+$",message = "用户名格式错误")
    @Basic
    @Column(name = "user_name",columnDefinition="varchar(50) COMMENT '用户名'")
    private String userName;

    @Pattern(regexp = "^[a-z0-9A-Z_-]{3,15}$",message = "昵称格式错误")
    @Basic
    @Column(name = "nick_name",columnDefinition="varchar(50) COMMENT '昵称'")
    private String nickName;

    @Basic
    @Size(min =8,max = 100,message = "密码长度为8-100之间")
    @Column(name = "password",columnDefinition="varchar(100) COMMENT '用户密码'")
    private String password;

    @Basic
    @Column(name = "gender",columnDefinition="varchar(2) COMMENT '性别'")
    private String gender;

    @DateTimeFormat(pattern  ="yyyy-MM-dd")
    @Column(name = "birthday",columnDefinition="DATETIME COMMENT '生日'")
    private LocalDate birthday;

    @Basic
    @Size(min=1,max=20,message = "内容应该在5-20之间")
    @Column(name = "address",columnDefinition="varchar(100) COMMENT '住址'")
    private String address;

    @Basic
    @Column(name = "delete_flag",columnDefinition="varchar(4) COMMENT '删除标志'")
    private String deleteFlag;

    @Column(name = "create_time",columnDefinition="DATETIME COMMENT '创建时间'",insertable=true, updatable=false)
    private LocalDate createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time",columnDefinition="DATETIME COMMENT '修改时间'")
    private LocalDate updateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "login_time",columnDefinition="DATETIME COMMENT '登陆时间'")
    private LocalDate loginTime;

}
