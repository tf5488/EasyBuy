<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
<script type="text/javascript">
	$(function(){
		$("select[name='status']").change(function(){
			alert("aaa");
			// 获得订单号
			var oid = $("select[name='status']").parent().parent().find("th[name='oid']").attr("oid");
			// 获得状态码
			var tp = $("select[name='status'] option:selected").val();
			$.ajax({
				url:"ManageOrderServlet?temp=change",
				data:{"oid":oid,"tp":tp},
				type:"post",
				dataType:"text",
				success:function(ret){
					alert(ret);
					location.reload();
				}
			});
		});
		
		$(".list").each(function(k,v){
			var table = $(v).find("tr[id='body']");
			var total = 0;
			$.each(table,function(i,d){
				var price = $(d).find("td:eq(1)").text();
				var num = $(d).find("td:eq(2)").text();
				var cost = price*num;
				total = total + cost;
			});
			$.each(table,function(i,d){
				$(d).find(".w1").text("总计："+total);
			});
		});
		
	});
</script>
</head>
<body>
<c:if test="${empty pagebean.pagelist }">
	<script type="text/javascript">
		location.href="ManageOrderServlet?temp=list";
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
			<li class="current"><a href="order.jsp">订单</a></li>
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
		<h2>订单管理</h2>
		<div class="manage">
			<div class="search">				
			</div>
			<div class="spacer"></div>
            <form id="orderForm" method="post"  action="ManageOrderServlet?temp=find">
                 订单号：<input type="text" class="text" name="entityId" id="entityId" />
                 订货人：<input type="text" class="text" name="userName" />
                 <label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
            </form>
			<c:forEach items="${pagebean.pagelist }" var="odermap">
				<c:forEach items="${odermap }" var="map">
				<table class="list">
				<tr id="head">
					<th colspan="2" name="oid" oid="${map.key.oid }" >单号： ${map.key.oid }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 时间：${map.key.createtime }</th>					
					<th colspan="2">状态:
					<c:choose>
						<c:when test="${map.key.status == 5 }">收货确认</c:when>
						<c:otherwise>
							<select name="status" >	
							<option value="1"  
							<c:if test="${map.key.status == 1 }">selected="selected"</c:if>>待审核</option>
							<option value="2"
							<c:if test="${map.key.status == 2 }">selected="selected"</c:if>>审核通过</option>
							<option value="3"
							<c:if test="${map.key.status == 3 }">selected="selected"</c:if>>配货</option>
							<option value="4"
							<c:if test="${map.key.status == 4 }">selected="selected"</c:if>>发货</option>
							<option value="5">收货确认</option>
							</select>
						</c:otherwise>
					</c:choose>
					</th>					
				</tr >
				<c:forEach items="${map.value }" var="oder" varStatus="var" >
					<tr id="body">
						<td class="first w4 c"><img src="../images/product/${oder.filename }" />${oder.pname }</td>
						<td>${oder.price }</td>
						<td>${oder.quantity }</td>
						<c:if test="${var.index == 0 }">
						<td class="w1 c" rowspan="${fn:length(map.value) }"></td>
						</c:if>	
					</tr>
				</c:forEach>
				</table>
				</c:forEach>
            </c:forEach>    				
			
			<div class="pager">
				<ul class="clearfix">
					<li><a href="ManageOrderServlet?temp=${tp }&pno=1${tt }" >首页</a></li>
					<c:if test="${pagebean.pageno > 2 }"><li>...</li></c:if>
					<c:if test="${pagebean.pageno > 1 }">
					<li><a href="ManageOrderServlet?temp=${tp }&pno=${pagebean.pageno-1 }${tt }" >${pagebean.pageno-1 }</a></li>
					</c:if>
					<li class="current">${pagebean.pageno }</li>
                    <c:if test="${(pagebean.pagetotal - pagebean.pageno) > 0 }">
                    <li><a href="ManageOrderServlet?temp=${tp }&pno=${pagebean.pageno+1 }${tt }">${pagebean.pageno+1 }</a></li>
                    </c:if>
                    <c:if test="${(pagebean.pagetotal - pagebean.pageno) > 1 }">
                    <li>...</li>
                    </c:if>
					<li>
					<a href="ManageOrderServlet?temp=${tp }&pno=${pagebean.pagetotal }${tt }" >尾页</a>
					</li>
				</ul>
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

