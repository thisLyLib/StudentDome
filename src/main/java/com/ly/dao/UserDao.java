package com.ly.dao;

import com.ly.bean.UserBean;

public interface UserDao {

    /**
     * 通过账号密码查询对象
     * @param userName
     * @return 对象
     */
    UserBean selectByUser(String userName);

}
