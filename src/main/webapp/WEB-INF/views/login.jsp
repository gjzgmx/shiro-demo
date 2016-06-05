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
<body>
    <form action="<%=path %>/login" method="post"> 
        username:<input name="username" id="username" type="text" />
        password:<input name="password" id="password" type="password" />
              记住我：<input type="checkbox" name="rememberMe" />
        <input type="submit" value="登录"/>
         <input type="reset" value="重置"/>
        <span id="errorMsg" style="color:red"></span>

     </form>
</body>
</html>