package com.ly.bean;

import lombok.Data;

import javax.servlet.annotation.WebServlet;
import java.io.Serializable;

/**
 * tb_menu
 * @author 
 */
@Data
public class MenuBean implements Serializable {
    private Integer menuId;

    private String menuName;

    private String menuUrl;

    /**
     * 当前菜单的父级菜单是谁
     */
    private Integer menuParentId;

    /**
     * 0 启用 1禁用
     */
    private Integer menuStatus;

}