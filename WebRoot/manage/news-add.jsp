<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><a href="index.jsp"><img src="../images/logo.gif" /></a></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li><a href="news.jsp">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员 ${user.username }您好，今天是
		<jsp:useBean id="now" class="java.util.Date" scope="page"/>
		<fmt:formatDate value="${now}" pattern="yyyy年MM月dd日" />，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<jsp:include page="left.jsp"></jsp:include>
	</div>
	<div class="main">
		<h2>添加新闻</h2>
		<div class="manage">
			<form id="newsAdd" action="ManageNewsServlet?temp=add" method="post">
				<table class="form">
					<tr>
						<td class="field">新闻标题：</td>
						<td><input type="text" class="text" name="title" value="" /><span></span></td>
					</tr>
					<tr>
						<td class="field">新闻内容：</td>
						<td><textarea class="text" name="content"></textarea><span></span></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="添加" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
    
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

