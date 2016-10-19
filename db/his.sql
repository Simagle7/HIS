/*
Navicat MySQL Data Transfer

Source Server         : z2
Source Server Version : 50547
Source Host           : 192.168.154.150:3306
Source Database       : his

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2016-10-19 15:32:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fs_doctor_info
-- ----------------------------
DROP TABLE IF EXISTS `fs_doctor_info`;
CREATE TABLE `fs_doctor_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(30) NOT NULL COMMENT '姓名',
  `sex` bit(1) DEFAULT NULL COMMENT '性别，0：男，1：女',
  `age` tinyint(3) DEFAULT NULL COMMENT '年龄',
  `position` varchar(20) DEFAULT NULL COMMENT '职务',
  `major` varchar(100) DEFAULT NULL COMMENT '主治',
  `seniority` int(4) DEFAULT NULL COMMENT '工龄',
  `jobNumber` varchar(12) NOT NULL COMMENT '工号',
  `phone` varchar(16) DEFAULT NULL COMMENT '联系电话',
  `code` varchar(32) NOT NULL COMMENT '医生代码',
  `creator` varchar(32) DEFAULT NULL COMMENT '创建者',
  `lastModifier` varchar(32) DEFAULT NULL COMMENT '修改者',
  `createDate` bigint(20) NOT NULL COMMENT '创建时间',
  `lastModDate` bigint(20) NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态，0：正常，1：停职',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='医生基础信息表';

-- ----------------------------
-- Records of fs_doctor_info
-- ----------------------------
INSERT INTO `fs_doctor_info` VALUES ('1', '麦格', '\0', '20', '儿童科医生', '儿童感冒', '1', '123456789', '13527101797', '519e2bc942a24c6085b820ac430995bc', 'ADMIN', null, '1476758959148', '1476758959137', '0');
INSERT INTO `fs_doctor_info` VALUES ('2', '东岳熊猫', '\0', '22', '熊猫科', '接生熊猫', '2', '46541358', '545626565', '9a686bfacbd54537aa48c1682b21b638', 'ADMIN', null, '1476759812372', '1476759812362', '0');
INSERT INTO `fs_doctor_info` VALUES ('6', '群宝', '\0', '22', '富婆', '就是有钱', '1', '563834512374', '4138471834', '4f29eb4529f8447a87eb898d230371d8', 'ADMIN', null, '1476760131530', '1476760131529', '0');
INSERT INTO `fs_doctor_info` VALUES ('7', '胖麦', '\0', '127', '骨科', '德国骨科', '2', '5235245', '4646546845', '24c2df609b8247ebb3a0919dbeb1f84c', 'ADMIN', null, '1476760233828', '1476760233827', '0');
INSERT INTO `fs_doctor_info` VALUES ('8', '岳雄', '\0', '45', '骨科主任', '德国骨科主任', '5', '4364364365', '4454365485', 'c1d2ed4ec9f343c198b3cc179d0f6baf', 'ADMIN', null, '1476761112504', '1476761112497', '0');

-- ----------------------------
-- Table structure for fs_rescuer_info
-- ----------------------------
DROP TABLE IF EXISTS `fs_rescuer_info`;
CREATE TABLE `fs_rescuer_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(32) NOT NULL COMMENT '账号',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `name` varchar(30) NOT NULL COMMENT '姓名',
  `sex` bit(1) DEFAULT NULL COMMENT '性别，0：男，1：女',
  `age` tinyint(3) DEFAULT NULL COMMENT '年龄',
  `position` varchar(20) DEFAULT NULL COMMENT '职务',
  `major` varchar(100) DEFAULT NULL COMMENT '专长',
  `seniority` int(4) DEFAULT NULL COMMENT '工龄',
  `jobNumber` varchar(12) NOT NULL COMMENT '工号',
  `phone` varchar(16) DEFAULT NULL COMMENT '联系电话',
  `category` bit(1) NOT NULL COMMENT '类别，0：医生，1：护士',
  `code` varchar(32) NOT NULL COMMENT '代码',
  `salty` varchar(8) DEFAULT NULL COMMENT '加密盐，用于权限管理',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `lastModifier` varchar(32) DEFAULT NULL COMMENT '修改者',
  `createDate` bigint(20) NOT NULL COMMENT '创建时间',
  `lastModDate` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态，0：正常，1：停职',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='医疗人员基础信息表';

-- ----------------------------
-- Records of fs_rescuer_info
-- ----------------------------
INSERT INTO `fs_rescuer_info` VALUES ('1', '13500000010', '1ad1bcbf08ab1b4f1cdd19ec65f5549a', 'Nicos', '\0', '76', '超级管理员', null, null, '88888888', null, '\0', '638F6CBFF9B9325EE1EE7E3C5765CB5B', 'simagle', 'ADMIN', null, '1476780020000', null, '0');
INSERT INTO `fs_rescuer_info` VALUES ('2', '13500000011', '1ad1bcbf08ab1b4f1cdd19ec65f5549a', '麦格', '\0', '76', '超级管理员', null, null, '88888888', null, '\0', '638F6CBFF9B9325EE1EE7E3C5765CB5B', 'simagle', 'ADMIN', null, '1476780556000', null, '0');
INSERT INTO `fs_rescuer_info` VALUES ('5', '13500000012', 'e16c66b602e2403fecb11a659ff05b11', '胖麦', '\0', '76', '骨科医生', '德国骨科', null, '1654541231', '13500000012', '\0', 'ebdfd1144bb74328b624af5886013583', 'ebdfd114', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1476861133935', '1476861983585', '1');
