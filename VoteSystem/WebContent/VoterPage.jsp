<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>managerListProject</title>	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=utf-8">    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    <style type="text/css"><!--.STYLE1 {font-size: 12px}--></style>
</head> 
    <body bgcolor="silver" >
	 <table bgcolor="#F0F8FC" width="800" height="100%" align="center" cellspacing="0" border="1">
	   <tr><td width="100%"  height="10%"><center><font size="+3" color="blue" face="宋体,楷体_UTF-8"><b><i>网络投票选举系统</i></b></font></center></td></tr>
	   <tr><td height="4%">			<font face="webdings" color="#FF3300">4</font><a href="用户登录.jsp" target="_self"><font size="2" color="black">重新登录</font></a>
			<font face="webdings" color="#FF3300">4</font><a href="Exit" target="_self"><font size="2" color="black">退出</font></a></td></tr>
	   <tr><td valign="top">   <br/><br/>
		   <form action="VoterServlet?method=voter1" method="post">
	       <table  width="90%" border="1" cellspacing="0" align="center" cellpadding="4"  bgcolor="d5effe">
	       <tr>
	       <th width="20%">参选人Id</th>
	       <th width="10%">姓名</th>
           <th width="10%">性别</th>
           <th width="10%">年龄</th>
           <th width="15%">参选项目</th>
           <th width="35%">宣言</th>
	       </tr>
		   <c:forEach var="voter" items="${list}"> 
		   <c:set var="id" scope="page" value="${voter.voterId}"/>
		   <c:set var="proName" scope="session" value="${voter.voterProject}"/>
           <tr><td width="20%"><input type="radio" name="voter" value='<c:out value="${id}"/>'/>${id}</td>
           <td width="10%">${voter.voterName}</td>
           <td width="10%">${voter.voterSex}</td>
           <td width="10%">${voter.voterAge}</td>
           <td width="10%">${voter.voterProject}</td>
           <td width="40%">${voter.voterWord}</td>
  </tr>  </c:forEach>
		   <tr>
		   <td colspan="7" height="30" align="center"><input type="submit" value="投票"/>&nbsp;
		   <input type="reset" value="重填"/> </td></tr>
		   <tr><td width="30%" align="left"><a href="UserViewServlet">返回</a></td><td colspan="5" width="30%" align="left"><a href="Vote1">查看投票情况!(饼图)</a></td></tr>	
		   </table>
		   </form>  </td></tr>
	   <tr><td height="4%" ><center><font size="-1" color="blue" face="arial"><b>欢迎使用网络投票选举系统</b></font></center></td></tr>
</body>
</html>