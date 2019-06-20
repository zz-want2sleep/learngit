<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>My JSP 'add.jsp' starting page</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--<link rel="stylesheet" type="text/css" href="styles.css">-->
  </head>  
  <body bgcolor="silver" >
	 <table bgcolor="#F0F8FC" width="800" height="100%" align="center" cellspacing="0" border="1">
	   <tr><td width="100%"  height="10%"><center><font size="+3" color="blue" face="宋体,楷体_UTF-8"><b><i>网络投票选举系统</i></b></font></center></td></tr>
	   <tr><td height="4%">			<font face="webdings" color="#FF3300">4</font><a href="用户登录.jsp" target="_self"><font size="2" color="black">重新登录</font></a>
			<font face="webdings" color="#FF3300">4</font><a href="Exit" target="_self"><font size="2" color="black">退出</font></a></td></tr>
	   <tr><td valign="top">   <br/><br/>
		   <form action="ManagerListProjectServlet?method=addProject" method="post">
	       <table  width="90%" border="1" cellspacing="0" align="center" cellpadding="4"  bgcolor="d5effe">
		   <tr bgcolor="#20a8f0"><td colspan="2" align="center" height="30"><font size="2" color="white"><b>新建选举项目</b></font></td></tr>
	       <tr><td width="30%" align="right"><font size="2"><b>项目号</b></font></td><td><input type="text" size="30" maxlength="30" name="id"/></td></tr>
	       <tr><td width="30%" align="right"><font size="2"><b>可选人数</b></font></td><td><input type="text" size="30" maxlength="30" name="number"/></td></tr>
	       <tr><td width="30%" align="right"><font size="2"><b>项目名称</b></font></td><td><input type="text" size="30" maxlength="30" name="name"/></td></tr>
		   <tr><td height="30" align="right"><font size="2"><b>项目简介</b></font></td><td><textarea cols="30" rows="3" name="show"></textarea></td></tr>
		   <tr>
		   <td colspan="2" height="30" align="center"><input type="submit" value="提交"/>&nbsp;
		   <input type="reset" value="重填"/> </td></tr>
		   <tr><td width="30%" align="right"><a href="managerListVoter.jsp">返回</a></td><td></td></tr>	
		   </table>
		   </form>  </td></tr>
	  <tr><td height="4%"><center><font size="-1" color="blue" face="arial"><b>欢迎使用网络投票选举系统</b></font></center></td></tr>
	 </table>
  </body>
</html>