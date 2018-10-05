/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-10-05 13:22:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agent
-- ----------------------------
DROP TABLE IF EXISTS `agent`;
CREATE TABLE `agent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_number` int(11) DEFAULT NULL,
  `department` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `region` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `idcard` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `company_rankings` int(11) DEFAULT NULL,
  `department_rankings` int(11) DEFAULT NULL,
  `region_rankings` int(11) DEFAULT NULL,
  `distance_first_company` decimal(10,0) DEFAULT NULL,
  `distance_first_department` decimal(10,0) DEFAULT NULL,
  `distance_first_region` decimal(10,0) DEFAULT NULL,
  `participate` int(11) DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=latin1;
