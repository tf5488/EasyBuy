<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
		location.href="ManageIndexServlet?temp=list";
	</script>
</c:if>
<div id="header" class="wrap">
	<div id="logo"><a href="index.jsp"><img src="../images/logo.gif" /></a></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li class="current"><a href="user.jsp">用户</a></li>
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
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>用户名</th>
					<th>真实姓名</th>
					<th>性别</th>
					<th>Email</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pagebean.pagelist }" var="user">
				<tr>
					<td class="first w4 c">${user.username }</td>
					<td class="w1 c">${user.nickName }</td>
					<td class="w2 c">
						<c:choose>
							<c:when test="${user.userSex == 1 }">男</c:when>
							<c:when test="${user.userSex == 0 }">女</c:when>
						</c:choose>
					</td>
					<td> ${user.email }</td>
					<td class="w4 c"> ${user.mobile }</td>
					<td class="w1 c"><a href="ManageIndexServlet?temp=modify&uname=${user.username }">修改</a> 
					<c:if test="${user.status != 1 }">
					<a class="manageDel" id="user" href="javascript:void(0)">删除</a>
					</c:if>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="clear"></div>
     <div class="pager">
				<ul class="clearfix">
					<li><a href="ManageIndexServlet?temp=list&pno=1" >首页</a></li>
					<c:if test="${pagebean.pageno > 2 }"><li>...</li></c:if>
					<c:if test="${pagebean.pageno > 1 }">
					<li><a href="ManageIndexServlet?temp=list&pno=${pagebean.pageno-1 }" >${pagebean.pageno-1 }</a></li>
					</c:if>
					<li class="current">${pagebean.pageno }</li>
                    <c:if test="${(pagebean.pagetotal - pagebean.pageno) > 0 }">
                    <li><a href="ManageIndexServlet?temp=list&pno=${pagebean.pageno+1 }">${pagebean.pageno+1 }</a></li>
                    </c:if>
                    <c:if test="${(pagebean.pagetotal - pagebean.pageno) > 1 }">
                    <li>...</li>
                    </c:if>
					<li>
					<a href="ManageIndexServlet?temp=list&pno=${pagebean.pagetotal }" >尾页</a>
					</li>
				</ul>
	</div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

