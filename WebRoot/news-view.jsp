<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div id="position" class="wrap">
	您现在的位置：<a href="index.html">易买网</a> &gt; 阅读新闻
</div>
<div id="main" class="wrap">
	<div class="lefter">
	<jsp:include page="left.jsp"></jsp:include>
	</div>
</div>
	<div id="news" class="right-main">
		<h1>${news.title }</h1>
		<div class="content">
			${news.content }
		</div>
	</div>
	<div class="clear"></div>
	<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
