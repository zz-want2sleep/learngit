<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员管理界面</title>
<link rel="stylesheet" type="text/css" href="table.css"/>
<link rel="stylesheet" href="index.css">
</head>
<body>
<div id="header">
<div id="nav1"> 
<ul>
 <li class="borderleft"><a >所有用户基本信息</a></li>
 
 <li><a href="Home.jsp" >主页面</a></li>

</ul>
</div>
</div>
<div class="bd">
<table class="gridtable" border=1px cellpadding=0 cellspacing=0>
<tr>
<td align="center"colspan="9">注册信息</td>
</tr>
<tr>
<td >序号</td>
<td >姓名</td>
<td >性别</td>
<td >学历</td>
<td >职业</td>
<td >特长</td>
<td >国籍</td>
<td colspan="2" align="center">操作</td>
</tr>
<%
ResultSet rs=(ResultSet)session.getAttribute("rs");
while(rs.next()){
%>
<tr>
<td><%=rs.getInt("id") %></td>
<td><%=rs.getString("name") %></td>
<td><%=rs.getString("sex") %></td>
<td><%=rs.getString("education") %></td>
<td><%=rs.getString("occupation") %></td>
<td><%=rs.getString("specialty") %></td>
<td><%=rs.getString("nation") %></td>
<td><a href="SelectServlet?id=<%=rs.getInt("id") %>">修改</a></td>
<td><a href="DeleteServlet?id=<%=rs.getInt("id") %>" onclick="return confirm('确认删除吗？');">删除</a></td>
</tr>
<% 
}
%>
<tr>
<td align="center" colspan="9"><a href="ZhuceAdd.jsp">添加</a></td>
</tr>
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