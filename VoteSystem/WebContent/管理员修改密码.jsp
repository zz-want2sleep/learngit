<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员修改密码界面</title>
<link rel="stylesheet" type="text/css" href="table.css"/>
<link rel="stylesheet" href="index.css">
</head>
<body>
<div id="header">
<div id="nav1"> 
<ul>
 <li class="borderleft"><a>管理员密码</a></li>
 <li><a href="Home.jsp" >主页面</a></li>

</ul>
</div>
</div>
<div class="bd2">
<table class="gridtable" border=1px cellpadding=0 cellspacing=0 width="500px">
<tr>
<td align="center"colspan="3">用户账号信息</td>
</tr>
<tr>
<td >密码</td>
<td colspan="2" align="center">操作</td>
</tr>
<%
//ResultSet rs=(ResultSet)request.getAttribute("rs1");
ResultSet rs=(ResultSet)session.getAttribute("rs0");
rs.absolute(1);
do{
 %>
<tr>
<td><%=rs.getString("pwd") %></td>
<td colspan="2" align="center"><a href="LoginServlet3">修改</a></td>
</tr>

<%
//rs.absolute(1);

}while(rs.next());
%>
</table>
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