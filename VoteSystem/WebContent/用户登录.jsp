
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 内部css样式表 用于设计页面的样式 -->
<link rel="stylesheet" href="index.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>总得有个名字</title>
<%
String username="";
String password="";
Cookie[] cookies=request.getCookies();
for(int i=0;i<cookies.length;i++){
	if("username".equals(cookies[i].getName())){
		username=cookies[i].getValue();
	}else if("password".equals(cookies[i].getName())){
		password=cookies[i].getValue();
	}
}
%>
</head>
<body>

<div id="header">
<div id="nav1"> 
<ul>
 <li class="borderleft"><a href="用户登录.jsp" >用户登录</a></li>
 <li><a href="管理员登录.jsp" >管理员登录</a></li>
<li><a href="zhuce.jsp" >注册</a></li>
 <li><a href="Home.jsp" >主页面</a></li>
</ul>
</div>
</div>
<div id="bd">
<!-- 建立表单 表单用于传输数据 是用来提交到下一页的，例如登录、注册等功能 -->
<form action="LoginServlet" method="post">
		<table align="center" border=1px cellpadding=0 cellspacing=0
			width="300px" height="200px">
			<tr>
				<td align="center" colspan="2">用户登录</td>
			</tr>
			<tr>
				<td align="center">用户名：</td>
				<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"
					name="uname" value="<%=username %>"></td>
			</tr>
			<tr>
				<td align="center">密&nbsp;&nbsp;&nbsp;&nbsp;码</td>
				<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;<input type="password"
					name="upwd" value="<%=password %>"></td>
			</tr>
			<tr>
				<td align="center" colspan="2">是否记住账号密码？<input type="checkbox" value="y" name="rem"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="登录"></td>
			</tr>
		</table>
	</form>
</div>
<div id="nav">
<p class="intro">
<b>你看起来好像我哦！</b>
</p>
<img alt="国产二哈" src="imag图片/dog.png" width="200" height="200">
</div>
<div id="xh">
<pre>
一小个子男人匆匆走进酒馆，高声问道：“外面那条大狗是谁的？”
话音刚落，一个身材魁梧的大块头男人站了起来：“怎么了？是我的。”
小个子男人面色凝重地说：“不好了！不好了！我家的小狗把你的大狗弄死了。”
大块头男人听了，哈哈大笑道：“别开玩笑了！
小狗能弄死我的大狗？
要知道我的大狗生性凶猛善斗，而且它从小就经过专门训练。”
“不是开玩笑，”
小个子男人皱着眉头说道：“是小狗把大狗的喉咙给卡住了！
</pre>
</div>
<div id="section">
<img class="gz" alt="狗子" src="imag图片/heihei.JPG" width="100" height="100" >
</div>
<!-- 超链接！加上target="_blank"显示超链接在新的页面 -->
<!--  <a href="zhuce.jsp" ><b>注册</b></a>新的页面 target="_blank" -->
<div id="footer" style="position:fixed;bottom:0;left:0;">
<p>
<pre>
     实验教学管理测试版！
   欢迎提出意见
  联系方式：xxx
</pre>
</p>
</div>
</body>
</html>
