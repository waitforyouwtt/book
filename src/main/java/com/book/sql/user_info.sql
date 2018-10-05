/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-10-05 13:23:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 DEFAULT '',
  `sex` varchar(255) CHARACTER SET utf8 DEFAULT '',
  `address` varchar(255) CHARACTER SET utf8 DEFAULT '',
  `birthday` timestamp NULL DEFAULT current_timestamp(),
  `delete_flag` bit(1) NOT NULL DEFAULT b'1',
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_nd4xxe4sfscx08oods9gi8y2v` (`user_name`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '范雅轩', '', '', '', '2018-10-02 16:19:47', '', '2018-10-02 16:19:47', '2018-10-02 16:19:47');
INSERT INTO `user_info` VALUES ('2', '吴通通', '', '', '', '2018-10-02 16:19:54', '', '2018-10-02 16:19:54', '2018-10-02 16:19:54');
INSERT INTO `user_info` VALUES ('3', '张洁', null, null, '江苏淮安', null, '\0', null, null);
INSERT INTO `user_info` VALUES ('4', '张杰', null, null, '河南沈丘', null, '\0', null, null);
INSERT INTO `user_info` VALUES ('5', '余清清', '', '', null, '2018-10-02 20:38:08', '', '2018-10-02 20:38:08', '2018-10-02 20:38:08');
INSERT INTO `user_info` VALUES ('6', '伊羽', '', '', null, '2018-10-02 20:41:08', '', '2018-10-02 20:41:08', '2018-10-02 20:41:08');
