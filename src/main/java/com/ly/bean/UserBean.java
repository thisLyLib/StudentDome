package com.ly.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_user
 * @author 
 */
@Data
public class UserBean implements Serializable {
    private Integer userId;

    /**
     * 邮箱
     */
    private String userEmail;

    private String userPassword;

    private String userHeadImg;

    /**
     * 用户状态 0启用  1禁用
     */
    private Integer userStatus;

    /**
     * 角色id
     */
    private Integer userRole;
    /**
     *Token
     */
    private String userToken;
    /**
     *Token存活时间
     */
    private Date userTokenEndTime;


}