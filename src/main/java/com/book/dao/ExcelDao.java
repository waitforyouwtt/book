package com.book.dao;

import com.book.entity.Tbagent;

import java.util.List;

/**
 * @Author: 一点点
 * @Date: 2018/10/4 14:15
 * @Version 1.0
 */
public interface ExcelDao {
    /**
     * 批量导入数据
     * @param tbagentList
     */
    void batchInsert(List<Tbagent> tbagentList);
}
