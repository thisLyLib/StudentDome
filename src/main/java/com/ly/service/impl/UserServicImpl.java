package com.ly.service.impl;

import com.ly.bean.UserBean;
import com.ly.dao.UserDao;
import com.ly.dao.impl.UserDaoImpl;
import com.ly.service.UserService;

public class UserServicImpl implements UserService {
        private UserDao userDao = new UserDaoImpl();
    /**
     * 登陆
     * @param userName
     * @param passWord
     * @return
     *
     */
    @Override
    public UserBean login(String userName, String passWord) {
        UserBean userBean = userDao.selectByUser(userName);
        //如果为空表示用户不存在
        if (userBean==null){
            return null;
        }
        //如果执行到这里，代表用户存在，在验证密码
        //密码错误
        if (!userBean.getUserEmail().equals(passWord)){
            return null;
        }
        //执行到这里代表账号密码存在返回user对象
        return userBean;
    }
}
