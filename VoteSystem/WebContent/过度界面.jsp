<%@page import="java.util.Vector" import="servlet.Zhuce"%>
<%@page import="servlet.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="10;url=用户登录.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线人数</title>
</head>
<body>
<%
//如果未登录，转向登录界面
if(session.getAttribute("loginName")==null)
{
	response.sendRedirect("账号密码设置.jsp");
}
//获取存储在线用户名的Vector对象
Vector<String> onlines=User.getVector();
%>
<%
String name=(String)request.getAttribute("loginName");
Zhuce zc=new Zhuce();
if(zc.bijiao2(name)){%>
<p>抱歉，该用户名已被注册</p>
<p><a href="账号密码设置.jsp">点击返回注册页面</a></p>
<p><a href="用户登录.jsp">去登录界面</a></p>
<% 	
}
else{%>
<br/>
<center>
<p>注册成功，<span style='font-family:"consolas";' id="sec" ></span>秒后自动跳转到登录界面</p>
<p><a href="用户登录.jsp">点击返回登录界面</a></p>
<script type="text/javascript">
var sec=10;
function cnt(){
	document.getElementById("sec").innerHTML=sec--;
	setTimeout("cnt()",1000);
}
window.onload=cnt();
</script>
<hr/>
<br/>
<table>
<tr>
<td>欢迎
<%=session.getAttribute("loginName") %>登录,
<a href="Exit">退出登录</a>
</td>
    </tr>
<tr>
<td>当前在线人数：<%=User.getUserCount() %>人</td>
</tr>
<tr>
<td>在线用户名单：
<select multiple="multiple" name="list" style="width:200px;height:100px;">
<%
for(int i=0;i<onlines.size();i++){
out.write("<option>"+(String)onlines.get(i)+"</option>");
}
	%>

</select>
</td>
</tr>
</table>


</center>
<%} %>
</body>
</html>