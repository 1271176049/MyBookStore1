<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<a href="pages/user/login.jsp">登录</a> | <a href="pages/user/regist.jsp">注册</a>
	&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/OrderServlet?methodName=intoOrder">我的订单</a> <a
		href="pages/cart/cart.jsp">购物车</a> <a href="pages/manager/manager.jsp">后台管理</a>
</div>