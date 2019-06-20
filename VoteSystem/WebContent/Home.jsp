<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
 <title>主页面</title>
 <style type="text/css">
 *{margin:0; padding: 0;}
 body { background:#444;}
#navcont { background: #fff; width: 100%;position:fixed;top:0px;}
#nav { font-family: helvetica; position:relative; width:888
px; height:56px; font-size:14px; color:#999; 
margin: 0 auto; }
 #nav ul { list-style-type:none; }
#nav ul li { float:left; position: relative;}
 #nav ul li a { border-right:1px solid #e9e9e9; padding:20px; display:block; text-decoration:none; text-
align:center; color:#999;}
#nav ul li a:hover {background: #12aeef url(//files.jb51.net/demoimg/200912/shadow.png) repeat-x;; 
color:#fff;} 
 #nav ul li ul {display: none;}
 #nav ul li:hover ul {display: block; position: absolute; top:56px; min-width:190px; left:0;} 
 #nav ul li:hover ul li a {display:block; background:#12aeef; color:#ffffff; width: 110px; text-align: 
center; border-bottom: 1px solid #f2f2f2; border-right: none;}
 #nav ul li:hover ul li a:hover { background:#6dc7ec; color:#ffffff; }
 .borderleft {border-left: 1px solid #e9e9e9;}
 .top { border-top: 1px solid #f2f2f2;}
 /*  This piece of code is for a third level drop down menu and is not included in this tutorial  #nav ul 
li:hover ul li ul {display:none;}
 #nav ul li:hover ul li:hover ul {display:block; position: absolute; top:-1px; left: 151px;}*/
 /* Ignore this last piece of code */
 .threestyles {
 color:orange;
 overflow:hidden;
 display:table;
  margin: 0px auto;
  border: 2px solid #444;
  margin-top: 60px;
 } 
 #footer{ background: #fff; width: 100%;position:fixed;bottom:0px;text-align:center;font-size:14px; color:#999;}
 </style>
</head>
<body>
<div id="navcont"> 
<div id="nav"> 
<ul>
 <li class="borderleft"><a href="Home.jsp" target="_blank">主页面</a></li>
 <li><a href="用户登录.jsp">登录</a></li>
 <li><a href="用户登录.jsp">用户</a>
  <ul>
   <li class="top"><a href="用户登录.jsp">登录</a></li>
   <li><a href="zhuce.jsp" >注册</a></li>
   <li><a href="确认用户.jsp" >密码修改</a></li>
  </ul>
 </li> 
 <li><a href="管理员登录.jsp" target="_blank">管理员</a>
   <ul>
    <li class="top"><a href="管理员登录.jsp">登录</a></li>
    
    <li><a>help</a></li>
   </ul>
 </li>
 <li>
 <% if(session.getAttribute("loginName")==null){ %>
<a class="yh"  href="用户登录.jsp">游客你好，欢迎光临！</a>
<%}else{ %>
<a class="yh" href="LoginServlet"><%=(String)session.getAttribute("loginName") %>你好，欢迎光临！</a>
<%} %>
 </li>
 <li>
 <a class="yh" href="Exit">退出登录</a>
 </li>
</ul>
</div>
</div >
<div class="threestyles" ><h1><br>${message} </h1></div>


<div class="threestyles" ><img  alt="我很酷！" style="height:auto;" 
src="imag图片/11.jpg" />
</div>
<div class="threestyles"  style="float:left;margin-left:60px;"><img  alt="我很酷！" style="height:auto;" 
src="imag图片/1.jpg" />
</div>
<div class="threestyles" style="float:right;margin-right:60px;"><img  alt="我很酷！" style="height:auto;" 
src="imag图片/2.jpg" />
</div>
<div class="threestyles" style="float:center;"><img  alt="我很酷！" style="height:auto;" 
src="imag图片/8.jpg" />
</div>
<div class="threestyles" style="float:bottom;margin-bottom:60px;"><img  alt="我很酷！" style="height:auto;" 
src="imag图片/3.jpg" />
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