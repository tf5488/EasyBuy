<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
<script type="text/javascript" >
	$(function(){
		
	});
</script>
</head>
<body>
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
	您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<jsp:include page="left.jsp"></jsp:include>
	</div>
	<div class="main">
		<h2>修改用户</h2>
		<div class="manage">
			<form name="usermodify" id="usermodify" action="ManageIndexServlet?temp=change&uid=${user.userId }" method="post">
				<table class="form">
					<tr>
						<td class="field">用户名(*)：</td>
						<td><input type="text" class="text" name="userName" value="${user.username }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">真实姓名(*)：</td>
						<td><input type="text" class="text" name="name" value="${user.nickName }" /></td>
					</tr>
					<tr>
						<td class="field">登录密码(*)：</td>
						<td><input type="text" class="text" name="passWord" value="${user.userPwd }" /></td>
					</tr>
                    <tr>
						<td class="field">确认密码(*)：</td>
						<td><input type="text" class="text" name="passWord" value="${user.userPwd }" />
						<span id="error"></span>
						</td>
					</tr>
					<tr>
						<td class="field">性别(*)：</td>
						<td>
						<c:if test="${user.userSex == 1 }">
						<input type="radio" name="sex" value="1" checked="checked" />男 
						<input type="radio" name="sex" value="0" />女
						</c:if>
						<c:if test="${user.userSex == 0 }">
						<input type="radio" name="sex" value="1" />男 
						<input type="radio" name="sex" value="0" checked="checked" />女
						</c:if>
						</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<c:set value="${fn:split(user.birthday,'-') }" var="times"></c:set>
						<td>
							<select name="birthyear">
								<c:forEach var="i" begin="1" end="69">
								<c:choose>
									<c:when test="${i+1949 == times[0] }">
										<option value="${i+1949 }" selected="selected">${i+1949 }</option>
									</c:when>
									<c:otherwise>
										<option value="${i+1949 }">${i+1949 }</option>
									</c:otherwise>
								</c:choose>
								
								</c:forEach>
							</select>年
							<select name="birthmonth">
								<c:forEach var="i" begin="1" end="12">
									<c:choose>
									<c:when test="${i == times[1] }">
										<option value="${i }" selected="selected">${i }</option>
									</c:when>
									<c:otherwise>
										<option value="${i }">${i }</option>
									</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>月
							<select name="birthday">
								<c:forEach var="i" begin="1" end="31">
									<c:choose>
									<c:when test="${i == times[2] }">
										<option value="${i }" selected="selected">${i }</option>
									</c:when>
									<c:otherwise>
										<option value="${i }">${i }</option>
									</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>日
						</td>
					</tr>
					<tr>
						<td class="field">手机(*)：</td>
						<td><input type="text" class="text" name="mobile" value="${user.mobile }" /></td>
					</tr>
					<tr>
						<td class="field">地址(*)：</td>
						<td><input type="text" class="text" name="address" value="${user.address }" /></td>
					</tr>
					<c:if test="${user.username != 'admin'}">
					<tr>
						<td class="field">权限(*)：</td>
						<td><select name="status">
							<option value="0" <c:if test="${user.status == 0 }">selected="selected"</c:if>>普通用户</option>
							<option value="1" <c:if test="${user.status == 1 }">selected="selected"</c:if>>管理员</option>
						</select></td>
					</tr>
					</c:if>					
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
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

