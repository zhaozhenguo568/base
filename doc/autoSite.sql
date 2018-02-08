/*
 Navicat Premium Data Transfer

 Source Server         : ubuntu
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : 192.168.30.13:3306
 Source Schema         : autoSite

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 08/12/2017 17:23:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_baseinfo
-- ----------------------------
DROP TABLE IF EXISTS `sys_baseinfo`;
CREATE TABLE `sys_baseinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `model_id` int(11) DEFAULT NULL COMMENT '用户模板ID',
  `title` varchar(50) DEFAULT NULL COMMENT '网站名称',
  `logo_pic` varchar(200) DEFAULT NULL COMMENT 'LOGO图片路径',
  `contact_phone` varchar(500) DEFAULT NULL COMMENT '联系方式（如有多个 , 隔开）',
  `email` varchar(50) DEFAULT NULL COMMENT '联系邮箱',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `qrcode` varchar(200) DEFAULT NULL COMMENT '二维码',
  `longitude` varchar(30) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(30) DEFAULT NULL COMMENT '纬度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='网站基础信息表';

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` int(11) NOT NULL,
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` int(11) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

-- ----------------------------
-- Table structure for sys_content
-- ----------------------------
DROP TABLE IF EXISTS `sys_content`;
CREATE TABLE `sys_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model_id` int(11) DEFAULT NULL COMMENT '模板ID',
  `module_id` int(11) DEFAULT NULL COMMENT '模块ID',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级ID',
  `content` text COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='模块页面信息表';

-- ----------------------------
-- Table structure for sys_content_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_content_info`;
CREATE TABLE `sys_content_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `model_id` int(11) DEFAULT NULL COMMENT '模板ID',
  `module_id` int(11) DEFAULT NULL COMMENT '模块ID',
  `type_id` int(11) DEFAULT NULL COMMENT '分类ID',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `subtitle` varchar(50) DEFAULT NULL COMMENT '副标题',
  `synopsis` varchar(200) DEFAULT NULL COMMENT '摘要',
  `main_pic` varchar(200) DEFAULT NULL COMMENT '图片路径',
  `issue_date` varchar(20) DEFAULT NULL COMMENT '发布日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='栏目内容信息表';

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Table structure for sys_model
-- ----------------------------
DROP TABLE IF EXISTS `sys_model`;
CREATE TABLE `sys_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type_id` varchar(200) DEFAULT NULL COMMENT '分类ID集合（,隔开）',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `model_no` varchar(20) DEFAULT NULL COMMENT '模板编号',
  `model_desc` varchar(200) DEFAULT NULL COMMENT '模板描述',
  `origin_price` decimal(16,2) DEFAULT NULL COMMENT '原价',
  `curr_price` decimal(16,2) DEFAULT NULL COMMENT '现价',
  `main_pic` varchar(200) DEFAULT NULL COMMENT '主图',
  `is_show` char(1) DEFAULT NULL COMMENT '是否显示（0 下架 1 上架）',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记（0 已删除 1 正常）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='模板信息表';

-- ----------------------------
-- Table structure for sys_model_carousel
-- ----------------------------
DROP TABLE IF EXISTS `sys_model_carousel`;
CREATE TABLE `sys_model_carousel` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `model_id` int(11) DEFAULT NULL COMMENT '模板ID',
  `pc_pic` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `m_pic` varchar(200) DEFAULT NULL COMMENT '手机图片地址',
  `target` int(11) DEFAULT NULL COMMENT '目标栏目ID',
  `sort` int(11) DEFAULT NULL COMMENT '排序值',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='模板轮播图';

-- ----------------------------
-- Table structure for sys_model_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_model_module`;
CREATE TABLE `sys_model_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `model_id` int(11) DEFAULT NULL COMMENT '模板ID',
  `title` varchar(20) DEFAULT NULL COMMENT '模块名称',
  `subtitle` varchar(20) DEFAULT NULL COMMENT '副标题',
  `type` varchar(2) DEFAULT NULL COMMENT '模块类型（1 系统栏目 2 列表展示 3 单页）',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级ID',
  `m_pic` varchar(255) DEFAULT NULL COMMENT '栏目主图（手机）',
  `pc_pic` varchar(200) DEFAULT NULL COMMENT '栏目主图',
  `sort` int(11) DEFAULT NULL COMMENT '排序值',
  `is_class` char(1) DEFAULT NULL COMMENT '是否分类（ 0 否 1 是）',
  `is_show` char(1) DEFAULT NULL COMMENT '是否在菜单中显示（0 否 1 是）',
  `index_show` char(1) DEFAULT NULL COMMENT '是否首页展示（0否 1 是）',
  `open_type` char(1) DEFAULT NULL COMMENT '打开方式（1 当前页 2 新标签页）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='模板模块信息表';

-- ----------------------------
-- Table structure for sys_model_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_model_type`;
CREATE TABLE `sys_model_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `type_name` varchar(20) DEFAULT NULL COMMENT '分类名称',
  `type_desc` varchar(200) DEFAULT NULL COMMENT '分类描述',
  `sort` int(11) DEFAULT NULL COMMENT '排序值',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for sys_module_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_module_type`;
CREATE TABLE `sys_module_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `um_id` int(11) DEFAULT NULL COMMENT '模板ID',
  `module_id` int(11) DEFAULT NULL COMMENT '栏目ID',
  `title` varchar(10) DEFAULT NULL COMMENT '分类名称',
  `sort` int(11) NOT NULL COMMENT '排序值',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件上传';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Table structure for sys_sequence
-- ----------------------------
DROP TABLE IF EXISTS `sys_sequence`;
CREATE TABLE `sys_sequence` (
  `name` varchar(50) NOT NULL,
  `current_value` int(11) NOT NULL,
  `_increment` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_singlepage
-- ----------------------------
DROP TABLE IF EXISTS `sys_singlepage`;
CREATE TABLE `sys_singlepage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `model_id` int(11) DEFAULT NULL COMMENT '模板ID',
  `module_id` int(11) DEFAULT NULL COMMENT '栏目ID',
  `content` text COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='单页信息表';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Table structure for tb_baseinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_baseinfo`;
CREATE TABLE `tb_baseinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `um_id` int(11) DEFAULT NULL COMMENT '用户模板ID',
  `title` varchar(50) DEFAULT NULL COMMENT '网站名称',
  `logo_pic` varchar(200) DEFAULT NULL COMMENT 'LOGO图片路径',
  `contact_phone` varchar(500) DEFAULT NULL COMMENT '联系方式（如有多个 , 隔开）',
  `email` varchar(50) DEFAULT NULL COMMENT '联系邮箱',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `qrcode` varchar(200) DEFAULT NULL COMMENT '二维码',
  `longitude` varchar(30) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(30) DEFAULT NULL COMMENT '纬度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='网站基础信息表';

-- ----------------------------
-- Table structure for tb_bind_domain
-- ----------------------------
DROP TABLE IF EXISTS `tb_bind_domain`;
CREATE TABLE `tb_bind_domain` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `um_id` int(11) DEFAULT NULL COMMENT '用户模板ID',
  `domain` varchar(50) DEFAULT NULL COMMENT '域名',
  `icp_num` varchar(30) DEFAULT NULL COMMENT 'ICP备案号',
  `police_num` varchar(30) DEFAULT NULL COMMENT '公安备案号',
  `check_status` char(1) DEFAULT NULL COMMENT '核查状态（1 提交未审核 2 审核通过 3 审核不通过）',
  `check_by` varchar(64) DEFAULT NULL COMMENT '核查人员',
  `check_time` datetime DEFAULT NULL COMMENT '核查时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户申请域名绑定记录表';

-- ----------------------------
-- Table structure for tb_captcha
-- ----------------------------
DROP TABLE IF EXISTS `tb_captcha`;
CREATE TABLE `tb_captcha` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `captcha` varchar(10) COLLATE utf8mb4_bin NOT NULL COMMENT '验证码',
  `create_time` datetime DEFAULT NULL COMMENT '生成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='图形验证码';

-- ----------------------------
-- Records of tb_captcha
-- ----------------------------
BEGIN;
INSERT INTO `tb_captcha` VALUES (19, 'd4efa', '2017-12-08 15:26:57');
COMMIT;

-- ----------------------------
-- Table structure for tb_content
-- ----------------------------
DROP TABLE IF EXISTS `tb_content`;
CREATE TABLE `tb_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `um_id` int(11) DEFAULT NULL COMMENT '模板ID',
  `module_id` int(11) DEFAULT NULL COMMENT '模块ID',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级ID',
  `content` text COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='模块页面信息表';

-- ----------------------------
-- Table structure for tb_content_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_content_info`;
CREATE TABLE `tb_content_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `um_id` int(11) DEFAULT NULL COMMENT '模板ID',
  `module_id` int(11) DEFAULT NULL COMMENT '模块ID',
  `type_id` int(11) DEFAULT NULL COMMENT '分类ID',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `subtitle` varchar(50) DEFAULT NULL COMMENT '副标题',
  `synopsis` varchar(200) DEFAULT NULL COMMENT '摘要',
  `main_pic` varchar(200) DEFAULT NULL COMMENT '图片路径',
  `issue_date` varchar(20) DEFAULT NULL COMMENT '发布日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='栏目内容信息表';

-- ----------------------------
-- Table structure for tb_model
-- ----------------------------
DROP TABLE IF EXISTS `tb_model`;
CREATE TABLE `tb_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `model_id` int(11) DEFAULT NULL COMMENT '模板ID',
  `title` varchar(50) DEFAULT NULL COMMENT '模板标题',
  `allot_domain` varchar(50) DEFAULT NULL COMMENT '自动分配的域名',
  `bind_domain` varchar(50) DEFAULT NULL COMMENT '用户绑定的域名',
  `icp_num` varchar(30) DEFAULT NULL COMMENT 'ICP备案号',
  `police_num` varchar(30) DEFAULT NULL COMMENT '公安备案号',
  `start_time` datetime DEFAULT NULL COMMENT '开通日期',
  `expire_time` datetime DEFAULT NULL COMMENT '到期日期',
  `status` int(11) DEFAULT NULL COMMENT '状态（0 正常 -1 已关闭 1 已过期）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='用户模板表';

-- ----------------------------
-- Records of tb_model
-- ----------------------------
BEGIN;
INSERT INTO `tb_model` VALUES (1, '1512712086320', 1, '模板1', 'www.lizheng.com', 'www.lizheng.cn', '11111', '111111', '2017-12-08 17:12:40', '2018-12-08 17:12:42', 0);
COMMIT;

-- ----------------------------
-- Table structure for tb_model_carousel
-- ----------------------------
DROP TABLE IF EXISTS `tb_model_carousel`;
CREATE TABLE `tb_model_carousel` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `um_id` int(11) DEFAULT NULL COMMENT '用户模板ID',
  `pc_pic` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `m_pic` varchar(200) DEFAULT NULL COMMENT '手机图片地址',
  `target` int(11) DEFAULT NULL COMMENT '目标栏目ID',
  `sort` int(11) DEFAULT NULL COMMENT '排序值',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='模板轮播图';

-- ----------------------------
-- Table structure for tb_model_module
-- ----------------------------
DROP TABLE IF EXISTS `tb_model_module`;
CREATE TABLE `tb_model_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `um_id` int(11) DEFAULT NULL COMMENT '用户模板ID',
  `title` varchar(20) DEFAULT NULL COMMENT '模块名称',
  `subtitle` varchar(20) DEFAULT NULL COMMENT '副标题',
  `type` varchar(2) DEFAULT NULL COMMENT '模块类型（1 系统栏目 2 列表展示 3 单页）',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级ID',
  `level` char(1) DEFAULT NULL COMMENT '级别 （1 一级栏目 2 二级栏目）',
  `m_pic` varchar(255) DEFAULT NULL COMMENT '栏目主图（手机）',
  `pc_pic` varchar(200) DEFAULT NULL COMMENT '栏目主图',
  `sort` int(11) DEFAULT NULL COMMENT '排序值',
  `is_class` char(1) DEFAULT NULL COMMENT '是否分类（ 0 否 1 是）',
  `is_show` char(1) DEFAULT NULL COMMENT '是否在菜单中显示（0 否 1 是）',
  `index_show` char(1) DEFAULT NULL COMMENT '是否首页展示（0否 1 是）',
  `open_type` char(1) DEFAULT NULL COMMENT '打开方式（1 当前页 2 新标签页）',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='模板模块信息表';

-- ----------------------------
-- Table structure for tb_module_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_module_type`;
CREATE TABLE `tb_module_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `um_id` int(11) DEFAULT NULL COMMENT '模板ID',
  `module_id` int(11) DEFAULT NULL COMMENT '栏目ID',
  `title` varchar(10) DEFAULT NULL COMMENT '分类名称',
  `sort` int(11) NOT NULL COMMENT '排序值',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='栏目类型表';

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `order_no` varchar(30) DEFAULT NULL COMMENT '订单编号',
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户ID',
  `origin_price` decimal(16,2) DEFAULT NULL COMMENT '原价',
  `curr_price` decimal(16,2) DEFAULT NULL COMMENT '现价',
  `actual_price` decimal(16,2) DEFAULT NULL COMMENT '实付价格',
  `order_type` varchar(2) DEFAULT NULL COMMENT '订单类型（1 产品新购 2 续费）',
  `pay_type` varchar(2) DEFAULT NULL COMMENT '支付方式(1支付宝 2微信)',
  `order_time` datetime DEFAULT NULL COMMENT '下单时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `cancel_time` datetime DEFAULT NULL COMMENT '取消订单时间',
  `close_time` datetime DEFAULT NULL COMMENT '关闭订单时间',
  `status` varchar(2) DEFAULT NULL COMMENT '状态（1 待付款 2 已支付 98 已取消 99 已关闭）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

-- ----------------------------
-- Table structure for tb_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_detail`;
CREATE TABLE `tb_order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `order_id` int(11) DEFAULT NULL COMMENT '订单ID',
  `model_id` int(11) DEFAULT NULL COMMENT '模板ID',
  `um_id` int(11) DEFAULT NULL COMMENT '用户模板ID',
  `model_title` varchar(50) DEFAULT NULL COMMENT '模板标题',
  `origin_price` decimal(16,2) DEFAULT NULL COMMENT '原价（单价）',
  `curr_price` decimal(16,2) DEFAULT NULL COMMENT '现价（单价）',
  `buy_count` int(11) DEFAULT NULL COMMENT '购买数量',
  `total_prime` decimal(16,2) DEFAULT NULL COMMENT '总价（原价）',
  `total_curr` decimal(16,2) DEFAULT NULL COMMENT '总价（现价）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单详情表';

-- ----------------------------
-- Table structure for tb_passwdrc
-- ----------------------------
DROP TABLE IF EXISTS `tb_passwdrc`;
CREATE TABLE `tb_passwdrc` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `passwd` varchar(64) DEFAULT NULL COMMENT '密码',
  `set_time` datetime DEFAULT NULL COMMENT '设置时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COMMENT='用户登录密码设置记录表';

-- ----------------------------
-- Records of tb_passwdrc
-- ----------------------------
BEGIN;
INSERT INTO `tb_passwdrc` VALUES (11, '1512712086320', '123456', '2017-12-08 13:40:54');
INSERT INTO `tb_passwdrc` VALUES (12, '1512712086320', '1234567', '2017-12-08 16:05:36');
INSERT INTO `tb_passwdrc` VALUES (13, '1512720979435', '123456', '2017-12-08 16:09:01');
INSERT INTO `tb_passwdrc` VALUES (14, '1512712086320', '12345678', '2017-12-08 16:18:37');
INSERT INTO `tb_passwdrc` VALUES (15, '1512712086320', '12345678', '2017-12-08 16:37:59');
INSERT INTO `tb_passwdrc` VALUES (16, '1512712086320', '12345678', '2017-12-08 16:39:57');
INSERT INTO `tb_passwdrc` VALUES (17, '1512712086320', '12345678', '2017-12-08 16:40:29');
INSERT INTO `tb_passwdrc` VALUES (18, '1512712086320', '12345678', '2017-12-08 16:40:57');
COMMIT;

-- ----------------------------
-- Table structure for tb_pay_callback
-- ----------------------------
DROP TABLE IF EXISTS `tb_pay_callback`;
CREATE TABLE `tb_pay_callback` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `order_id` int(11) DEFAULT NULL COMMENT '订单ID',
  `pay_sign` varchar(100) DEFAULT NULL COMMENT '支付签名',
  `prepay_id` varchar(50) DEFAULT NULL COMMENT '预支付ID',
  `pay_return_code` varchar(20) DEFAULT NULL COMMENT '支付返回码',
  `pay_return_msg` varchar(50) DEFAULT NULL COMMENT '支付返回信息',
  `pay_channel` varchar(2) DEFAULT NULL COMMENT '支付渠道（1 微信 2 支付宝）',
  `three_pay_id` varchar(50) DEFAULT NULL COMMENT '第三方支付流水号',
  `bank_type` varchar(20) DEFAULT NULL COMMENT '银行类型',
  `prepay_return_code` varchar(20) DEFAULT NULL COMMENT '支付业务摘要码',
  `prepay_return_msg` varchar(50) DEFAULT NULL COMMENT '支付业务摘要信息',
  `result_code` varchar(10) DEFAULT NULL COMMENT '支付业务返回码',
  `record_time` datetime DEFAULT NULL COMMENT '记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付回调数据记录表';

-- ----------------------------
-- Table structure for tb_pay_feedback
-- ----------------------------
DROP TABLE IF EXISTS `tb_pay_feedback`;
CREATE TABLE `tb_pay_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `problem` varchar(50) DEFAULT NULL COMMENT '遇到的问题内容',
  `suggest` varchar(500) DEFAULT NULL COMMENT '用户建议',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户支付问题反馈记录表';

-- ----------------------------
-- Table structure for tb_singlepage
-- ----------------------------
DROP TABLE IF EXISTS `tb_singlepage`;
CREATE TABLE `tb_singlepage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `um_id` int(11) DEFAULT NULL COMMENT '模板ID',
  `module_id` int(11) DEFAULT NULL COMMENT '栏目ID',
  `content` text COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='单页信息表';

-- ----------------------------
-- Table structure for tb_token
-- ----------------------------
DROP TABLE IF EXISTS `tb_token`;
CREATE TABLE `tb_token` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';

-- ----------------------------
-- Records of tb_token
-- ----------------------------
BEGIN;
INSERT INTO `tb_token` VALUES ('1512712086320', 'ac822ced-6651-4a2e-b620-be3fddd81d8f', '2017-12-15 17:19:59', '2017-12-08 17:19:59');
INSERT INTO `tb_token` VALUES ('1512720979435', '915eacf1-57c3-4b31-b502-bf5891495353', '2017-12-15 16:09:01', '2017-12-08 16:09:01');
COMMIT;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` varchar(32) NOT NULL,
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `qq` varchar(15) DEFAULT NULL COMMENT 'QQ',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `wx_account` varchar(20) DEFAULT NULL COMMENT '微信账号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `status` int(1) DEFAULT '0' COMMENT '用户状态（0 正常 -1 冻结）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基础信息表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` VALUES ('1512712086320', 'aaaa', NULL, '18518673223', '12345678', '1234444@qq.com', '123344555', 'bbbbb', NULL, '2017-12-08 13:40:54', '2017-12-08 13:40:54', 0);
INSERT INTO `tb_user` VALUES ('1512720979435', 'lili', NULL, '18518673224', '123456', NULL, NULL, NULL, NULL, '2017-12-08 16:09:01', '2017-12-08 16:09:01', 0);
COMMIT;

-- ----------------------------
-- Table structure for tb_verifycode
-- ----------------------------
DROP TABLE IF EXISTS `tb_verifycode`;
CREATE TABLE `tb_verifycode` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `mobile` varchar(11) DEFAULT NULL COMMENT '用户手机号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '除注册外需插入该字段',
  `code` varchar(10) NOT NULL COMMENT '验证码',
  `type` varchar(2) DEFAULT NULL COMMENT '1 注册 2 找回密码 3 修改手机号',
  `status` varchar(2) DEFAULT NULL COMMENT '状态（0 可用 1 不可用）',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `ip` varchar(20) DEFAULT NULL COMMENT 'IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COMMENT='验证码发送记录表';

-- ----------------------------
-- Records of tb_verifycode
-- ----------------------------
BEGIN;
INSERT INTO `tb_verifycode` VALUES (12, '18518673223', '1512712086320', '980282', '2', '0', '2017-12-08 15:11:38', '2017-12-08 15:16:38', '0:0:0:0:0:0:0:1');
INSERT INTO `tb_verifycode` VALUES (13, '18518673223', '1512712086320', '819778', '2', '0', '2017-12-08 15:11:18', '2017-12-08 15:20:18', '0:0:0:0:0:0:0:1');
INSERT INTO `tb_verifycode` VALUES (14, '18518673223', '507305', '507305', '3', '1', '2017-12-08 16:18:07', '2017-12-08 16:22:07', '0:0:0:0:0:0:0:1');
INSERT INTO `tb_verifycode` VALUES (15, '18518673224', '956639', '956639', '1', '1', '2017-12-08 16:09:20', '2017-12-08 16:11:20', '0:0:0:0:0:0:0:1');
COMMIT;

-- ----------------------------
-- Procedure structure for NewProc
-- ----------------------------
DROP PROCEDURE IF EXISTS `NewProc`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `NewProc`()
BEGIN
  SELECT CONCAT('ASU', RIGHT(CONCAT('0000000000',_nextval('user_id')), 10))  as id;
END;
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
