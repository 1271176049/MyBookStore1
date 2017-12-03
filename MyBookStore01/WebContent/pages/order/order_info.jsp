<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单详情</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/style.css">
<style type="text/css">
h1 {
	text-align: center;
	margin-top: 200px;
}
</style>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt=""
			src="${pageContext.request.contextPath}/static/img/logo.gif"> <span
			class="wel_word">订单详情</span>
		<%@ include file="/WEB-INF/include/menue.jsp"%>
	</div>

	<div id="main">

		<c:if test="${!empty order2 }">
			<table>
				<tr>
					<td>订单号</td>
					<td>时间</td>
					<td>用户姓名</td>
					<td>用户邮箱</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>${order2.id}</td>
					<td><p style="font-size: 2px">${order2.orderTime }</p></td>
					<td>${order2.user.username }</td>
					<td>${order2.user.email }</td>
					<td></td>
					<td></td>
				</tr>
				<tr style="background-color: #ccc">
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>封面</td>
					<td>书名</td>
					<td>作者</td>
					<td>价格</td>
					<td>数量</td>
					<td>金额</td>
				</tr>
				<c:forEach items="${order2.orderItems}" var="items">
					<tr>
						<td><img class="book_img" alt=""
							src="${pageContext.request.contextPath}/${items.imgPath }">
						</td>
						<td>${items.title }</td>
						<td>${items.author }</td>
						<td>${items.price }</td>
						<td>${items.count }</td>
						<td>${items.amount }</td>
					</tr>
				</c:forEach>


			</table>
		</c:if>

	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>