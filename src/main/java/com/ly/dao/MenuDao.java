package com.ly.dao;

import com.ly.bean.MenuBean;

import java.util.List;

/**
 * @author 快乐小码农
 * 菜单信息
 */
public interface MenuDao {

    /**
     * 查询所有的菜单项
     * @return
     */

    List<MenuBean>selectMenuList();

    /**
     * 通过角色id查询菜单列表
     * @param roleId
     * @return
     */
    List<MenuBean>selectMenuListByRoleId(Integer roleId);

}
