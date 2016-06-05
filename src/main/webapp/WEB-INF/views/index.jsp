<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

  登录成功！ &nbsp; <a href="<%=basePath%>/logout">退出</a>
<a href="<%=request.getContextPath()%>/dopage_1">连接1(admin与guest 都有权限)</a>
<a href="<%=request.getContextPath()%>/dopage_2">连接2(只有admin 有权限)</a>

    <shiro:principal/>
 
    <%--   <%= SecurityUtils.getSubject().getPrincipals().getRealmNames()%>
      <%= SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal()%>  --%>
</body>
</html>