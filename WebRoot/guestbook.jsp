<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
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
<script type="text/javascript" >
//验证留言
$("#guestBook").submit(function(){
    if($(this).find("textarea").val().length<=100){
        return true;
    }
    $(this).find("span").addClass("error").html("留言不得多于100字");
    return false;
});
</script>
</head>
<c:if test="${empty pagebean.pagelist }">
	<script type="text/javascript">
		location.href="GuestBookServlet?flag=page";
	</script>
</c:if>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.html">易买网</a> &gt; 在线留言
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
		<jsp:include page="left.jsp"></jsp:include>
		</div>
		<div class="main">
			<div class="guestbook">
				<h2>全部留言</h2>
				<ul>
				<c:forEach items="${pagebean.pagelist }" var="comm">
					<li>
						<dl>
							<dt> ${comm.content } </dt>
							<dd class="author">
								网友：${comm.nickname } <span class="timer"> ${comm.createtime }</span>
							</dd>
							<dd> ${comm.reply }</dd>
						</dl>
					</li>
				</c:forEach>
				</ul>
				<div class="clear"></div>
				<div class="pager">
					<ul class="clearfix">
						<li><a href="GuestBookServlet?flag=page&pno=1" >首页</a></li>
					<c:if test="${pagebean.pageno > 2 }"><li>...</li></c:if>
					<c:if test="${pagebean.pageno > 1 }">
					<li><a href="GuestBookServlet?flag=page&pno=${pagebean.pageno-1 }" >${pagebean.pageno-1 }</a></li>
					</c:if>
					<li class="current">${pagebean.pageno }</li>
                    <c:if test="${(pagebean.pagetotal - pagebean.pageno) > 0 }">
                    <li><a href="GuestBookServlet?flag=page&pno=${pagebean.pageno+1 }">${pagebean.pageno+1 }</a></li>
                    </c:if>
                    <c:if test="${(pagebean.pagetotal - pagebean.pageno) > 1 }">
                    <li>...</li>
                    </c:if>
					<li>
					<a href="GuestBookServlet?flag=page&pno=${pagebean.pagetotal }" >尾页</a>
					</li>
					</ul>
				</div>
				<div id="reply-box">
				<script type="text/javascript">
					var ss="${msg}"
					if(ss != ""){
						alert(ss);
					}
				</script>
					<form id="guestBook" action="GuestContentServlet" method="post">
						<table>
							<tr>
								<td class="field">昵称：</td>
								<td><input class="text" type="text" name="guestName"
									disabled="disabled" value="当前用户名 : ${user.username }" />
								</td>
							</tr>
							<tr>
								<td class="field">留言内容：</td>
								<td><textarea name="guestContent"></textarea><span></span>
								</td>
							</tr>
							<tr>
								<td></td>
								<td><label class="ui-blue"><input type="submit"
										name="submit" value="提交留言" />
								</label>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2013 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
