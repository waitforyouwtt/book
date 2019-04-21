package com.book.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 一点点
 * @Date: 2019/4/18 11:43
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class LegionUserDataDTO extends BaseRowModel {
    /**
     * 渠道来源
     */
    @ExcelProperty(value = "渠道来源", index = 0)
    private String branch;

    /**
     * 进入小程序次数
     */
    @ExcelProperty(value = "用户昵称", index = 1)
    private String nickName;

    /**
     * 授权手机号数量
     */
    @ExcelProperty(value = "授权手机号", index = 2)
    private String phoneNumber;

}