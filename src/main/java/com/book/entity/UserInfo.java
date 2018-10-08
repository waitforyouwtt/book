package com.book.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class UserInfo implements Serializable{
    private static final long serialVersionUID = 2820705730106743572L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^[\u4E00-\u9FA5]+$",message = "用户名格式错误")
    private String userName;
    @Size(min =8,max = 20,message = "密码长度为8-20之间")
    private String password;
    @ColumnDefault(value = "男")
    private String sex;
    @DateTimeFormat(pattern  ="yyyy-MM-dd")
    private LocalDate birthday;
    @Size(min=1,max=20,message = "内容应该在5-20之间")
    private String address;
    @ColumnDefault(value = "true")
    private boolean deleteFlag;
    @ApiModelProperty(value = "创建时间")
    private LocalDate createTime;
    @ApiModelProperty(value = "修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate updateTime;
    @Pattern(regexp = "^[a-z0-9A-Z_-]{3,15}$",message = "昵称格式错误")
    private String nickName;
}
