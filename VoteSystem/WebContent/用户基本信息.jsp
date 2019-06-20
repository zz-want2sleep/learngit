<%@page import="java.sql.ResultSet"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户基本信息</title>
<link rel="stylesheet" href="table.css" type="text/css"/>
<link rel="stylesheet" href="index.css" type="text/css"/>
</head>
<script type="text/javascript">

function GetXHR(){
	var xhr=null;
	var n=document.getElementById("name").value;
	if(XMLHttpRequest){
		xhr=new XMLHttpRequest();
	}else{
		xhr= new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
			document.getElementById("User").innerHTML=xhr.responseText;
		}
	}
	xhr.open("POST","SelectName",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send("name="+n);
	if(n==""||n==null){
		alert("姓名不能为空!");
		document.getElementById("ctr").setAttribute("disabled",true);
	}else
		{document.getElementById("ctr").removeAttribute("disabled");}
}
window.onload=function(){
	if(window.XMLHttpRequest){
		xhr=new XMLHttpRequest();
	}else{
		xhr= new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
			xmlDoc=xhr.responseXML;
			var x=xmlDoc.getElementsByTagName("national");
			for(var i=0;i<x.length;i++){
			var str =x[i].getAttribute("name");
			var o=document.createElement("option");
			o.appendChild(document.createTextNode(str));
            document.getElementById("national").appendChild(o);
			}
			var provincenodes=x[0].getElementsByTagName("province");
			var dnodes=provincenodes[0].getElementsByTagName("city");
			
			for(var i=0;i<provincenodes.length;i++){
				
				var str =provincenodes[i].getAttribute("name");
				var o = document.createElement("option");
				o.appendChild(document.createTextNode(str));
	            document.getElementById("province").appendChild(o);			
			}
		
			for(var i=0;i<dnodes.length;i++){
				var str =dnodes[i].childNodes[0].data;//dnodes[i].childNodes[0].data;
				var o=document.createElement("option");
				o.appendChild(document.createTextNode(str));
	            document.getElementById("city").appendChild(o);			
			}
			}
		}
	xhr.open("POST","xml/nation.xml",true);
	xhr.send(null);
}

function changeNational(){
	if(XMLHttpRequest){
		xhr=new XMLHttpRequest();
	}else{
		xhr= new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
		document.getElementById("province").innerHTML="";
		xmlDoc=xhr.responseXML;
		var index=document.getElementById("national").selectedIndex;
		var x=xmlDoc.getElementsByTagName("national");
		var provincenodes=x[index].getElementsByTagName("province");
		for(var i=0;i<provincenodes.length;i++){
		var str=provincenodes[i].getAttribute("name");
		var o =document.createElement("option");
		o.appendChild(document.createTextNode(str));
		document.getElementById("province").appendChild(o);
		}
		document.getElementById("city").innerHTML="";
		var index1=document.getElementById("province").selectedIndex;
		var x1=x[index].getElementsByTagName("province");
		var citynodes=x1[index1].getElementsByTagName("city");
		for(var i=0;i<citynodes.length;i++){
			var str=citynodes[i].childNodes[0].data;
			var o =document.createElement("option");
			o.appendChild(document.createTextNode(str));
			document.getElementById("city").appendChild(o);
			}
		}
	}
	xhr.open("POST","xml/nation.xml",true);
	xhr.send(null);
}

function changeProvince(){
	if(XMLHttpRequest){
		xhr=new XMLHttpRequest();
	}else{
		xhr= new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
		document.getElementById("city").innerHTML="";
		xmlDoc=xhr.responseXML;
		var index=document.getElementById("province").selectedIndex;
		var index1=document.getElementById("national").selectedIndex;
		var y=xmlDoc.getElementsByTagName("national");
		var x=y[index1].getElementsByTagName("province");
		var citynodes=x[index].getElementsByTagName("city");
		for(var i=0;i<citynodes.length;i++){
		var str=citynodes[i].childNodes[0].data;
		var o =document.createElement("option");
		o.appendChild(document.createTextNode(str));
		document.getElementById("city").appendChild(o);
		}
		}
	}
	xhr.open("POST","xml/nation.xml",true);
	xhr.send(null);
}
</script>
<body>
<%
//ResultSet rSet=(ResultSet)request.getAttribute("rs0");
ResultSet rSet=(ResultSet)session.getAttribute("rs0");
String specialty=(String)session.getAttribute("sp");
rSet.absolute(1);
%>
<div id="header">
<div id="nav1"> 
<ul>
<li class="borderleft"><a href="UserViewServlet">投票系统</a></li>
 <li class="borderleft"><a >用户基本信息</a></li>
  <li class="borderleft"><a href="LoginServlet">用户账号信息</a></li>
 <li><a href="管理员登录.jsp" >管理员登录</a></li>
 <li><a href="Home.jsp" >主页面</a></li>

