<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="refresh" content="10;url=密码修改.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误操作</title>
</head>
<body>
</head>
<body>
<center><p><%=session.getAttribute("message") %><span style='font-family:"consolas";' id="sec" ></span>秒后自动跳转到登录界面</p>
<p><a href="密码修改.jsp">点击返回账号密码修改界面</a></p>
<script type="text/javascript">
var sec=10;
function cnt(){
	document.getElementById("sec").innerHTML=sec--;
	setTimeout("cnt()",1000);
}
window.onload=cnt();
</script>
</center>
</body>
</html>