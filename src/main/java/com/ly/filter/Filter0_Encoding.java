package com.ly.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 编码过滤器
 * @author 快乐小码农
 */
@WebFilter(urlPatterns ="/*")
public class Filter0_Encoding implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //请求
        req.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
        //响应
        resp.setCharacterEncoding("utf-8");


    }

    @Override
    public void destroy() {

    }
}
