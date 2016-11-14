/*
Navicat MySQL Data Transfer

Source Server         : z2
Source Server Version : 50547
Source Host           : 192.168.154.158:3306
Source Database       : his

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2016-11-14 19:12:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fs_medical_card
-- ----------------------------
DROP TABLE IF EXISTS `fs_medical_card`;
CREATE TABLE `fs_medical_card` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(32) NOT NULL COMMENT '诊疗卡号',
  `value` float(6,2) DEFAULT NULL COMMENT '储值',
  `initDate` bigint(20) NOT NULL COMMENT '初始化日期',
  `operator` varchar(30) NOT NULL COMMENT '出卡人',
  `mhId` bigint(20) NOT NULL COMMENT '病历主键',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `createDate` bigint(20) NOT NULL COMMENT '创建时间',
  `lastModifier` varchar(32) DEFAULT NULL COMMENT '修改者',
  `lastModDate` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态，0：正常，1：审核',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='诊疗卡，可以有多卡（病人诊疗卡丢失补办卡号不相同，原卡状态审核）';

-- ----------------------------
-- Records of fs_medical_card
-- ----------------------------
INSERT INTO `fs_medical_card` VALUES ('1', 'f6c80274019c48f9906d6c220dc55896', null, '1479113312304', 'Nicos', '2', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479113312298', null, '1479113312304', '0');
INSERT INTO `fs_medical_card` VALUES ('2', '7569650e3a6d48a9924e2f91a0bba129', null, '1479114974410', 'Nicos', '3', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479114974397', null, '1479114974410', '0');
INSERT INTO `fs_medical_card` VALUES ('3', 'a5228372737f4cbeb2b702bfe1a864fc', null, '1479118264854', 'Nicos', '4', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479118264833', null, '1479118264854', '0');

-- ----------------------------
-- Table structure for fs_medical_history
-- ----------------------------
DROP TABLE IF EXISTS `fs_medical_history`;
CREATE TABLE `fs_medical_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` bit(1) NOT NULL COMMENT '性别',
  `age` tinyint(4) NOT NULL COMMENT '年龄',
  `career` varchar(20) DEFAULT NULL COMMENT '职业',
  `address` varchar(120) DEFAULT NULL COMMENT '住址',
  `isMarried` bit(1) DEFAULT b'0' COMMENT '婚姻，0：未婚，1：已婚',
  `dependability` tinyint(4) DEFAULT '0' COMMENT '可靠程度，0：仅供参考，1：基本可靠，2：完全可靠',
  `nativePlace` varchar(50) DEFAULT NULL COMMENT '籍贯',
  `linkman` varchar(20) NOT NULL COMMENT '联系人',
  `nation` varchar(20) DEFAULT NULL COMMENT '民族',
  `phone` varchar(16) NOT NULL COMMENT '联系电话',
  `medicalCard` varchar(32) NOT NULL COMMENT '诊疗卡',
  `detailId` bigint(20) DEFAULT NULL COMMENT '病历详情表主键',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `createDate` bigint(20) NOT NULL COMMENT '创建日期',
  `lastModifier` varchar(32) DEFAULT NULL COMMENT '修改者',
  `lastModDate` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态，0：正常，1：审核',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='病历表';

-- ----------------------------
-- Records of fs_medical_history
-- ----------------------------
INSERT INTO `fs_medical_history` VALUES ('3', '病人2', '', '32', '', '海角七号', '', '1', '广东省中山市', 'Papp', '汉族', '1351653454', '7569650e3a6d48a9924e2f91a0bba129', null, '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479114974397', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479119251331', '0');
INSERT INTO `fs_medical_history` VALUES ('4', '病人1', '\0', '21', 'IT狗', '格尔尼拉', '\0', '2', '广东省深圳市', 'papa', '维吾尔族', '13527101796', 'a5228372737f4cbeb2b702bfe1a864fc', null, '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479118264833', null, '1479118264814', '0');

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
INSERT INTO `fs_rescuer_info` VALUES ('2', '13500000011', '1ad1bcbf08ab1b4f1cdd19ec65f5549a', '麦格', '\0', '76', '超级管理员', '超级管理员', null, '88888888', '', '\0', '638F6CBFF9B9325EE1EE7E3C5765CB5B', 'simagle', 'ADMIN', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1476780556000', '1479008919334', '1');
INSERT INTO `fs_rescuer_info` VALUES ('5', '13500000012', 'e16c66b602e2403fecb11a659ff05b11', '胖麦', '\0', '76', '骨科医生', '德国骨科', null, '1654541231', '13500000012', '\0', 'ebdfd1144bb74328b624af5886013583', 'ebdfd114', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1476861133935', '1478765450616', '1');

-- ----------------------------
-- Table structure for fs_room_clinicroom
-- ----------------------------
DROP TABLE IF EXISTS `fs_room_clinicroom`;
CREATE TABLE `fs_room_clinicroom` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `address` varchar(100) NOT NULL COMMENT '科室位置，具体到哪一栋楼那一层那一间',
  `clinicNum` varchar(8) NOT NULL COMMENT '科室号，如: 3-101',
  `name` varchar(40) NOT NULL COMMENT '科室名称',
  `code` varchar(32) NOT NULL COMMENT '科室代码，uuid',
  `categoryId` int(4) NOT NULL COMMENT '科室分类标签',
  `description` varchar(32) DEFAULT NULL COMMENT '科室描述，科室用途',
  `createDate` bigint(20) NOT NULL COMMENT '创建时间',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `lastModDate` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `lastModifier` varchar(32) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态，0：启用，1：停用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='科室';

-- ----------------------------
-- Records of fs_room_clinicroom
-- ----------------------------
INSERT INTO `fs_room_clinicroom` VALUES ('2', '承德楼2座4层5厅1号诊室', '2405-1', '疼痛科1室', '46e4c7b2ca904d53ae65d0dd337407a2', '1', '承德楼2座4层5厅1号诊室', '1478934668683', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479108501076', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '0');

-- ----------------------------
-- Table structure for fs_room_scheduling
-- ----------------------------
DROP TABLE IF EXISTS `fs_room_scheduling`;
CREATE TABLE `fs_room_scheduling` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roomId` int(4) DEFAULT NULL COMMENT '科室主键',
  `rescuerId` bigint(20) NOT NULL COMMENT '医护人员主键',
  `timePoint` bigint(20) NOT NULL COMMENT '时间点，排班当天时间戳',
  `dayPoint` tinyint(2) NOT NULL COMMENT '代表一天的早上，下午和晚上，依次值为0,1,2',
  `day` tinyint(2) NOT NULL COMMENT '星期几，0表示星期1，以此类推',
  `week` tinyint(2) NOT NULL COMMENT '第几周',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `createDate` bigint(20) NOT NULL COMMENT '创建时间',
  `lastModifier` varchar(32) DEFAULT NULL COMMENT '修改人',
  `lastModDate` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态，0：正常，1：审核',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='医护人员排班';

-- ----------------------------
-- Records of fs_room_scheduling
-- ----------------------------
INSERT INTO `fs_room_scheduling` VALUES ('36', '2', '1', '1479094400702', '0', '0', '47', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479096959784', null, null, '0');
INSERT INTO `fs_room_scheduling` VALUES ('37', '2', '1', '1479267200702', '0', '2', '47', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479096959784', null, null, '0');
INSERT INTO `fs_room_scheduling` VALUES ('38', '2', '1', '1479612800702', '0', '6', '47', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479096959784', null, null, '0');
INSERT INTO `fs_room_scheduling` VALUES ('39', '2', '1', '1479094400702', '1', '0', '47', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479096959784', null, null, '0');
INSERT INTO `fs_room_scheduling` VALUES ('40', '2', '1', '1479180800702', '1', '1', '47', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479096959784', null, null, '0');
INSERT INTO `fs_room_scheduling` VALUES ('41', '2', '1', '1479267200702', '1', '2', '47', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479096959784', null, null, '0');
INSERT INTO `fs_room_scheduling` VALUES ('42', '2', '1', '1479353600702', '1', '3', '47', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479096959784', null, null, '0');
INSERT INTO `fs_room_scheduling` VALUES ('43', '2', '1', '1479526400702', '1', '5', '47', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479096959784', null, null, '0');
INSERT INTO `fs_room_scheduling` VALUES ('44', '2', '1', '1479094400702', '2', '0', '47', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479096959784', null, null, '0');
INSERT INTO `fs_room_scheduling` VALUES ('45', '2', '1', '1479267200702', '2', '2', '47', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479096959784', null, null, '0');
INSERT INTO `fs_room_scheduling` VALUES ('46', '2', '1', '1479440000702', '2', '4', '47', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479096959784', null, null, '0');

-- ----------------------------
-- Table structure for fs_sys_category
-- ----------------------------
DROP TABLE IF EXISTS `fs_sys_category`;
CREATE TABLE `fs_sys_category` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(50) NOT NULL COMMENT '标签名称',
  `type` tinyint(3) NOT NULL COMMENT '标签类型，0：专业标签，1：职务标签',
  `priority` int(4) DEFAULT NULL COMMENT '排序',
  `description` varchar(255) DEFAULT NULL COMMENT '标签描述',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `createDate` bigint(20) NOT NULL COMMENT '创建时间',
  `lastModifier` varchar(32) DEFAULT NULL COMMENT '修改人',
  `lastModDate` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态，0：正常，1：停用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='分类标签，用户职务标签，专业标签如科室标签，医生专业标签等';

-- ----------------------------
-- Records of fs_sys_category
-- ----------------------------
INSERT INTO `fs_sys_category` VALUES ('1', '疼痛科', '0', '1', '疼痛科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748240400', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('2', '内科', '0', '2', '内科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748506722', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('3', '外科', '0', '1', '外科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748521033', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('4', '儿科', '0', '1', '儿科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748534304', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('5', '妇科', '0', '1', '妇科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748544151', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('6', '眼科', '0', '1', '眼科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748570088', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('7', '耳鼻喉科', '0', '1', '耳鼻喉科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748582696', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('8', '口腔科', '0', '1', '口腔科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748592409', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('9', '皮肤科', '0', '1', '皮肤科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748603043', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478939810121', '1');
INSERT INTO `fs_sys_category` VALUES ('10', '中医科', '0', '2', '中医科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748611504', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('11', '针灸推拿科', '0', '3', '针灸推拿科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748624090', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('12', '心理咨询室', '0', '3', '心理咨询室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748633225', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('13', '呼吸内科', '0', '5', '呼吸内科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748644417', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('14', '消化内科', '0', '4', '消化内科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748654018', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('15', '泌尿内科', '0', '6', '泌尿内科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748662383', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('16', '心内科', '0', '7', '心内科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748671915', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('17', '血液科', '0', '9', '血液科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748680625', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('18', '内分泌科', '0', '5', '内分泌科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748691096', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('19', '神经内科', '0', '5', '神经内科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748700369', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('20', '小儿科', '0', '56', '小儿科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748710713', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('21', '感染科', '0', '43', '感染科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748719675', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('22', '普外科', '0', '43', '普外科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748728993', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('23', '骨科', '0', '1', '骨科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748739200', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('24', '神经外科', '0', '6', '神经外科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748748648', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('25', '肝胆外科', '0', '32', '肝胆外科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748758536', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('26', '泌尿外科', '0', '7', '泌尿外科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748766792', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('27', '烧伤科', '0', '5', '烧伤科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748776888', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('28', '妇产科', '0', '7', '妇产科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748796712', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('29', '血透室', '0', '43', '血透室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748806840', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('30', '重症监护室', '0', '1', '重症监护室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748815378', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('31', '生化室', '0', '1', '生化室，生化实验室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748838940', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1479114808813', '1');
INSERT INTO `fs_sys_category` VALUES ('32', '检验室', '0', '4', '检验室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748850017', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('33', '病理室', '0', '4', '病理室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748859201', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('34', '拍片室', '0', '6', '拍片室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748869080', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('35', 'CT室', '0', '3', 'CT室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748877839', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('36', '透视室', '0', '54', '透视室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748886536', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('37', '磁共振室', '0', '2', '磁共振室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748895608', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('38', 'ECT室', '0', '3', 'ECT室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748904337', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('39', '腹部B超室', '0', '3', '腹部B超室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748914544', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('40', '手术室', '0', '4', '手术室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748925458', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('41', '心脏B超室', '0', '4', '心脏B超室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748944723', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('42', '阴道B超室', '0', '7', '阴道B超室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748954425', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('43', '院长办公室', '1', '23', '院长办公室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748967151', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('44', '副院长办公室', '1', '7', '副院长办公室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748978384', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('45', '书记办公室', '1', '2', '书记办公室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478748989081', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('46', '医教科', '1', '3', '医教科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478749012199', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('47', '院办室', '0', '53', '院办室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478749022400', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('48', '宣传科', '0', '4', '宣传科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478749031136', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('49', '防保科', '0', '8', '防保科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478749039744', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('50', '财务科', '0', '32', '财务科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478749048370', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('51', '病案室', '0', '3', '病案室', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478749057641', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('52', '医保办', '1', '34', '医保办', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478749067489', null, null, '0');
INSERT INTO `fs_sys_category` VALUES ('53', '人事科', '1', '3', '人事科', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478749081195', null, null, '0');

-- ----------------------------
-- Table structure for fs_sys_relationrc
-- ----------------------------
DROP TABLE IF EXISTS `fs_sys_relationrc`;
CREATE TABLE `fs_sys_relationrc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `categoryId` int(4) NOT NULL COMMENT '分类标签id',
  `rescuerId` bigint(20) NOT NULL COMMENT '医护人员主键',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `createDate` bigint(20) NOT NULL COMMENT '创建时间',
  `lastModifier` varchar(32) DEFAULT NULL COMMENT '修改者',
  `lastModDate` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态，0：正常，1：停用（软删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='医疗人员标签关系（fs_sys_relationRC）';

-- ----------------------------
-- Records of fs_sys_relationrc
-- ----------------------------
INSERT INTO `fs_sys_relationrc` VALUES ('2', '1', '5', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478918161889', null, null, '0');
INSERT INTO `fs_sys_relationrc` VALUES ('3', '34', '5', '638F6CBFF9B9325EE1EE7E3C5765CB5B', '1478918161890', null, null, '0');
