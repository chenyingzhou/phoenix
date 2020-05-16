/*
 Navicat Premium Data Transfer

 Source Server         : 0.LOCALHOST
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 127.0.0.1:3306
 Source Schema         : phoenix

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 09/05/2020 18:25:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_node
-- ----------------------------
DROP TABLE IF EXISTS `admin_node`;
CREATE TABLE `admin_node` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `parent_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '父节点id',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '节点名称',
  `code` varchar(255) NOT NULL DEFAULT '' COMMENT '节点code',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1-显示,0-不显示',
  `operator_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '操作人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_node_code` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COMMENT='推送后台节点表';

-- ----------------------------
-- Records of admin_node
-- ----------------------------
BEGIN;
INSERT INTO `admin_node` VALUES (1, 0, '系统设置', 'system', 1, 0, '2019-09-02 02:35:47', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (2, 1, '平台管理', 'system|platform', 1, 0, '2019-09-04 05:48:03', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (3, 1, '权限管理', 'system|power', 1, 0, '2019-09-04 05:49:32', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (4, 2, '平台管理展示', 'system|platformDisplay', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (5, 2, '启用禁用平台', 'system|platformStatus', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (6, 2, '查看详情', 'system|platformDetail', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (7, 1, '基本信息', 'system|userinfo', 1, 0, '2019-09-06 03:44:53', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (8, 1, '消息设置', 'system|message', 1, 0, '2019-09-07 03:43:31', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (9, 0, '消息任务', 'message', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (10, 9, '消息列表（营销型）', 'message|marketing', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (11, 9, '消息列表（功能型）', 'message|base', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (12, 10, '首页展示', 'system|marketingDisplay', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (13, 10, '操作消息', 'system|marketingOperate', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (14, 10, '新建消息', 'system|marketingCreate', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (15, 11, '首页展示', 'system|baseDisplay', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (16, 11, '操作消息', 'system|baseOperate', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (17, 11, '新建消息', 'system|baseCreate', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (18, 0, '数据报表', 'report', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (19, 18, '数据报表', 'report|dataReport', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (20, 18, '静默push数据', 'report|silentPushDataReport', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43');
INSERT INTO `admin_node` VALUES (23, 18, '优惠券报表', 'report|couponReport', 1, 0, '2020-01-08 03:23:57', '2020-05-09 03:31:43');
COMMIT;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '用户角色类型:0-管理员1-普通用户',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名称',
  `real_name` varchar(255) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `admin` tinyint(4) NOT NULL DEFAULT '0' COMMENT '管理员',
  `app_platform` varchar(255) NOT NULL DEFAULT 'vova' COMMENT 'vova/airyclub',
  `email` varchar(255) NOT NULL DEFAULT '' COMMENT '邮箱',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户状态0-启用1-禁用',
  `operator_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '操作人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uni_name` (`name`) USING BTREE,
  UNIQUE KEY `uni_email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='管理员用户表,推送后台使用';

-- ----------------------------
-- Records of admin_user
-- ----------------------------
BEGIN;
INSERT INTO `admin_user` VALUES (1, 1, 'test', 'test', 1, 'airyclub&vova', 'test@vova.com.hk', '098f6bcd4621d373cade4e832627b4f6', 1, 1, '2019-09-02 02:06:36', '2020-05-09 03:10:38');
INSERT INTO `admin_user` VALUES (2, 0, 'test1', 'test', 0, 'vova', 'test1@vova.com.hk', '098f6bcd4621d373cade4e832627b4f6', 1, 1, '2019-09-02 02:06:36', '2020-05-09 03:10:41');
COMMIT;

-- ----------------------------
-- Table structure for admin_user_node
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_node`;
CREATE TABLE `admin_user_node` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'user_id',
  `node_ids` json NOT NULL COMMENT '节点id',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态',
  `operator_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '操作人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='推送后台用户权限表';

-- ----------------------------
-- Records of admin_user_node
-- ----------------------------
BEGIN;
INSERT INTO `admin_user_node` VALUES (1, 1, '[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 23]', 1, 1, '2019-09-09 05:55:29', '2020-05-02 02:44:29');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;