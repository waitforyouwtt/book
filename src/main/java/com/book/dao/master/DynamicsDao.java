package com.book.dao.master;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: 一点点
 * @Date: 2019/5/18 0:03
 * @Version 1.0
 */
public interface DynamicsDao {

    List<Map<String, Object>> selectByParam(@Param("tableName")String tableName,@Param( "columnName" ) String columnName ,@Param( "columnParams" ) String columnParams);

    List<Map<String, Object>> selectByParams(@Param("tableName")String tableName, @Param("startDate") Date startDate, @Param("endDate")Date endDate);
}
