package com.ly.dao.impl;

import com.ly.bean.MenuBean;
import com.ly.dao.MenuDao;
import com.ly.util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDaoImpl extends JdbcUtil implements MenuDao {
    private MenuBean MenuRest(ResultSet resultSet) throws SQLException {
       MenuBean menuBean = new MenuBean();
       menuBean.setMenuId(resultSet.getInt(1));
       menuBean.setMenuName(resultSet.getString(2));
       menuBean.setMenuUrl(resultSet.getString(3));
       menuBean.setMenuParentId(resultSet.getInt(4));
       menuBean.setMenuStatus(resultSet.getInt(5));
        return menuBean;
    }

    @Override
    public List<MenuBean> selectMenuList() {
        String sql = "select * from tb_menu where menu_status = 0";
        ResultSet resultSet = select(sql,null);
        List<MenuBean>menuBeans = new ArrayList<>();
        try {
            while (resultSet.next()){
                MenuBean menuBean = MenuRest(resultSet);
                menuBeans.add(menuBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(menuBeans);
        return menuBeans;
    }

    @Override
    public List<MenuBean> selectMenuListByRoleId(Integer roleId) {
        String sql = "select m.* from tb_menu m inner join tb_role_menu rm on m.menu_id = rm.menu_id where m.menu_status = 0 and rm.role_id =?";

        ResultSet resultSet = select(sql,new Object[]{roleId});
        List<MenuBean>menuBeans = new ArrayList<>();
        try {
            while (resultSet.next()){
                MenuBean menuBean = MenuRest(resultSet);
                menuBeans.add(menuBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(menuBeans);
        return menuBeans;
    }
}
