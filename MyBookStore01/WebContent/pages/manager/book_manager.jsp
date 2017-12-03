<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/style.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$(".deleteBtn").click(function() {
			var title = $(this).parents("tr").find("td").first().text();
			var flag=confirm('您确定要删除:《'+title+'》这本书吗?');
			
		});
	});
</script>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt=""
			src="${pageContext.request.contextPath}/static/img/logo.gif"> <span
			class="wel_word">图书管理系统</span>
		<div>
			<ol>
				<li><a
					href="${pageContext.request.contextPath }/ManagerBookServlet?methodName=getBooks">图书管理</a></li>
				<li><a href="order_manager.jsp">订单管理</a></li>
				<li><a href="${pageContext.request.contextPath}/index.jsp">返回商城</a></li>
			</ol>
		</div>
	</div>

	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${list }" var="book">
				<tr>
					<td>${book.title}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a
						href="${pageContext.request.contextPath }/ManagerBookServlet?methodName=getBook&id=${book.id}">修改</a></td>
					<td><a class="deleteBtn" href="${pageContext.request.contextPath }/ManagerBookServlet?methodName=deleteBook&id=${book.id}">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a
					href="${pageContext.request.contextPath}/pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>
		</table>
	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>