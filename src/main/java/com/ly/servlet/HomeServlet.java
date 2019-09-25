package com.ly.servlet;

import com.ly.bean.UserBean;
import com.ly.service.MeunServiec;
import com.ly.service.impl.MenuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 后台主页
 */
@WebServlet("/v2/home")
public class HomeServlet extends HttpServlet {
    private MeunServiec meunServiec = new MenuServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从登陆后存入的session中获取角色信息
        UserBean userBean = (UserBean)req.getSession().getAttribute("user");
        //根据角色id获取菜单列表
        req.setAttribute("menuList",meunServiec.menuListByRoleId(userBean.getUserRole()));
            req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
