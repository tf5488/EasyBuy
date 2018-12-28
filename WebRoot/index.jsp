<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

	$(function(){
		$.getJSON("IndexServlet?temp=news",function(ret){
			$(ret).each(function(k,v){
				if(k < 8){
					$("#newslist").append("<li><a href='NewsViewServlet?nid="+
							v.nid+"' target='_self' >"+v.title+"</a></li>");
				}
			});
		});
		$.getJSON("IndexServlet?temp=cook",function(ret){
			$(ret).each(function(){
				$("#cook").append("<dt><img src='images/product/"+
						this.filename+"' height='54' width='54' /></dt><dd><a href='ProductViewServlet?pro="+
						this.pid+"' target='_self'>"+
						this.pname+"</a><a href='ProductViewServlet?pro="+
						this.pid+"'></a></dd>");
			});
		});
	});
</script>
</head>
<c:if test="${empty pagebean.pagelist }">
	<script type="text/javascript">
		location.href="ProListServlet";
	</script>
</c:if>
<body>
	<div id="welcomeImage">
		<img width="100%" height="150" src="images/banner.jpg" alt="welcome">
	</div>
	<jsp:include page="top.jsp"></jsp:include>
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
			<div class="price-off">
				<div class="slideBox">
					<ul id="slideBox">
						<li><img src="images/product/banner_1.jpg" /></li>
						<li><img src="images/product/banner_2.jpg" /></li>
						<li><img src="images/product/banner_3.jpg" /></li>
						<li><img src="images/product/banner_4.jpg" /></li>
					</ul>
				</div>
				<h2>商品列表</h2>
				<ul class="product clearfix">
				<c:forEach items="${pagebean.pagelist }" var="pro" >
					<li>
						<dl>
							<dt><a href="ProductViewServlet?pro=${pro.pid }"  target="_self"><img src="images/product/${pro.filename }" /></a></dt>
							<dd class="title"><a href="ProductViewServlet?pro=${pro.pid }" target="_self">${pro.pname }</a></dd>
							<dd class="price">￥${pro.price }</dd>
						</dl>
					</li>
				</c:forEach>	
				</ul>
				[ ${pagebean.pageno } / ${pagebean.pagetotal } ]
				<a href="ProListServlet?pageno=1" >首页</a>
				<a href="ProListServlet?pageno=${pagebean.pageno-1 }" >上一页</a>
				<a href="ProListServlet?pageno=${pagebean.pageno+1 }" >下一页</a>
				<a href="ProListServlet?pageno=${pagebean.pagetotal }" >末页</a>
			</div>
			<div class="side">
				<div class="spacer"></div>
				<div class="news-list">
					<h4>新闻动态</h4>
					<ul id="newslist">
					</ul>
				</div>
			</div>
			<div class="spacer clear"></div>
		</div>
	</div>
	<div id="footer">Copyright &copy; 2013 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>

