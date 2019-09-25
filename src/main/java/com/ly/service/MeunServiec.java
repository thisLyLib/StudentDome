package com.ly.service;

import com.ly.bean.MenuBean;

import java.util.List;

public interface MeunServiec {

    /**
     * @return
     * 菜单列表
     */
    List<MenuBean>menuList();

    /**
     * @param roleId 角色Id
     * @return
     * 通过角色id获取菜单列表
     */
    List<MenuBean>menuListByRoleId(Integer roleId);
}
