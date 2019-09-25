package com.ly.service;

import com.ly.bean.UserBean;

public interface UserService {

    /**登陆
     * @param userName
     * @param passWord
     * @return
     * ture And Falss
     */
    UserBean login(String userName, String passWord);
}
