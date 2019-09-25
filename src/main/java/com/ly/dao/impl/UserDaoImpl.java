package com.ly.dao.impl;

import com.ly.bean.UserBean;
import com.ly.dao.UserDao;
import com.ly.util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends JdbcUtil implements UserDao {

    private UserBean ResultSetToUser(ResultSet resultSet) throws SQLException {
        UserBean userBean=new UserBean();
        userBean.setUserId(resultSet.getInt(1));
        userBean.setUserEmail(resultSet.getString(2));
        userBean.setUserPassword(resultSet.getString(3));
        userBean.setUserHeadImg(resultSet.getNString(4));
        userBean.setUserStatus(resultSet.getInt(5));
        userBean.setUserRole(resultSet.getInt(6));
        userBean.setUserToken(resultSet.getString(7));
        userBean.setUserTokenEndTime(resultSet.getTime(8));


        return userBean;
    }

    /**
     * 通过用户名查询对象查询对象
     * @param userName
     * @return
     */
    @Override
    public UserBean selectByUser(String userName) {
        String sql = "select * from tb_user where user_email = ?";
        ResultSet resultSet =select(sql,new Object []{userName});
        if (resultSet==null){
            return null;
        }
        try {
            if (resultSet.next()){
               return ResultSetToUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.coles();
        }
        return null;
    }
}
