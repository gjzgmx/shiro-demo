<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body onload="javascript:window.location='<%=path %>/index.do';">

<%--  <a href="<%=basePath%>/logout.do">退出</a>
<a href="<%=request.getContextPath()%>/page.do">admin 权限</a>
<a href="<%=request.getContextPath()%>/page2.do">admin与guest 权限</a>
 --%>
 
</body>
</html>