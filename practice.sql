/*
Navicat MySQL Data Transfer

Source Server         : TencentMysql
Source Server Version : 50718
Source Host           : cdb-h21kv35v.gz.tencentcdb.com:10025
Source Database       : practice

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-09-12 10:59:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `attachment_id` varchar(32) NOT NULL COMMENT '附件号',
  `attachment_name` varchar(50) NOT NULL COMMENT '附件名字',
  `attachment_url` varchar(100) NOT NULL COMMENT '附件存储地址',
  `attachment_type` int(10) NOT NULL COMMENT '附件类型',
  `business_type` varchar(10) NOT NULL COMMENT '业务类型',
  `business_id` varchar(32) NOT NULL COMMENT '业务编号',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `create_time` datetime(6) NOT NULL COMMENT '创建时间',
  `modifier` varchar(32) NOT NULL COMMENT '最近一次修改者',
  `modify_time` datetime(6) NOT NULL COMMENT '最近一次修改时间',
  `save1` varchar(0) DEFAULT NULL COMMENT '保留字段',
  `save2` varchar(0) DEFAULT NULL COMMENT '保留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attachment
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `course_id` varchar(32) NOT NULL DEFAULT '' COMMENT '课程号',
  `course_name` varchar(30) NOT NULL DEFAULT '' COMMENT '课程名',
  `teacher_id` varchar(32) NOT NULL DEFAULT '' COMMENT '讲师号',
  `start_time` datetime(6) NOT NULL COMMENT '课程开始时间',
  `end_time` datetime(6) NOT NULL COMMENT '课程结束时间',
  `address` varchar(30) NOT NULL DEFAULT '' COMMENT '上课地址',
  `description` varchar(100) DEFAULT '' COMMENT '课程描述',
  `is_active` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否活跃（默认值为1，被删除为0）',
  `creator` varchar(32) NOT NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(6) NOT NULL COMMENT '创建时间',
  `modifier` varchar(32) NOT NULL COMMENT '最近一次修改者',
  `modify_time` datetime(6) NOT NULL COMMENT '最近一次修改时间',
  `save1` varchar(0) DEFAULT NULL COMMENT '保留字段',
  `save2` varchar(0) DEFAULT NULL COMMENT '保留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for course_student
-- ----------------------------
DROP TABLE IF EXISTS `course_student`;
CREATE TABLE `course_student` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `course_id` varchar(32) NOT NULL COMMENT '课程号',
  `student_id` varchar(32) NOT NULL COMMENT '学生号',
  `is_signed` bit(1) NOT NULL COMMENT '签到标志位（默认值为0，签到后为1）',
  `is_active` bit(1) NOT NULL COMMENT '是否活跃(默认值为1，签到后为0)',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `create_time` datetime(6) NOT NULL COMMENT '创建时间',
  `modifier` varchar(32) NOT NULL COMMENT '最近一次修改者',
  `modify_time` datetime(6) NOT NULL COMMENT '最近一次修改时间',
  `save1` varchar(0) DEFAULT NULL COMMENT '保留字段',
  `save2` varchar(0) DEFAULT NULL COMMENT '保留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_student
-- ----------------------------
INSERT INTO `course_student` VALUES ('1', '4387cebaad1a4f63ac7a2def53312860', '8342dfddcc9f4fab8eaeb3e581d0c2b8', '\0', '', '4387cebaad1a4f63ac7a2def53312860', '2018-09-10 16:24:17.000000', 'a8929bc9221847f0a60b83b2056d29a5', '2018-09-10 16:25:08.000000', null, null);
INSERT INTO `course_student` VALUES ('2', '8342dfddcc9f4fab8eaeb3e581d0c2b8', '5c514f68e4b04c9193f0801e19c5fc5f', '', '', '6ccf0ebd562546388b7c8c979944d1fb', '2018-09-10 16:25:41.000000', 'f4d674743315495180cfe2182fdbf471', '2018-09-11 16:26:30.000000', null, null);

-- ----------------------------
-- Table structure for evaluation
-- ----------------------------
DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE `evaluation` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `course_id` varchar(32) NOT NULL COMMENT '课程号',
  `student_id` varchar(32) NOT NULL COMMENT '学生号',
  `score` int(3) NOT NULL COMMENT '评价分数',
  `is_evaluated` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否评估（默认值为0，评估后为1）',
  `course_evaluation` varchar(100) DEFAULT NULL COMMENT '课程评价',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `create_time` datetime(6) NOT NULL COMMENT '创建时间',
  `modifier` varchar(32) NOT NULL COMMENT '最近一次修改者',
  `modify_time` datetime(6) NOT NULL COMMENT '最近一次修改时间',
  `save1` varchar(0) DEFAULT NULL COMMENT '保留字段',
  `save2` varchar(0) DEFAULT NULL COMMENT '保留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `f_pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `f_file_id` char(32) DEFAULT NULL COMMENT '附件ID',
  `f_task_id` char(32) DEFAULT NULL COMMENT '任务ID',
  `f_tutor_id` char(32) DEFAULT NULL COMMENT '导师ID',
  `f_url` varchar(255) DEFAULT NULL COMMENT '附件存储地址',
  `f_type` varchar(255) DEFAULT NULL COMMENT '附件存储类型',
  `f_name` varchar(255) DEFAULT NULL COMMENT '附件名称',
  `f_creater` varchar(255) DEFAULT NULL COMMENT '创建人',
  `f_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `f_operator` varchar(255) DEFAULT NULL COMMENT '修改人',
  `f_operate_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`f_pk_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of file
-- ----------------------------

-- ----------------------------
-- Table structure for s_basic_info
-- ----------------------------
DROP TABLE IF EXISTS `s_basic_info`;
CREATE TABLE `s_basic_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `uid` varchar(36) NOT NULL COMMENT '系统业务唯一UID',
  `enabled` tinyint(4) NOT NULL DEFAULT '1' COMMENT '有效标识：1有效0失效',
  `creator_uid` varchar(255) NOT NULL DEFAULT '' COMMENT '创建初始信息人员UID',
  `modifier_uid` varchar(255) DEFAULT '0' COMMENT '修改信息人员UID',
  `created_time` datetime NOT NULL COMMENT '创建初始信息时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改信息时间',
  `user_uid` varchar(255) NOT NULL COMMENT '用户账号UID',
  `name` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `gender` bit(1) DEFAULT b'0' COMMENT '用户性别：0:男、1:女（默认“0:男”）',
  `hiredate` date NOT NULL COMMENT '入职时间（默认为注册时间）',
  `status` varchar(255) DEFAULT NULL COMMENT '员工状况',
  `position` varchar(255) DEFAULT NULL COMMENT '员工办公位置',
  `tel` varchar(255) DEFAULT NULL COMMENT '员工座机号码',
  `mobile` varchar(255) DEFAULT NULL COMMENT '员工移动电话',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '用户密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='人员基本信息表';

-- ----------------------------
-- Records of s_basic_info
-- ----------------------------
INSERT INTO `s_basic_info` VALUES ('30', '83c6d6e51e09422bbeba05d97dc30adf', '1', '', '0', '2018-09-05 17:38:15', '2018-09-28 17:38:18', '8342dfddcc9f4fab8eaeb3e581d0c2b8', '张三', '\0', '2018-09-07', '1', null, null, null, '');

-- ----------------------------
-- Table structure for s_role_id
-- ----------------------------
DROP TABLE IF EXISTS `s_role_id`;
CREATE TABLE `s_role_id` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `uid` varchar(36) NOT NULL COMMENT '系统业务唯一UID',
  `enabled` tinyint(4) NOT NULL DEFAULT '1' COMMENT '有效标识：1有效0失效',
  `creator_uid` varchar(255) NOT NULL DEFAULT '' COMMENT '创建初始信息人员UID',
  `modifier_uid` varchar(255) DEFAULT '0' COMMENT '修改信息人员UID',
  `created_time` datetime NOT NULL COMMENT '创建初始信息时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改信息时间',
  `role_uid` int(11) NOT NULL COMMENT '角色UID',
  `role` varchar(255) NOT NULL DEFAULT '' COMMENT '角色类型名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色—ID表';

-- ----------------------------
-- Records of s_role_id
-- ----------------------------

-- ----------------------------
-- Table structure for s_security_question
-- ----------------------------
DROP TABLE IF EXISTS `s_security_question`;
CREATE TABLE `s_security_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `question_uid` int(11) NOT NULL COMMENT '系统业务唯一UID',
  `question` varchar(255) NOT NULL COMMENT '具体问题',
  `creator_uid` varchar(255) NOT NULL DEFAULT '' COMMENT '创建密保问题人员UID',
  `modifier_uid` varchar(255) DEFAULT '0' COMMENT '修改密保问题人员UID',
  `created_time` datetime NOT NULL COMMENT '创建密保问题时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改密保问题时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='密保问题管理表';

-- ----------------------------
-- Records of s_security_question
-- ----------------------------

-- ----------------------------
-- Table structure for s_student_tutor
-- ----------------------------
DROP TABLE IF EXISTS `s_student_tutor`;
CREATE TABLE `s_student_tutor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `uid` varchar(36) NOT NULL COMMENT '系统业务唯一UID',
  `enabled` tinyint(4) NOT NULL DEFAULT '1' COMMENT '有效标识：1有效0失效',
  `creator_uid` varchar(255) NOT NULL DEFAULT '' COMMENT '创建初始信息人员UID',
  `modifier_uid` varchar(255) DEFAULT '0' COMMENT '修改信息人员UID',
  `created_time` datetime NOT NULL COMMENT '创建初始信息时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改信息时间',
  `student_uid` varchar(255) NOT NULL DEFAULT '' COMMENT '学生账号UID',
  `tutor_uid` varchar(255) NOT NULL DEFAULT '' COMMENT '导师UID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='学生—导师表';

-- ----------------------------
-- Records of s_student_tutor
-- ----------------------------

-- ----------------------------
-- Table structure for s_uer_question_answer
-- ----------------------------
DROP TABLE IF EXISTS `s_uer_question_answer`;
CREATE TABLE `s_uer_question_answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `uid` varchar(36) NOT NULL COMMENT '系统业务唯一UID',
  `enabled` tinyint(4) NOT NULL DEFAULT '1' COMMENT '有效标识：1有效0失效',
  `creator_uid` varchar(255) NOT NULL DEFAULT '' COMMENT '创建初始信息人员UID',
  `modifier_uid` varchar(255) DEFAULT '0' COMMENT '修改信息人员UID',
  `created_time` datetime NOT NULL COMMENT '创建初始信息时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改信息时间',
  `user_uid` varchar(255) NOT NULL COMMENT '用户账号UID',
  `question_uid` int(11) DEFAULT NULL COMMENT '密保问题UID',
  `answer` varchar(255) DEFAULT NULL COMMENT '密保问题答案',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='人员—密保ID—密保问题表';

-- ----------------------------
-- Records of s_uer_question_answer
-- ----------------------------

-- ----------------------------
-- Table structure for s_user_role
-- ----------------------------
DROP TABLE IF EXISTS `s_user_role`;
CREATE TABLE `s_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `uid` varchar(36) NOT NULL COMMENT '系统业务唯一UID',
  `enabled` tinyint(4) NOT NULL DEFAULT '1' COMMENT '有效标识：1有效0失效',
  `creator_uid` varchar(255) NOT NULL DEFAULT '' COMMENT '创建初始信息人员UID',
  `modifier_uid` varchar(255) DEFAULT '0' COMMENT '修改信息人员UID',
  `created_time` datetime NOT NULL COMMENT '创建初始信息时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改信息时间',
  `user_uid` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号UID',
  `role_uid` int(11) NOT NULL DEFAULT '1' COMMENT '角色UID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='人员—角色表';

-- ----------------------------
-- Records of s_user_role
-- ----------------------------
INSERT INTO `s_user_role` VALUES ('1', 'e8b9e59c91914af7876f52157829e942', '1', '5611e5ea4df245b98ff3f847b512e47a', 'a35cfe1aec4141f293b247b876dd6e08', '2018-09-10 16:20:35', '2018-09-10 16:20:38', '605567fdb8b9449fb5104f7d77e649b5', '2');
INSERT INTO `s_user_role` VALUES ('2', '531bd0a8ea124019baebeb6d994f58d6', '1', 'c076316d624e48748762d6a6aa64ee45', '08107db4a81f485e8bac6ff72672518b', '2018-09-10 16:21:17', '2018-09-10 16:21:25', '83763353133c4c39a737c61bed17d6a1', '2');
INSERT INTO `s_user_role` VALUES ('3', '00d71e05b7df482da896265725cacf08', '1', '291fec97c1c7407ba20ca9f9f70894be', '52dc26082d154b1e8b735a25151aad5d', '2018-09-10 16:22:32', '2018-09-10 16:31:30', '52dc26082d154b1e8b735a25151aad5d', '2');

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `t_pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_task_id` char(32) DEFAULT NULL COMMENT '任务ID',
  `t_tutor_id` char(32) DEFAULT NULL COMMENT '导师ID',
  `t_name` varchar(255) DEFAULT NULL COMMENT '任务名称',
  `t_category` int(11) DEFAULT NULL COMMENT '任务类别（0开发部,1，...）',
  `t_content` varchar(10000) DEFAULT NULL COMMENT '任务内容',
  `t_state` int(11) DEFAULT NULL COMMENT '任务状态（0草稿，1使用中，2废弃）',
  `t_time` int(11) DEFAULT NULL COMMENT '任务时长',
  `t_creater` varchar(255) DEFAULT NULL COMMENT '创建人',
  `t_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `t_operator` varchar(255) DEFAULT NULL COMMENT '修改人',
  `t_operate_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`t_pk_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------

-- ----------------------------
-- Table structure for task_using
-- ----------------------------
DROP TABLE IF EXISTS `task_using`;
CREATE TABLE `task_using` (
  `t_pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_task_id` char(32) DEFAULT NULL COMMENT '任务ID',
  `t_tutor_id` char(32) DEFAULT NULL COMMENT '导师ID',
  `t_stu_id` char(32) DEFAULT NULL COMMENT '学生ID',
  `t_name` varchar(255) DEFAULT NULL COMMENT '任务名称',
  `t_category` int(11) DEFAULT NULL COMMENT '任务类别（0,1，...)',
  `t_content` varchar(10000) DEFAULT NULL COMMENT '任务内容',
  `t_progress` int(11) DEFAULT NULL COMMENT '任务完成情况（0未开始,1进行中,2已完成,3已逾期，4已撤回）',
  `t_time` int(11) DEFAULT NULL COMMENT '任务时长',
  `t_feedback` varchar(10000) DEFAULT NULL COMMENT '任务反馈',
  `t_start_date` date DEFAULT NULL COMMENT '任务开始日期',
  `t_expiration_date` date DEFAULT NULL COMMENT '任务截止日期',
  `t_finish_date` date DEFAULT NULL COMMENT '任务完成日期',
  `t_creater` varchar(255) DEFAULT NULL COMMENT '创建人',
  `t_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `t_operator` varchar(255) DEFAULT NULL COMMENT '修改人',
  `t_operate_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`t_pk_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task_using
-- ----------------------------
