/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80000
Source Host           : localhost:3306
Source Database       : draw

Target Server Type    : MYSQL
Target Server Version : 80000
File Encoding         : 65001

Date: 2020-07-25 01:25:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for intention
-- ----------------------------
DROP TABLE IF EXISTS `intention`;
CREATE TABLE `intention` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `ipad` int(11) DEFAULT NULL,
  `kettle` int(11) DEFAULT NULL,
  `mobileSource` int(11) DEFAULT NULL,
  `divGifts` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of intention
-- ----------------------------
INSERT INTO `intention` VALUES ('1', '1', '1', '0', '0', '1', 'q');
INSERT INTO `intention` VALUES ('2', '2', '0', '1', '1', '1', 'cabo');
INSERT INTO `intention` VALUES ('3', '8', '1', '0', '1', '0', 'a');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `upid` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '1', '123', '广东省茂名市电白区');
INSERT INTO `order` VALUES ('2', '2', '123', '广东省茂名市电白区');
INSERT INTO `order` VALUES ('3', '4', '123', '广东省茂名市电白区');
INSERT INTO `order` VALUES ('4', '4', '123', '广东省茂名市电白区');
INSERT INTO `order` VALUES ('5', '4', '123', '广东省茂名市电白区');
INSERT INTO `order` VALUES ('6', '4', '123', '广东省茂名市电白区');
INSERT INTO `order` VALUES ('7', '3', '123', '广东省茂名市电白区');
INSERT INTO `order` VALUES ('8', '5', '123', '广东省茂名市电白区');
INSERT INTO `order` VALUES ('9', '8', '123', '广东省茂名市电白区');
INSERT INTO `order` VALUES ('10', '11', '123', '广东省茂名市电白区');
INSERT INTO `order` VALUES ('11', '12', '123', '广东省茂名市电白区');

-- ----------------------------
-- Table structure for prize
-- ----------------------------
DROP TABLE IF EXISTS `prize`;
CREATE TABLE `prize` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `num` int(11) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prize
-- ----------------------------
INSERT INTO `prize` VALUES ('1', '微信红包8.8', '18', '微信红包');
INSERT INTO `prize` VALUES ('2', '微信红包1.88', '89', '微信红包');
INSERT INTO `prize` VALUES ('3', '谢谢惠顾', '99990', '谢谢惠顾');
INSERT INTO `prize` VALUES ('4', 'Air pots 3', '1', '实物');
INSERT INTO `prize` VALUES ('5', '谢谢惠顾', '100000', '谢谢惠顾');
INSERT INTO `prize` VALUES ('6', '微信红包18.8', '4', '微信红包');
INSERT INTO `prize` VALUES ('7', '谢谢惠顾', '100000', '谢谢惠顾');
INSERT INTO `prize` VALUES ('8', '公仔', '16', '实物');
INSERT INTO `prize` VALUES ('9', '微信红包88.8', '20', '微信红包');

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rule
-- ----------------------------
INSERT INTO `rule` VALUES ('1', 'KTV网点/酒吧网点，消费者一次购买24瓶喜力瓶装330ML啤酒即可获得扫码一次。');
INSERT INTO `rule` VALUES ('2', '中餐网点，消费者一次购买12瓶喜力瓶装330ML啤酒即可获得扫码一次。');
INSERT INTO `rule` VALUES ('3', '消费者满足条件即可扫码抽奖机会。');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'lhc', '159', '男', '广东省', '茂名市', '电白区');
INSERT INTO `user` VALUES ('2', 'aa', '111', '男', '', '', '');
INSERT INTO `user` VALUES ('7', 'aq', 'qa', '女', '广东省', '茂名市', '电白区');
INSERT INTO `user` VALUES ('8', 'aaaa', 'as', '男', '', '', '');

-- ----------------------------
-- Table structure for user_prize
-- ----------------------------
DROP TABLE IF EXISTS `user_prize`;
CREATE TABLE `user_prize` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL,
  `nowStatus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_prize
-- ----------------------------
INSERT INTO `user_prize` VALUES ('1', '1', '2', '2020-07-24 21:12:38.000000', '已领取');
INSERT INTO `user_prize` VALUES ('2', '1', '2', '2020-07-24 21:44:01.000000', '点击领取');
INSERT INTO `user_prize` VALUES ('3', '7', '2', '2020-07-24 22:17:54.000000', '已领取');
INSERT INTO `user_prize` VALUES ('4', '7', '6', '2020-07-24 22:17:56.000000', '已领取');
INSERT INTO `user_prize` VALUES ('5', '1', '8', '2020-07-24 22:56:16.000000', '已领取');
INSERT INTO `user_prize` VALUES ('6', '1', '2', '2020-07-24 23:11:10.000000', '点击领取');
INSERT INTO `user_prize` VALUES ('7', '1', '6', '2020-07-24 23:11:13.000000', '已领取');
INSERT INTO `user_prize` VALUES ('8', '1', '8', '2020-07-24 23:11:24.000000', '已领取');
INSERT INTO `user_prize` VALUES ('9', '8', '2', '2020-07-25 00:43:57.000000', '已领取');
INSERT INTO `user_prize` VALUES ('10', '8', '2', '2020-07-25 01:04:12.000000', '已领取');
INSERT INTO `user_prize` VALUES ('11', '8', '8', '2020-07-25 01:05:00.000000', '已领取');
INSERT INTO `user_prize` VALUES ('12', '8', '8', '2020-07-25 01:06:40.000000', '已领取');
INSERT INTO `user_prize` VALUES ('13', '8', '2', '2020-07-25 01:07:55.000000', '已领取');
INSERT INTO `user_prize` VALUES ('14', '8', '1', '2020-07-25 01:07:56.000000', '点击领取');
INSERT INTO `user_prize` VALUES ('15', '8', '6', '2020-07-25 01:07:58.000000', '点击领取');
