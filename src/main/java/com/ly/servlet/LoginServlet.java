package com.ly.servlet;

import com.ly.bean.UserBean;
import com.ly.service.UserService;
import com.ly.service.impl.UserServicImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServicImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+"---------"+password);
        if (username==null &&"".equals(username)){return;}
        if (password==null &&"".equals(password)){return;}

        UserBean login = userService.login(username, password);
        if (login==null){
            req.setAttribute("er","账号或密码错误!");
          req.getRequestDispatcher("/login.jsp").forward(req,resp);
           return;
         }

        //将用户信息存入session中
        req.getSession().setAttribute("user",login);
//        req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req,resp);
        resp.sendRedirect("/v2/home");
    }
}
