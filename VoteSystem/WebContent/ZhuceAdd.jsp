<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增添信息</title>
<link rel="stylesheet" href="table.css" type="text/css"/>
<link rel="stylesheet" href="index.css" type="text/css"/>
</head>
<body>
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

<div id="header">
<div id="nav1"> 
<ul>
 <li class="borderleft"><a href="用户登录.jsp" >用户登录</a></li>
 <li><a href="管理员登录.jsp" >管理员登录</a></li>
 <li><a href="Home.jsp" >主页面</a></li>

</ul>
</div>
</div>
<div id="bd">
<form action="AddServlet" method="get">
<table  class="gridtable">
<tr>
<td align="center" colspan="3">添加信息</td>
</tr>
<tr>
<td> 性名：  </td>
<td colspan="2"><input type="text" name="name" id="name" onblur="GetXHR()"/><span id="User"></span></td>
</tr>
<tr>
<td> 性别：  </td>
<td colspan="2">
<input type="radio" name="sex" value="男" checked=checked/>男
<input type="radio" name="sex" value="女" />女
   </td>
</tr>
<tr>
<td> 学历：  </td>
<td colspan="2">
<select name="education">
<option  value="本科">本科</option>
<option  value="专科">专科</option>
<option  value="高中">高中</option>
<option  value="初中">初中</option>
<option  value="小学">小学</option>
<option  value="文盲">文盲</option>
</select>  </td>
</tr>
<tr>
<td> 职业：  </td>
<td colspan="2">
<input type="text" name="occupation"/>
   </td>
</tr>
<tr>
<td> 特长：  </td>
<td colspan="2">
<input type="checkbox" name="specialty" value="唱歌"/>唱歌
<input type="checkbox" name="specialty" value="游泳"/>游泳
<input type="checkbox" name="specialty" value="跑步"/>跑步
   </td>
</tr>

<tr>
<td> 国籍：  </td>
<td colspan="2"><select id="national" onchange="changeNational()" name="national"></select>
<select id="province" onchange="changeProvince()" name="province"></select>
<select id="city" name="city"></select>
 </td>
</tr>
<tr>
<td colspan="3" align="center">

<input type="submit" value="添加" id="ctr"/>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="重置"/>
</td>
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