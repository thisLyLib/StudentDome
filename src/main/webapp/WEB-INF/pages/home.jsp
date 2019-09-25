
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">School</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="#1">基本资料</a></dd>
                    <dd><a href="#1">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="#1">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
<%--                <li class="layui-nav-item layui-nav-itemed">--%>
<%--                    <a class="" href="javascript:;">系统管理</a>--%>
<%--                    <dl class="layui-nav-child">--%>
<%--                        <dd><a href="javascript:;">用户管理</a></dd>--%>
<%--                        <dd><a href="javascript:;">角色管理</a></dd>--%>
<%--                        <dd><a href="javascript:;">菜单管理</a></dd>--%>
<%--                    </dl>--%>
<%--                </li>--%>
<%--                <li class="layui-nav-item layui-nav-itemed">--%>
<%--                    <a class="" href="javascript:;">班级管理</a>--%>
<%--                    <dl class="layui-nav-child">--%>
<%--                        <dd><a href="javascript:;">课堂点名</a></dd>--%>
<%--                    </dl>--%>
<%--                </li>--%>
<%--                <li class="layui-nav-item">--%>
<%--                    <a href="javascript:;">学生信息</a>--%>
<%--                    <dl class="layui-nav-child">--%>
<%--                        <dd><a href="javascript:;">信息管理</a></dd>--%>
<%--                        <dd><a href="javascript:;">考勤情况</a></dd>--%>
<%--                    </dl>--%>
<%--                </li>--%>
<%--                    一级菜单--%>
                    <c:forEach var="menu1" items="${menuList}">
                        <c:if test="${menu1.menuParentId == 0}">
                            <li class="layui-nav-item">
                                <a href="javascript:;">${menu1.menuName}</a>
<%--                                二级菜单--%>
                                <c:forEach var="menu2" items="${menuList}">
<%--                                    menu2.menuParentId !=0 获取所有的二级菜单--%>
<%--                                       当前菜单的父级菜单id 必须与 一级菜单的id相同--%>
                                    <c:if test="${menu2.menuParentId !=0 and menu2.menuParentId == menu1.menuId}">
                                        <dl class="layui-nav-child">
                                            <dd><a href="javascript:;">${menu2.menuName}</a></dd>
                                        </dl>
                                    </c:if>
                                </c:forEach>
                            </li>
                        </c:if>
                    </c:forEach>

            </ul>
        </div>
    </div>

    <div class="layui-body">
        <iframe name="mian" style="width: 100%;height: 100%;position: absolute;left: 0;right: 0;top: 0;bottom:0;" scrolling="no" frameborder="0"></iframe>

    </div>

    <div class="layui-footer">
    </div>
</div>
<script src="/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;



    });
</script>
</body>
</html>