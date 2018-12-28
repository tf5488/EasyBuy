<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.getJSON("UserServlet?temp=user", function(ret) {
			var user = eval(ret);
			if(user == null){
				$("#login").show();
				$("#sigin").show();
			}else{
				var username = user.username;
				var userStatu = user.status;
				$("#userName").html(username);
				if (userStatu == "1") {
					$("#login").hide();
					$("#sigin").hide();
					$("#backstager").show();
					$("#dologin").show();
					$("#shopping").show();
					$("#logout").show();
					$("#message").show();
				} else {
					$("#login").hide();
					$("#sigin").hide();
					$("#backstager").hide();
					$("#dologin").show();
					$("#logout").show();
					$("#message").show();
					$("#shopping").show();
				} 
			}
			
			
			
		});

		$.getJSON("UserServlet?temp=order", function(ret) {
			var producterNum = ret;
			var str = "购物车" + producterNum + "件";
			$("#shopping").html(str);
		});

		$("a").click(function(){
			$(this).parent().attr("class","current");
		});
		
	});
</script>
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<a href="index.jsp"><img src="images/logo.gif" /></a>
		</div>
		<div class="help">
			<a href="ShoppServlet?temp=list" id="shopping" class="shopping" style="display: none"></a> 
			<span id="dologin" style="display: none">欢迎,<strong id="userName"></strong>登陆!</span> 
			<a href="login.jsp" id="login" style="display: none">登录</a> 
			<a class="button" id="logout" href="javascript:void(0)" style="display: none">注销</a> 
			<a href="register.jsp" id="sigin" style="display: none">注册</a> 
			<a href="guestbook.jsp" style="display: none" id="message">留言</a> 
			<a href="manage/index.jsp" style="display: none" id="backstager">后台管理</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li><a href="#">首页</a></li>
				<li><a href="#">图书</a></li>
				<li><a href="#">百货</a></li>
				<li><a href="#">品牌</a></li>
				<li><a href="#">促销</a></li>
			</ul>
		</div>
	</div>
	<div id="childNav">
		<div class="wrap">
			<ul class="clearfix">
				<li class="first"><a href="#">音乐</a></li>
				<li><a href="#">影视</a></li>
				<li><a href="#">少儿</a></li>
				<li><a href="#">动漫</a></li>
				<li><a href="#">小说</a></li>
				<li><a href="#">外语</a></li>
				<li><a href="#">数码相机</a></li>
				<li><a href="#">笔记本</a></li>
				<li><a href="#">羽绒服</a></li>
				<li><a href="#">秋冬靴</a></li>
				<li><a href="#">运动鞋</a></li>
				<li><a href="#">美容护肤</a></li>
				<li><a href="#">家纺用品</a></li>
				<li><a href="#">婴幼奶粉</a></li>
				<li><a href="#">饰品</a></li>
				<li class="last"><a href="#">Investor Relations</a></li>
			</ul>
		</div>
	</div>
</body>
</html>