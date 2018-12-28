<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
<script type="text/javascript">
	var msg = "${msg}";
	if(msg != null && msg != ""){
		alert(msg);
	}

	$(function(){
		var pid = "${pro.pcid }";
		$("option").each(function(){
			var op = this.value;
			if(op == pid){
				$(this).attr("selected","selected");
			}
		});
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
			<li ><a href="user.jsp">用户</a></li>
			<li class="current"><a href="product.jsp">商品</a></li>
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
		<h2>修改商品</h2>
		<div class="manage">
			<form action="ManageUplondServlet" method="post" enctype="multipart/form-data">
				<table class="form">
					<tr>
						<td><input type="hidden" name="pid" value="${pro.pid }" style="position: fixed;"></td>
					</tr>
					<tr>
						<td class="field">商品名称(*)：</td>
						<td><input type="text" class="text" name="productName" value="${pro.pname }" /></td>
					</tr>
                    <tr>
						<td class="field">描述：</td>
						<td><input type="text" class="text" name="productDescription"  value="${pro.description }"/></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="parentId">
								<c:forEach items="${cgmap }" var="map">
									<option value="${map.key.cid }">${map.key.cname }</option>
									<c:forEach items="${map.value }" var="child" varStatus="index" >
										<c:if test="${fn:length(map.value) > index.count }">
											<option value="${child.cid }">├ ${child.cname }</option>
										</c:if>
										<c:if test="${fn:length(map.value) == index.count }">
											<option value="${child.cid }">└ ${child.cname }</option>
										</c:if>
									</c:forEach>
								</c:forEach>
							</select>
						</td>
					</tr>					
					<tr>
						<td class="field">商品价格(*)：</td>
						<td><input type="text" class="text tiny" name="productPrice"  value="${pro.price }"/>元</td>
					</tr>
					<tr>
						<td class="field">库存(*)：</td>
						<td><input type="text" class="text tiny" name="productStock"  value="${pro.stock }"/></td>
					</tr>
					<tr>
						<td class="field">商品图片：</td>
						<td><input type="file" id="filename" class="text" name="photo" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="确定" /></label> &nbsp;&nbsp;&nbsp;&nbsp; <input class="flie" type="button" value="图片预览"></td>
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