</ul>
</div>
</div>

<div id="bd" style="position:fixed;
            left:100px;
            top:100px;">
<form action="EditServlet1" method="get">
<table  class="gridtable">
   
<%do{ %>
<tr>
<td align="center" colspan="3">用户信息
<input type="hidden" name="id" value="<%= rSet.getString("id") %>"/></td>
</tr>
<tr>
<td> 性名：  </td>
<td colspan="2"><input type="text" name="name" value="<%=rSet.getString("name")%>"/>   </td>
</tr>
<tr>
<td> 性别：  </td>
<% if(rSet.getString("sex").equals("男")){ %>
<td colspan="2">
<input type="radio" name="sex" value="男" checked=checked/>男
<input type="radio" name="sex" value="女" />女
   </td>
   <%}else{ %>
   <td colspan="2">
<input type="radio" name="sex" value="man"/>男
<input type="radio" name="sex" value="women" checked=checked/>女
<%} %>
</tr>
<tr>
<td> 学历：  </td>
<%if(rSet.getString("education").equals("本科")) {%>
<td colspan="2">
<select name="education">
<option  value="本科" selected="selected">本科</option>
<option  value="专科">专科</option>
<option  value="高中">高中</option>
<option  value="初中">初中</option>
<option  value="小学">小学</option>
<option  value="文盲">文盲</option>
</select>  </td>
<%} %>
<%if(rSet.getString("education").equals("专科")) {%>
<td colspan="2">
<select name="education">
<option  value="本科" >本科</option>
<option  value="专科" selected="selected">专科</option>
<option  value="高中">高中</option>
<option  value="初中">初中</option>
<option  value="小学">小学</option>
<option  value="文盲">文盲</option>
</select>  </td>
<%} %>
<%if(rSet.getString("education").equals("高中")) {%>
<td colspan="2">
<select name="education">
<option  value="本科" >本科</option>
<option  value="专科">专科</option>
<option  value="高中" selected="selected">高中</option>
<option  value="初中">初中</option>
<option  value="小学">小学</option>
<option  value="文盲">文盲</option>
</select>  </td>
<%} %>
<%if(rSet.getString("education").equals("初中")) {%>
<td colspan="2">
<select name="education">
<option  value="本科">本科</option>
<option  value="专科">专科</option>
<option  value="高中">高中</option>
<option  value="初中" selected="selected">初中</option>
<option  value="小学">小学</option>
<option  value="文盲">文盲</option>
</select>  </td>
<%} %>
<%if(rSet.getString("education").equals("小学")) {%>
<td colspan="2">
<select name="education">
<option  value="本科" >本科</option>
<option  value="专科">专科</option>
<option  value="高中">高中</option>
<option  value="初中">初中</option>
<option  value="小学" selected="selected">小学</option>
<option  value="文盲">文盲</option>
</select>  </td>
<%} %>
<%if(rSet.getString("education").equals("文盲")) {%>
<td colspan="2">
<select name="education">
<option  value="本科" >本科</option>
<option  value="专科">专科</option>
<option  value="高中">高中</option>
<option  value="初中">初中</option>
<option  value="小学" >小学</option>
<option  value="文盲" selected="selected">文盲</option>
</select>  </td>
<%} %>
</tr>
<tr>
<td> 职业：  </td>
<td colspan="2">
<input type="text" name="occupation" value="<%=rSet.getString("occupation")%>"/>
   </td>
</tr>
<tr>
<td> 特长：  </td>

<%if(specialty.equals(" 唱歌 游泳  跑步 ")){ %>
<td colspan="2">
<input type="checkbox" name="specialty" value="唱歌" checked=checked/>唱歌
<input type="checkbox" name="specialty" value="游泳" checked=checked/>游泳
<input type="checkbox" name="specialty" value="跑步" checked=checked/>跑步
   </td>
   <%} %>
<%if(specialty.equals(" 唱歌 游泳 ")||specialty.equals(" 游泳 唱歌 ")){ %>
<td colspan="2">
<input type="checkbox" name="specialty" value="唱歌" checked=checked/>唱歌
<input type="checkbox" name="specialty" value="游泳" checked=checked/>游泳
<input type="checkbox" name="specialty" value="跑步"/>跑步
   </td>
   <%} %>
   <%if(specialty.equals(" 唱歌 跑步 ")||specialty.equals(" 跑步 唱歌 ")){ %>
<td colspan="2">
<input type="checkbox" name="specialty" value="唱歌" checked=checked/>唱歌
<input type="checkbox" name="specialty" value="游泳" />游泳
<input type="checkbox" name="specialty" value="跑步" checked=checked/>跑步
   </td>
   <%} %>
   <%if(specialty.equals(" 跑步 游泳 ")||specialty.equals(" 游泳 跑步 ")){ %>
<td colspan="2">
<input type="checkbox" name="specialty" value="唱歌" />唱歌
<input type="checkbox" name="specialty" value="游泳" checked=checked/>游泳
<input type="checkbox" name="specialty" value="跑步" checked=checked/>跑步
   </td>
   <%} %>
   <%if(specialty.equals(" 唱歌 ")){ %>
<td colspan="2">
<input type="checkbox" name="specialty" value="唱歌" checked=checked/>唱歌
<input type="checkbox" name="specialty" value="游泳" />游泳
<input type="checkbox" name="specialty" value="跑步"/>跑步
   </td>
   <%} %>
   <%if(specialty.equals(" 游泳 ")){ %>
<td colspan="2">
<input type="checkbox" name="specialty" value="唱歌"/>唱歌
<input type="checkbox" name="specialty" value="游泳" checked=checked/>游泳
<input type="checkbox" name="specialty" value="跑步"/>跑步
   </td>
   <%} %>
   <%if(specialty.equals(" 跑步 ")){ %>
<td colspan="2">
<input type="checkbox" name="specialty" value="唱歌" />唱歌
<input type="checkbox" name="specialty" value="游泳" />游泳
<input type="checkbox" name="specialty" value="跑步" checked=checked/>跑步
   </td>
<%} }while(rSet.next());%>
</tr>
<tr>
<td>国籍：</td>
<td colspan="2">
 <%
 rSet.absolute(1);
 do{out.print("(");%>
<%= rSet.getString("nation") %>
 <%out.print(")初始地址！<br>");}while(rSet.next()); %>
