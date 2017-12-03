<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<link type="text/css" rel="stylesheet" href="../../static/css/style.css">
<style type="text/css">
h1 {
	text-align: center;
	margin-top: 200px;
}
</style>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="../../static/img/logo.gif"> <span
			class="wel_word">后台管理系统</span>
		<div>
			<ol>
				<li><a href="${pageContext.request.contextPath }/ManagerBookServlet?methodName=getBooks">图书管理</a></li>
				<li><a href="order_manager.jsp">订单管理</a></li>
				<li><a href="${pageContext.request.contextPath}/index.jsp">返回商城</a></li>
			</ol>
		</div>
	</div>

	<div id="main">
		<h1>欢迎管理员进入后台管理系统</h1>
	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>