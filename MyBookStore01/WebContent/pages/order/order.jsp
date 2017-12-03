<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
<style type="text/css">
h1 {
	text-align: center;
	margin-top: 200px;
}
</style>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="${pageContext.request.contextPath}/static/img/logo.gif"> <span
			class="wel_word">我的订单</span>
		<div>
			<span>欢迎<span class="um_span">韩总</span>光临尚硅谷书城
			</span> <a href="../order/order.html">我的订单</a> <a href="${pageContext.request.contextPath}/index.html">注销</a>&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/index.jsp">返回</a>
		</div>
	</div>

	<div id="main">

		<table>
			<c:if test="${empty orderlist}">
				<h3>您的订单空空如也,赶快去购物吧</h3>
			</c:if>
			<c:if test="${!empty orderlist }">
				<tr>
					<td>订单号</td>
					<td>日期</td>
					<td>金额</td>
					<td>状态</td>
					<td>详情</td>
				</tr>
				<c:forEach items="${orderlist }" var="order">
					<tr>
						<td>${order.id}</td>
						<td>${order.orderTime}</td>
						<td>${order.totalAmount}</td>
						<td>${order.state==0?"未发货":(order.state==1?"已发货":"交易成功")}</td>
						<td><a href="${pageContext.request.contextPath}/OrderServlet?methodName=getOrderItemsInfo&id=${order.id}">查看详情</a></td>
					</tr>

				</c:forEach>
			</c:if>
		</table>


	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>