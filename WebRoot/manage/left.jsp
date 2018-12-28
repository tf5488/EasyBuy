<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="box">
		<dl>
			<dt>用户管理</dt>
			<dd>
				<a href="user.jsp">用户管理</a>
			</dd>
			<dt>商品信息</dt>
			<dd>
				<em><a href="productClass-add.jsp">新增</a></em><a
					href="productClass.jsp">分类管理</a>
			</dd>
			<dd>
				<em><a href="ManageProductServlet?temp=add">新增</a></em><a href="product.jsp">商品管理</a>
			</dd>
			<dt>订单管理</dt>
			<dd>
				<a href="order.jsp">订单管理</a>
			</dd>
			<dt>留言管理</dt>
			<dd>
				<a href="guestbook.jsp">留言管理</a>
			</dd>
			<dt>新闻管理</dt>
			<dd>
				<em><a href="news-add.jsp">新增</a></em><a href="news.jsp">新闻管理</a>
			</dd>
		</dl>
	</div>
</body>
</html>