<select id="national" onchange="changeNational()" name="national"></select>
<select id="province" onchange="changeProvince()" name="province"></select>
<select id="city" name="city"></select>
</td>
</tr>
<tr>
<td colspan="3" align="center">

<input type="submit" value="修改" onclick="return confirm('确认修改吗？');"/>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="重置"/>
</td>
</tr>

</table>
</form>
</div>
<div 
style="position:fixed;
height: 300px; width:500px;
overflow-x: auto;
 overflow-y: auto;
            left:500px;
            top:100px;">
<table   height="244" border="1" align="center" cellpadding="0" cellspacing="0"  bgcolor="d5effe">
  <tr ><th height="47" colspan="9" align="center">投票记录浏览</th></tr>
  <tr>
    <td width="15%" height="43" align="center">投票所选人编号</td>
    <td width="15%" align="center">投票次数</td>
    <td width="20%" align="center">投票项目</td>
    <td width="20%" align="center" >投票所选人姓名</td>
    <td width="20%" align="center" >最后一次投票时间</td>
  </tr>
  <c:forEach var="userrecoder" items="${list}"> 
  <tr>
    <td height="43" align="center">${userrecoder.rId}</td>
    <td align="center">${userrecoder.rIndex}</td>
    <td align="center">${userrecoder.rProject}</td>
    <td align="center">${userrecoder['rChooseName']}</td>
    <td align="center">${userrecoder['rTime']}</td>
    </tr>  </c:forEach>
   
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