<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
	
	
</script>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<form action="AddressServlet?temp=list&tt=shop" method="post">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${shopMap }" var="mymap">
				<tr id="product_id_0" class="product">
					<td class="thumb"><img src="images/product/${mymap.value.filename }" width="56" height="56" /><a href="ProductViewServlet?pro=${mymap.value.pid }">${mymap.value.pname }</a></td>
					<td class="price" id="price_id_0">
						<span id="mintotal">￥</span>
						<input id="danjia" type="hidden" value="${mymap.value.price }" />
					</td>
					<td class="number">
                        <span name="del">-</span>
                        <input id="number_id_0" type="text" name="number" value=" ${mymap.key.quantity }" />
                        <span name="add">+</span>
					</td>
					
					<td class="delete"><a href="javascript:void(0)">删除</a></td>
					<input id="pid" type="hidden" value="${mymap.key.pid }">
					<input id="stock" type="hidden" value="${mymap.value.stock }">
				</tr>
				</c:forEach>	
			</table>
            <div class="total"><span id="total">总计：￥0</span></div>
			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
	
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
