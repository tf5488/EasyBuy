<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<script type="text/javascript" src="scripts/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">

	function click() {
		for (var i = 0; i < document.regForm.elements.length - 1; i++) {
			if (document.regForm.elements[i].value == "") {
				alert("表格未填写完整!");
				document.regForm.elements[i].focus();
				return false;
			}
		}
		return true;
	}

	var msg = "${msg }";
	if(msg != null && msg != ""){
		alert(msg);
	}
	
</script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎注册易买网</h1>
			<ul class="steps clearfix">
				<li class="current"><em></em>填写注册信息</li>
				<li class="last"><em></em>注册成功</li>
			</ul>
			<form name="regForm" id="regForm" method="post" action="RegisterServlet?temp=reqister" onsubmit="click()">
				<table>
					<tr>
						<td class="field">用户名(*)：</td>
						<td id="regfrom">
							<input class="text" type="text" name="userId"  id="userId" maxlength="10" />
							<span id="namespan" ></span>
						</td>
					</tr>
					<tr>
						<td class="field">真实姓名(*)：</td>
						<td><input class="text" type="text" name="userName" /><span></span></td>
					</tr>
					<tr>
						<td class="field">登录密码(*)：</td>
						<td><input class="text" type="password" id="password" name="password" /><span></span></td>
					</tr>
					<tr>
						<td class="field">确认密码(*)：</td>
						<td><input class="text" type="password" name="confirmPassword" /><span></span></td>
					</tr>
					<tr>
						<td class="field">性别(*)：</td>
						<td>
						  <input class="radio" type="radio" name="sex" value="1" id="nale" checked="checked"><label for="nale">男性</label>
						  <input class="radio" type="radio" name="sex" id="0" value="female" ><label for="female">女性</label>
						  <span></span></td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td><input id="birthday" class="text" type="text" name="birthday" /><span></span></td>
					</tr>
					<tr>
						<td class="field">身份证：</td>
						<td><input class="text" type="text" name="identityCode" /><span></span></td>
					</tr>
					<tr>
						<td class="field">电子邮件：</td>
						<td><input class="text" type="text" name="email" /><span></span></td>
					</tr>
					<tr>
						<td class="field">手机(*)：</td>						
						<td><input class="text" type="text" name="mobile" /><span></span></td>
					</tr>
					<tr>
						<td class="field">收货地址(*)：</td>
						<td><input class="text" type="text" name="address" /><span></span></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" value="提交注册" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
