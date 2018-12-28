<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script type="text/javascript">
	var msg = "${msg}";
	if(msg != null && msg != ""){
		alert(msg);
	}
</script>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; <a href="ProductListServlet?cid=1">图书音像</a> &gt; 图书
</div>
<div id="main" class="wrap">
	<div class="lefter">
	<jsp:include page="left.jsp"></jsp:include>
	</div>
	<div id="product" class="main">
		<h1>${product.pname }</h1>
		<div class="infos">
			<div class="thumb"><img src="images/product/${product.filename }" width="198" height="198" /></div>
			<div class="buy">
				商城价：<span class="price">￥${product.price }</span><br />
				库　存：
				<c:choose>
				<c:when test="${product.stock > 0 }">库存:<strong>${product.stock }</strong></c:when>
				<c:otherwise>缺货</c:otherwise>
				</c:choose>
			  <div class="button">
			  <input type="button" name="button" value="" onclick="location.href = 'AddressServlet?temp=list&tt=pro&pid=${product.pid }'" />
			  <a href="ShoppServlet?temp=add&pid=${product.pid }">放入购物车</a></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				${product.description }<br />
				......<br />
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
