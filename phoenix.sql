/*
 Navicat Premium Data Transfer

 Source Server         : 0.LOCALHOST
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 127.0.0.1:3306
 Source Schema         : phoenix

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 14/08/2020 18:01:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_node
-- ----------------------------
DROP TABLE IF EXISTS `admin_node`;
CREATE TABLE `admin_node`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `parent_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父节点id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '节点名称',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '节点code',
  `status` tinyint(0) NOT NULL DEFAULT 1 COMMENT '1-显示,0-不显示',
  `operator_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '操作人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最近更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_node_code`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '推送后台节点表';

-- ----------------------------
-- Records of admin_node
-- ----------------------------
BEGIN;
INSERT INTO `admin_node` VALUES (1, 0, '系统设置', 'system', 1, 0, '2019-09-02 02:35:47', '2020-05-09 03:31:43'), (2, 1, '平台管理', 'system|platform', 1, 0, '2019-09-04 05:48:03', '2020-05-09 03:31:43'), (3, 1, '权限管理', 'system|power', 1, 0, '2019-09-04 05:49:32', '2020-05-09 03:31:43'), (4, 2, '平台管理展示', 'system|platformDisplay', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43'), (5, 2, '启用禁用平台', 'system|platformStatus', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43'), (6, 2, '查看详情', 'system|platformDetail', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43'), (7, 1, '基本信息', 'system|userinfo', 1, 0, '2019-09-06 03:44:53', '2020-05-09 03:31:43'), (8, 1, '消息设置', 'system|message', 1, 0, '2019-09-07 03:43:31', '2020-05-09 03:31:43'), (9, 0, '消息任务', 'message', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43'), (10, 9, '消息列表（营销型）', 'message|marketing', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43'), (11, 9, '消息列表（功能型）', 'message|base', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43'), (12, 10, '首页展示', 'system|marketingDisplay', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43'), (13, 10, '操作消息', 'system|marketingOperate', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43'), (14, 10, '新建消息', 'system|marketingCreate', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43'), (15, 11, '首页展示', 'system|baseDisplay', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43'), (16, 11, '操作消息', 'system|baseOperate', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43'), (17, 11, '新建消息', 'system|baseCreate', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43'), (18, 0, '数据报表', 'report', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43'), (19, 18, '数据报表', 'report|dataReport', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43'), (20, 18, '静默push数据', 'report|silentPushDataReport', 1, 0, '2019-09-04 07:10:10', '2020-05-09 03:31:43'), (23, 18, '优惠券报表', 'report|couponReport', 1, 0, '2020-01-08 03:23:57', '2020-05-09 03:31:43');
COMMIT;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户名称',
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '真实姓名',
  `admin` tinyint(0) NOT NULL DEFAULT 0 COMMENT '管理员',
  `app_platform_list` json NOT NULL COMMENT 'vova/airyclub',
  `message_type_list` json NOT NULL COMMENT 'push/coupon',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '用户状态0-启用1-禁用',
  `operator_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '操作人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最近更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_name`(`name`) USING BTREE,
  UNIQUE INDEX `uni_email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理员用户表,推送后台使用';

-- ----------------------------
-- Records of admin_user
-- ----------------------------
BEGIN;
INSERT INTO `admin_user` VALUES (1, 'model', 'model', 1, '[\"vova\", \"airyclub\"]', '[\"push\", \"coupon\"]', 'model@vova.com.hk', '$2a$10$zayb2P24XPQBf3FWjIdFxetyaT7v52Mbj2Nkbhy9.OT00Km5GYyY6', 1, 1, '2019-09-02 02:06:36', '2020-08-06 09:12:09'), (2, 'test1', 'model', 0, '[\"vova\"]', '[\"push\"]', 'test1@vova.com.hk', '$2a$10$zayb2P24XPQBf3FWjIdFxetyaT7v52Mbj2Nkbhy9.OT00Km5GYyY6', 1, 1, '2019-09-02 02:06:36', '2020-08-06 09:12:12');
COMMIT;

-- ----------------------------
-- Table structure for admin_user_node
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_node`;
CREATE TABLE `admin_user_node`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'user_id',
  `node_id_list` json NOT NULL COMMENT '节点id',
  `status` tinyint(0) NOT NULL DEFAULT 1 COMMENT '状态',
  `operator_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '操作人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最近更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '推送后台用户权限表';

-- ----------------------------
-- Records of admin_user_node
-- ----------------------------
BEGIN;
INSERT INTO `admin_user_node` VALUES (1, 1, '[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 23]', 1, 1, '2019-09-09 05:55:29', '2020-05-12 08:35:05');
COMMIT;

-- ----------------------------
-- Table structure for auth_resource
-- ----------------------------
DROP TABLE IF EXISTS `auth_resource`;
CREATE TABLE `auth_resource`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `code` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'code',
  `type` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '类型',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '状态',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色';

-- ----------------------------
-- Records of auth_resource
-- ----------------------------
BEGIN;
INSERT INTO `auth_resource` VALUES (1, 'Vova', 'vova', 'platform', 0, 0, '2020-08-14 09:30:43', '2020-08-14 09:30:49'), (2, 'Airyclub', 'airyclub', 'platform', 0, 0, '2020-08-14 09:31:16', '2020-08-14 09:31:38'), (3, '推送', 'push', 'message', 0, 0, '2020-08-14 09:32:57', '2020-08-14 09:32:57'), (4, '邮件', 'email', 'message', 0, 0, '2020-08-14 09:33:20', '2020-08-14 09:33:20'), (5, '优惠券', 'coupon', 'message', 0, 0, '2020-08-14 09:33:39', '2020-08-14 09:33:39');
COMMIT;

-- ----------------------------
-- Table structure for auth_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` int(0) NOT NULL DEFAULT 0 COMMENT '父节点id',
  `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `code` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'code',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '接口path',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '状态',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色';

-- ----------------------------
-- Records of auth_role
-- ----------------------------
BEGIN;
INSERT INTO `auth_role` VALUES (1, 0, '系统设置', 'system', '', 0, 0, '2019-09-02 02:35:47', '2020-08-13 09:21:07'), (2, 1, '平台管理', 'system|platform', '', 0, 0, '2019-09-04 05:48:03', '2020-08-13 09:21:10'), (3, 1, '权限管理', 'system|power', '', 0, 0, '2019-09-04 05:49:32', '2019-09-17 03:42:47'), (4, 1, '基本信息', 'system|userinfo', '', 0, 0, '2019-09-06 03:44:53', '2020-08-12 08:59:28'), (5, 1, '消息设置', 'system|message', '', 0, 0, '2019-09-07 03:43:31', '2020-08-12 08:59:31'), (6, 0, '消息任务', 'message', '', 0, 0, '2019-09-04 07:10:10', '2020-08-12 08:59:40'), (7, 6, '消息列表（营销型）', 'message|marketing', '', 0, 0, '2019-09-04 07:10:10', '2020-08-12 08:59:53'), (8, 6, '消息列表（功能型）', 'message|base', '', 0, 0, '2019-09-04 07:10:10', '2020-08-12 08:59:57'), (9, 0, '数据报表', 'report', '', 0, 0, '2019-09-04 07:10:10', '2020-08-12 09:00:02'), (10, 9, '数据报表', 'report|dataReport', '', 0, 0, '2019-09-04 07:10:10', '2020-08-12 09:00:14'), (11, 9, '静默push数据', 'report|silentPushDataReport', '', 0, 0, '2019-09-04 07:10:10', '2020-08-12 09:00:27'), (12, 9, '优惠券报表', 'report|couponReport', '', 0, 0, '2020-01-08 03:23:57', '2020-08-12 09:00:30'), (13, 0, '查询验证工具', 'validation', '', 0, 0, '2020-02-10 08:26:35', '2020-08-12 09:00:36'), (14, 13, '测试工具', 'validation|push', '', 0, 0, '2020-02-10 08:27:13', '2020-08-12 09:00:51'), (15, 13, '用户信息查询', 'validation|tags', '', 0, 0, '2020-02-10 08:27:23', '2020-08-12 09:01:04');
COMMIT;

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '真实姓名',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '状态',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最近更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_name`(`username`) USING BTREE,
  UNIQUE INDEX `uni_email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户';

-- ----------------------------
-- Records of auth_user
-- ----------------------------
BEGIN;
INSERT INTO `auth_user` VALUES (1, 'model', '$2a$10$zayb2P24XPQBf3FWjIdFxetyaT7v52Mbj2Nkbhy9.OT00Km5GYyY6', 'model', 'model@vova.com.hk', 0, 0, '2019-09-02 02:06:36', '2020-08-12 09:12:48'), (2, 'test1', '$2a$10$zayb2P24XPQBf3FWjIdFxetyaT7v52Mbj2Nkbhy9.OT00Km5GYyY6', 'model', 'test1@vova.com.hk', 0, 0, '2019-09-02 02:06:36', '2020-08-12 09:12:52');
COMMIT;

-- ----------------------------
-- Table structure for auth_user_resource
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_resource`;
CREATE TABLE `auth_user_resource`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'user_id',
  `resource_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'role_id',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '状态',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色关系表';

-- ----------------------------
-- Records of auth_user_resource
-- ----------------------------
BEGIN;
INSERT INTO `auth_user_resource` VALUES (1, 1, 1, 0, 0, '2020-08-14 09:34:52', '2020-08-14 09:34:52'), (2, 1, 2, 0, 0, '2020-08-14 09:34:52', '2020-08-14 09:34:52'), (3, 1, 3, 0, 0, '2020-08-14 09:34:52', '2020-08-14 09:34:52'), (4, 1, 4, 0, 0, '2020-08-14 09:34:52', '2020-08-14 09:34:52'), (5, 1, 5, 0, 0, '2020-08-14 09:34:52', '2020-08-14 09:34:52'), (6, 2, 1, 0, 0, '2020-08-14 09:34:52', '2020-08-14 09:34:52'), (7, 2, 3, 0, 0, '2020-08-14 09:34:52', '2020-08-14 09:34:52');
COMMIT;

-- ----------------------------
-- Table structure for auth_user_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'user_id',
  `role_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'role_id',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '状态',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色关系表';

-- ----------------------------
-- Records of auth_user_role
-- ----------------------------
BEGIN;
INSERT INTO `auth_user_role` VALUES (1, 1, 1, 0, 0, '2020-08-12 09:17:56', '2020-08-14 09:13:38'), (2, 1, 2, 0, 0, '2020-08-12 09:18:57', '2020-08-14 09:09:26'), (3, 1, 3, 0, 0, '2020-08-12 09:18:57', '2020-08-12 09:18:57'), (4, 1, 4, 0, 0, '2020-08-12 09:18:57', '2020-08-12 09:18:57'), (5, 1, 5, 0, 0, '2020-08-12 09:18:57', '2020-08-12 09:18:57'), (6, 1, 6, 0, 0, '2020-08-12 09:18:57', '2020-08-12 09:18:57'), (7, 1, 7, 0, 0, '2020-08-12 09:18:57', '2020-08-12 09:18:57'), (8, 1, 8, 0, 0, '2020-08-12 09:18:57', '2020-08-12 09:18:57'), (9, 1, 9, 0, 0, '2020-08-12 09:18:57', '2020-08-12 09:18:57'), (10, 1, 10, 0, 0, '2020-08-12 09:18:57', '2020-08-12 09:18:57'), (11, 1, 11, 0, 0, '2020-08-12 09:18:57', '2020-08-12 09:18:57'), (12, 1, 12, 0, 0, '2020-08-12 09:18:57', '2020-08-12 09:18:57'), (13, 1, 13, 0, 0, '2020-08-12 09:18:57', '2020-08-12 09:18:57'), (14, 1, 14, 0, 0, '2020-08-12 09:18:57', '2020-08-12 09:18:57'), (15, 1, 15, 0, 0, '2020-08-12 09:18:57', '2020-08-12 09:18:57');
COMMIT;

-- ----------------------------
-- Table structure for push_admin_node
-- ----------------------------
DROP TABLE IF EXISTS `push_admin_node`;
CREATE TABLE `push_admin_node`  (
  `node_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `parent_id` int(0) NOT NULL DEFAULT 0 COMMENT '父节点id',
  `node_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '节点名称',
  `node_code` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '节点code',
  `not_show` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否不展示:0-展示1-不展示',
  `operator_id` int(0) NOT NULL DEFAULT 0 COMMENT '操作人',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最近更新时间',
  PRIMARY KEY (`node_id`) USING BTREE,
  UNIQUE INDEX `idx_node_code`(`node_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '推送后台节点表';

-- ----------------------------
-- Records of push_admin_node
-- ----------------------------
BEGIN;
INSERT INTO `push_admin_node` VALUES (1, 0, '系统设置', 'system', 0, 0, '2019-09-02 02:35:47', '2019-09-04 05:46:31'), (2, 1, '平台管理', 'system|platform', 0, 0, '2019-09-04 05:48:03', '2019-09-04 05:48:03'), (3, 1, '权限管理', 'system|power', 0, 0, '2019-09-04 05:49:32', '2019-09-17 03:42:47'), (4, 1, '基本信息', 'system|userinfo', 0, 0, '2019-09-06 03:44:53', '2020-08-12 08:59:28'), (5, 1, '消息设置', 'system|message', 0, 0, '2019-09-07 03:43:31', '2020-08-12 08:59:31'), (6, 0, '消息任务', 'message', 0, 0, '2019-09-04 07:10:10', '2020-08-12 08:59:40'), (7, 6, '消息列表（营销型）', 'message|marketing', 0, 0, '2019-09-04 07:10:10', '2020-08-12 08:59:53'), (8, 6, '消息列表（功能型）', 'message|base', 0, 0, '2019-09-04 07:10:10', '2020-08-12 08:59:57'), (9, 0, '数据报表', 'report', 0, 0, '2019-09-04 07:10:10', '2020-08-12 09:00:02'), (10, 9, '数据报表', 'report|dataReport', 0, 0, '2019-09-04 07:10:10', '2020-08-12 09:00:14'), (11, 9, '静默push数据', 'report|silentPushDataReport', 0, 0, '2019-09-04 07:10:10', '2020-08-12 09:00:27'), (12, 9, '优惠券报表', 'report|couponReport', 0, 0, '2020-01-08 03:23:57', '2020-08-12 09:00:30'), (13, 0, '查询验证工具', 'validation', 0, 0, '2020-02-10 08:26:35', '2020-08-12 09:00:36'), (14, 13, '测试工具', 'validation|push', 0, 0, '2020-02-10 08:27:13', '2020-08-12 09:00:51'), (15, 13, '用户信息查询', 'validation|tags', 0, 0, '2020-02-10 08:27:23', '2020-08-12 09:01:04');
COMMIT;

-- ----------------------------
-- Table structure for task_config
-- ----------------------------
DROP TABLE IF EXISTS `task_config`;
CREATE TABLE `task_config`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `app_platform` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'vova' COMMENT 'vova/airyclub',
  `message_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '推送消息标题CODE',
  `message_body` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '推送消息体CODE',
  `target_tag` json NOT NULL COMMENT '推送标签',
  `countries` json NOT NULL COMMENT '推送地区',
  `target_link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '跳转链接',
  `image_link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '图片链接',
  `task_type` tinyint(0) NOT NULL DEFAULT 0 COMMENT '任务类型：1-功能型 2-营销型',
  `priority` int(0) NOT NULL DEFAULT 0 COMMENT '优先级',
  `remarks` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `periods` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '执行周期',
  `expected_time` timestamp(0) NOT NULL DEFAULT '1970-01-01 00:00:01' COMMENT '期望执行时间',
  `last_time` timestamp(0) NOT NULL DEFAULT '2020-01-01 00:00:00' COMMENT '上次执行时间',
  `start_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '有效期起始',
  `end_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '有效期结束',
  `extra` json NOT NULL COMMENT '其他属性',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '配置状态',
  `operator_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '操作人',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最近更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '推送任务配置表';

-- ----------------------------
-- Records of task_config
-- ----------------------------
BEGIN;
INSERT INTO `task_config` VALUES (1, 'vova', '1112244', '1', '{\"filter\": 0, \"baseTag\": 1, \"levelTags\": [4, 5], \"genderTags\": [2, 3]}', '[\"CN\", \"US\"]', '1', '1', 0, 0, '1', 1, '1970-01-01 00:00:01', '2020-01-01 00:00:00', '2020-05-15 09:50:22', '2020-05-15 09:50:22', '{\"iosMax\": \"2.73.0\", \"iosMin\": \"2.69.0\", \"tagSource\": \"self\", \"androidMax\": \"2.73.0\", \"androidMin\": \"2.69.0\", \"couponConfigId\": 1}', 1, 0, '2020-05-15 09:50:22', '2020-08-05 03:47:32');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
