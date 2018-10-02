package com.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Pattern;
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
public class UserInfo implements Serializable{
    private static final long serialVersionUID = 2820705730106743572L;

    private Integer id;

    private String userName;

    private String password;

    private String sex;

    private LocalDate birthday;

    private String address;

    private boolean deleteFlag;

    private LocalDate createTime;

    private LocalDate updateTime;

}
