package com.book.entity;
/**
 * @Author: 一点点
 * @Date: 2018/10/4 14:15
 * @Version 1.0
 */
public class Tbagent {
    private Integer job_number;

    private String department;

    private String region;

    private String username;

    private String idcard;

    private Integer company_rankings;

    private Integer department_rankings;

    private Integer region_rankings;

    private Long distance_first_company;

    private Long distance_first_department;

    private Long distance_first_region;

    private Integer participate;

    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getJob_number() {
        return job_number;
    }

    public void setJob_number(Integer job_number) {
        this.job_number = job_number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getCompany_rankings() {
        return company_rankings;
    }

    public void setCompany_rankings(Integer company_rankings) {
        this.company_rankings = company_rankings;
    }

    public Integer getDepartment_rankings() {
        return department_rankings;
    }

    public void setDepartment_rankings(Integer department_rankings) {
        this.department_rankings = department_rankings;
    }

    public Integer getRegion_rankings() {
        return region_rankings;
    }

    public void setRegion_rankings(Integer region_rankings) {
        this.region_rankings = region_rankings;
    }

    public Long getDistance_first_company() {
        return distance_first_company;
    }

    public void setDistance_first_company(Long distance_first_company) {
        this.distance_first_company = distance_first_company;
    }

    public Long getDistance_first_department() {
        return distance_first_department;
    }

    public void setDistance_first_department(Long distance_first_department) {
        this.distance_first_department = distance_first_department;
    }

    public Long getDistance_first_region() {
        return distance_first_region;
    }

    public void setDistance_first_region(Long distance_first_region) {
        this.distance_first_region = distance_first_region;
    }

    public Integer getParticipate() {
        return participate;
    }

    public void setParticipate(Integer participate) {
        this.participate = participate;
    }
}