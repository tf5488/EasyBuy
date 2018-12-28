<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	function click(){
		for(var i = 0;i < document.loginForm.elements.length-1;i++){
			if(document.loginForm.elements[i].value == ""){
				alert("表格未填写完整!");
				document.form1.elements[i].focus();
				return false;	
			}
		}
		return true;
	}

</script>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div id="register" class="wrap">
		<div class="shadow">
			<em class="corner lb"></em> <em class="corner rt"></em>
			<div class="box">
				<h1>欢迎回到易买网</h1>
				<form name="loginForm" id="loginForm" method="post" action="LoginServlet" >
					<table>
						<span style="color: red"> ${msg } </span>
						<tr>
							<td class="field">用户名：</td>
							<td><input class="text" type="text" id="userId"
								name="userId" /></td>
						</tr>
						<tr>
							<td class="field">登录密码：</td>
							<td><input class="text" type="password" id="password"
								name="password" /> </td>
						</tr>
						<tr>
							<td class="field">验证码：</td>
							<td><img src="Number.jsp" id="safeCode" /><a
								id="changeCode" href="#">看不清，换一张</a><br> <input type="text"
								name="code">
								<div class="mess"></div> <span></span></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-green"><input type="submit"
									name="submit" value="立即登录" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2010 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>

