<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.getJSON("IndexServlet?temp=category",function(ret){
			$.each(ret,function(k,v){
				$("#cglist").append("<dt>"+k+"</dt>")
				$(v).each(function(){
					$("#cglist").append("<dd><a href='ProductListServlet?cid="+this.cid+"'>"+this.cname+"</a></dd>")
				}); 
			});
		});
		
	});
</script>
<title>Insert title here</title>

</head>
<body>
	<div class="box">
		<h2>商品分类</h2>
		<dl id="cglist">
		</dl>
	</div>
</body>
</html>