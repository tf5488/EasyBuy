<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<c:if test="${empty pagebean.pagelist }">
	<script type="text/javascript">
		location.href="ManageNewsServlet?temp=list";
	</script>
</c:if>
<div id="header" class="wrap">
	<div id="logo"><a href="index.jsp"><img src="../images/logo.gif" /></a></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li class="current"><a href="news.jsp">新闻</a></li>
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
		<h2>新闻管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>新闻标题</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pagebean.pagelist }" var="news">
				<tr>
					<td class="first w4 c">${news.nid }</td>
					<td>${news.title }</td>
					<td class="w1 c"><a href="ManageNewsServlet?temp=modify&nid=${news.nid }">修改</a> <a class="manageDel" id="news" href="javascript:void(0)">删除</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="clear"></div>
    <div class="pager">
				<ul class="clearfix">
					<li><a href="ManageNewsServlet?temp=list&pno=1" >首页</a></li>
					<c:if test="${pagebean.pageno > 2 }"><li>...</li></c:if>
					<c:if test="${pagebean.pageno > 1 }">
					<li><a href="ManageNewsServlet?temp=list&pno=${pagebean.pageno-1 }" >${pagebean.pageno-1 }</a></li>
					</c:if>
					<li class="current">${pagebean.pageno }</li>
                    <c:if test="${(pagebean.pagetotal - pagebean.pageno) > 0 }">
                    <li><a href="ManageNewsServlet?temp=list&pno=${pagebean.pageno+1 }">${pagebean.pageno+1 }</a></li>
                    </c:if>
                    <c:if test="${(pagebean.pagetotal - pagebean.pageno) > 1 }">
                    <li>...</li>
                    </c:if>
					<li>
					<a href="ManageNewsServlet?temp=list&pno=${pagebean.pagetotal }" >尾页</a>
					</li>
				</ul>
			</div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

