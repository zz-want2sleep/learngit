<%@page import="org.jfree.chart.labels.StandardPieSectionLabelGenerator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"   import="java.lang.Iterable"%>
<%@page import="java.util.List"  import="entity.Voter" import="java.util.ArrayList"%>
<%@page import="org.jfree.chart.plot.PiePlot"%>
<%@page import="java.awt.Font"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="org.jfree.data.general.DefaultPieDataset,org.jfree.chart.ChartFactory
,org.jfree.chart.JFreeChart,org.jfree.chart.servlet.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投票情况</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
      <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=utf-8">    
</head>
<body>
<%
DefaultPieDataset dpd = new DefaultPieDataset();
List<Voter> list=(List<Voter>)request.getAttribute("list");
for(int i=0;i<list.size();i++){
	Voter voter=(Voter)list.get(i);
	dpd.setValue(voter.getVoterName()+"="+voter.getVoterIndex()+"票", voter.getVoterIndex());
}

   
    
    JFreeChart chart = ChartFactory.createPieChart("投票情况",dpd, true, true, false);
    Font font =new Font("宋体",Font.BOLD,20);
    chart.getTitle().setFont(font);
    PiePlot piePlot =(PiePlot)chart.getPlot();
    piePlot.setLabelFont(new Font("宋体", Font.PLAIN, 15));
    chart.getLegend().setItemFont(font);
    DecimalFormat df=new DecimalFormat("0.00%");
    NumberFormat nf=NumberFormat.getNumberInstance();
    StandardPieSectionLabelGenerator spl=new StandardPieSectionLabelGenerator("{0} {2}",nf,df);
    piePlot.setLabelGenerator(spl);
    String fileName = ServletUtilities.saveChartAsPNG(chart,800,600,session); 
    //ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）
    
    String url = request.getContextPath() + "/DisplayChart?filename=" + fileName;
    //根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致

%>
<img src="<%= url %>" width="800" height="600">
</body>
</html>