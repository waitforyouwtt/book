package com.book.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: 一点点
 * @Date: 2019/5/3 10:22
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = "com.book.dao.slaver", sqlSessionTemplateRef  = "slaverSqlSessionTemplate")
public class SlaverDataSourceConfiguration {

    @Value("${spring.datasource.slaver.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.master.url}")
    private String url;
    @Value("${spring.datasource.slaver.username}")
    private String username;
    @Value("${spring.datasource.slaver.password}")
    private String password;

    @Bean(name = "slaverDataSource")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(this.driverClassName);
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        return dataSource;
    }
    @Bean(name = "slaverSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("slaverDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/slaver/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "slaverTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("slaverDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "slaverSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("slaverSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
