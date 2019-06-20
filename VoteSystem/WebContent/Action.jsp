<%@page import="servlet.Zhuce"%>
<%@page import="servlet.Information"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="zy" class="servlet.Information" scope="request"></jsp:useBean>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>确认页面</title>
</head>
<body>
<%
String name=request.getParameter("name");
String username=new String(name.getBytes("UTF-8"),"UTF-8");
if(username.equals("")){%>
<jsp:forward page="zhuce.jsp"></jsp:forward>
<%
}
String sex=request.getParameter("sex");
String education=request.getParameter("education");
String xl=new String(education.getBytes("UTF-8"),"UTF-8");
String occupation=request.getParameter("occupation");
String zhiye=new String(occupation.getBytes("UTF-8"),"UTF-8");
String []aihao=request.getParameterValues("specialty");
String national =request.getParameter("national");
String province =request.getParameter("province");
String city =request.getParameter("city");
String nation =national+" "+province+" "+city;
request.setAttribute("nation",nation);
String a=" ";
if(aihao!=null)
for(int i=0;i<aihao.length;i++)
{
	a+=aihao[i]+" ";
}
session.setAttribute("sp",a );
%>

<jsp:setProperty property="name" name="zy" value="<%=username%>"/>
<jsp:setProperty property="sex" name="zy" value="<%=zy.Issex(sex)%>"/>
<jsp:setProperty property="education" name="zy" value="<%=xl %>"/>
<jsp:setProperty property="occupation" name="zy" value="<%=zhiye%>"/>
<jsp:setProperty property="aihao" name="zy" value="<%=a%>"/>

<!-- 姓名：<jsp:getProperty property="name" name="zy"/>
<br>
性别：<jsp:getProperty property="sex" name="zy"/><br>
学历：<jsp:getProperty property="education" name="zy" /><br>
职业：<jsp:getProperty property="occupation" name="zy"/><br>
特长：<jsp:getProperty property="aihao" name="zy"/><br>
国籍：${nation}<br> -->
<jsp:forward page="账号密码设置.jsp"></jsp:forward>
</body>
</html>