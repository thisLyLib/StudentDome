package com.ly.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_student
 * @author 
 */
@Data
public class StudentBean implements Serializable {
    /**
     * 学生编号
     */
    private Integer studentId;

    private String studentName;

    /**
     * 年龄
     */
    private Integer studentAge;

    /**
     * 0 保密 1 男 2女
     */
    private Integer studentSex;

    /**
     * 手机号
     */
    private Integer studentPhone;

    /**
     * 邮箱
     */
    private String studentEmail;

    /**
     * 入学时间
     */
    private Date studentStartTime;

    /**
     * 学生状态  0  学习中   1 休学  2请假   3毕业
     */
    private Integer studentStatus;

    /**
     * 学员编号
     */
    private String studentCode;

    /**
     * 班级id
     */
    private String  classId;


}