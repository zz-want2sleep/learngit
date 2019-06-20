<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>managerListHistoryProject</title>	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=gb2312">    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    <style type="text/css"><!--.STYLE1 {font-size: 12px}--> </style>
</head>  
  <body bgcolor="white">
	 <table bgcolor="#F0F8FC" width="800" height="100%" align="center" cellspacing="0" border="1">
	   <tr><td width="100%"  height="10%"><center><font size="+3" color="blue" face="宋体,楷体_utf-8"><b><i>网络投票选举系统</i></b></font></center></td></tr>
	   <tr><td height="4%"> <font face="webdings" color="#FF3300">1</font> <a href="ManagerListProjectServlet?method=listProject" ><font size="2" color="black">项目管理</font></a>
	        <font face="webdings" color="#FF3300">2</font><a href="管理员管理界面.jsp"><font size="2" color="black">用户管理</font></a>
	        <font face="webdings" color="#FF3300">3</font><a href="ManagerListVoterServlet?method=listVoter"><font size="2" color="black">参选人管理</font></a>
			<font face="webdings" color="#FF3300">4</font><a href="管理员登录.jsp" target="_self"><font size="2" color="black">重新登录</font></a>
			<font face="webdings" color="#FF3300">5</font><a href="Exit" target="_self"><font size="2" color="black">退出</font></a> </td> </tr>
	   <tr><td valign="top"> <br/><br/>
<table width="800" height="244" border="1" align="center" cellpadding="0" cellspacing="0"  bgcolor="d5effe"> <tr ><th height="47" colspan="9" align="center">项目浏览</th> </tr>
  <tr>
    <td width="10%" height="43" align="center">项目号</td>
    <td width="10%" align="center">可选人数</td>
    <td width="20%" align="center">项目名称</td>
    <td width="30%" align="center" >项目简介</td>
    <td width="10%" align="center">option</td>
  </tr>
  <c:forEach var="project" items="${list}"> 
<tr><td>${project.proId}</td>
<td>${project.proNumber}</td>
<td>${project.proName}</td>
<td>${project.proShow}</td>
<td><a href="ManagerListProjectServlet?method=startProject&proName=${project.proName}">恢复项目</a></td>  </tr>  </c:forEach>
</table>
<a href="ManagerListProjectServlet?method=listProject">返回上一页</a>
 </td></tr><tr><td height="4%"><center><font size="-1" color="blue" face="arial"><b>欢迎使用网络投票选举系统</b></font></center></td></tr>
</table>
</body>
</html>