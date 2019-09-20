package com.book.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/19 17:23
 * @Email: 15290810931@163.com
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Builder
@Table(name = "menu")
@org.hibernate.annotations.Table(appliesTo = "menu",comment="菜单信息表")
public class Menu implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String menuTitle;

    private String menuName;

    private String menuUrl;


}
