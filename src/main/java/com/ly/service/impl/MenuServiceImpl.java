package com.ly.service.impl;

import com.ly.bean.MenuBean;

import com.ly.dao.MenuDao;
import com.ly.dao.impl.MenuDaoImpl;

import com.ly.service.MeunServiec;

import java.util.List;

public class MenuServiceImpl implements MeunServiec {
    private MenuDao menuDao = new MenuDaoImpl();

    @Override
    public List<MenuBean> menuList() {
        return menuDao.selectMenuList();
    }

    @Override
    public List<MenuBean> menuListByRoleId(Integer roleId) {
        return menuDao.selectMenuListByRoleId(roleId);
    }
}
