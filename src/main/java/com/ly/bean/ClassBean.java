package com.ly.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_class
 * @author 
 */
@Data
public class ClassBean implements Serializable {
    private Integer classId;

    private String className;

    /**
     * 开班时间
     */
    private Date classStartTime;

    /**
     * 班级状态   0 正常授课 1 毕业 2 项目开发 3,.联合开发',
     */
    private Integer classStatus;

    /**
     * 班主任  用户ID
     */
    private Integer classManager;

    /**
     * 授课老师  用户id
     */
    private Integer classTeacher;


}