<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

function GetXHR(){

	var n=document.getElementById("loginName").value;
var p=document.getElementById("PWD");
	if(n==""||n==null){
		alert("姓名不能为空!");
		document.getElementById("ctr").setAttribute("disabled",true);
	}else
		{document.getElementById("ctr").removeAttribute("disabled");}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账号密码设置</title>
<link rel="stylesheet" href="index.css">
<link rel="stylesheet" href="table.css">
</head>
<body>
<div id="header">
<div id="nav1"> 
<ul>
<li><a href="Home.jsp" >主页面</a></li>
</ul>
</div>
</div>
<div class="bd2">
<form action="Login2" method="post">
<table  class="gridtable" 
			width="500px" height="400px">
			<tr>
				<td align="center" colspan="2">账号设置</td>
			</tr>
			<tr>
				<td align="center">账号名：</td>
				<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"
					name="loginName" id="loginName" onblur="GetXHR()"></td>
			</tr>
			<tr>
				<td align="center">密码：</td>
				<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;<input type="password"
					name="PWD" id="PWD"></td>
			</tr>
<tr>
<td colspan="2" align="center"><input id="ctr" type="submit" value="注册" ></td>

</tr>
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