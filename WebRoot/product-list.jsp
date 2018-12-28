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
$.getJSON("IndexServlet?temp=cook",function(ret){
	$(ret).each(function(){
		$("#cook").append("<dt><img src='images/product/"+
				this.filename+"' height='54' width='54' /></dt><dd><a href='ProductViewServlet?pro="+
				this.pid+"' target='_self'>"+
				this.pname+"</a><a href='ProductViewServlet?pro="+
				this.pid+"'></a></dd>");
	});
});
</script>
</head>

<body>
<jsp:include page="top.jsp"></jsp:include>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; <a href="ProductListServlet?cid=1">图书音像</a> &gt; 商品列表
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<jsp:include page="left.jsp"></jsp:include>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl id="cook" class="clearfix">
				
			</dl>
		</div>
	</div>
	<div class="main">
		<div class="product-list">
			<h2>全部商品</h2>			
			<div class="clear"></div>
			<ul class="product clearfix">
			
			<c:forEach items="${pagebean.pagelist }" var="pro">
				<li>
					<dl>
						<dt><a href="ProductViewServlet?pro=${pro.pid }" target="_self"><img src="images/product/${pro.filename }" /></a></dt>
						<dd class="title"><a href="ProductViewServlet?pro=${pro.pid }" target="_self">${pro.pname }</a></dd>
						<dd class="price">￥ ${pro.price } </dd>
					</dl>
				</li>
			</c:forEach>
				
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					<li><a href="ProductListServlet?cid=${cid }&pno=1" >首页</a></li>
					<c:if test="${pagebean.pageno > 2 }"><li>...</li></c:if>
					<c:if test="${pagebean.pageno > 1 }">
					<li><a href="ProductListServlet?cid=${cid }&pno=${pagebean.pageno-1 }" >${pagebean.pageno-1 }</a></li>
					</c:if>
					<li class="current">${pagebean.pageno }</li>
                    <c:if test="${(pagebean.pagetotal - pagebean.pageno) > 0 }">
                    <li><a href="ProductListServlet?cid=${cid }&pno=${pagebean.pageno+1 }">${pagebean.pageno+1 }</a></li>
                    </c:if>
                    <c:if test="${(pagebean.pagetotal - pagebean.pageno) > 1 }">
                    <li>...</li>
                    </c:if>
					<li>
					<a href="ProductListServlet?cid=${cid }&pno=${pagebean.pagetotal }" >尾页</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

