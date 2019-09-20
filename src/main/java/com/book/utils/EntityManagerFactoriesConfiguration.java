package com.book.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;


/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/19 20:44
 * @Email: 15290810931@163.com
 */
@Configuration
public class EntityManagerFactoriesConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean emf() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan(
                new String[]{"com.book.entity"});
        emf.setJpaVendorAdapter(
                new HibernateJpaVendorAdapter());
        return emf;
    }
}
