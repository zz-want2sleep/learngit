<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理界面</title>
<link rel="stylesheet" type="text/css" href="table.css"/>
<link rel="stylesheet" href="index.css">
</head>
<body>
<div id="header">
<div id="nav1"> 
<ul>
 <li class="borderleft"><a href="用户登录.jsp" >用户登录</a></li>
 <li><a href="管理员登录.jsp" >管理员登录</a></li>
 <li><a href="Home.jsp" >主页面</a></li>

</ul>
</div>
</div>
<div class="bd">
<form action="SelectServlet2">
<table class="gridtable" border=1px cellpadding=0 cellspacing=0>
<tr>
<td align="center"colspan="3">密码信息</td>
</tr>
<tr>
<td >密码</td>
<td colspan="2" align="center">操作</td>
</tr>
<%
ResultSet rs=(ResultSet)session.getAttribute("rs");
rs.absolute(1);
do{
	String pwd=rs.getString("pwd");
%>
<tr>
<td><input type="text" name="pwd" value=<%=pwd %>></td>
<td>
<input type="submit" value="修改" />&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="重置"/>
</td>
</tr>
<% 
}while(rs.next());
%>

</table>
</form>
</div>

<div id="footer">
<pre>
     实验教学管理测试版！
   欢迎提出意见
  联系方式：xxx
</pre>
</div>
</body>
</html>