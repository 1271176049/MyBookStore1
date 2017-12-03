<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/style.css">
<style type="text/css">
h1 {
	text-align: center;
	margin-top: 200px;
}

h1 a {
	color: red;
}

input {
	text-align: center;
}
</style>
</head>
<body>
	<div id="header">
		<img class="logo_img" alt="" src="${pageContext.request.contextPath }/static/img/logo.gif"> <span
			class="wel_word">编辑图书</span>
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
		<!-- 保存图书：没有id -->
		<c:if test="${empty book.id }">
			<form
				action="${pageContext.request.contextPath }/ManagerBookServlet?methodName=addBook"
				method="post">

				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>
					<tr>
						<td><input name="title" type="text" value="" /></td>
						<td><input name="price" type="text" value="" /></td>
						<td><input name="author" type="text" value="" /></td>
						<td><input name="sales" type="text" value="" /></td>
						<td><input name="stock" type="text" value="" /></td>
						<td><input type="submit" value="提交" /></td>
					</tr>
				</table>
			</form>
		</c:if>
		<!-- 修改图书，有id -->
		<c:if test="${!empty book.id}">
			<form
				action="${pageContext.request.contextPath }/ManagerBookServlet?methodName=editBook&id=${book.id}"
				method="post">

				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>
					<tr>
						<td><input name="title" type="text" value="${book.title}" /></td>
						<td><input name="price" type="text" value="${book.price}" /></td>
						<td><input name="author" type="text" value="${book.author}" /></td>
						<td><input name="sales" type="text" value="${book.sales}" /></td>
						<td><input name="stock" type="text" value="${book.stock}" /></td>
						<td><input type="submit" value="提交" /></td>
					</tr>
				</table>
			</form>
		</c:if>
	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>