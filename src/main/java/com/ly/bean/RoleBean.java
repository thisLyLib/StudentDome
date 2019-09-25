package com.ly.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tb_role
 * @author 
 */
@Data
public class RoleBean implements Serializable {
    private Integer roleId;

    private String roleName;

    /**
     * 0 启用 1禁用
     */
    private Integer rolestatus;


}