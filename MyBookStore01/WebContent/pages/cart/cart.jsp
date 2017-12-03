<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/style.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	//deleteCartItem
	$(function() {
		//点击删除购物项的按钮的时候提示comfirm
		$(".deleteCartItem").click(function() {
			var title = $(this).parents("tr").find("td").first().text();
			var flag = confirm("您确定要删除购物车中《" + title + "》这本书吗?");
			//确定删除购物项
			if (flag) {
				//删除
			} else {
				return false;
			}

		});
		//当用户点击清空购物车的时候
		$("#deleteCartBtn").click(function() {
			var flag = confirm("您确定要清空购物车?");
			//确定清空购物车
			if (flag) {

			} else {
				return false;
			}
		});
		//当用户修改购物项的数量的时候
		$(".count").change(
				function() {
					//非零正整数
					//^\+?[1-9][0-9]*$
					var defaultValue = this.defaultValue;
					var value = this.value;
					//校验:判断value是否为非零正整数
					var test = /^\+?[1-9][0-9]*$/;
					var flag = test.test(value);
					//如果使用test.test(value)为false，那么不满足
					if (flag) {
						//如果是正整数，那么判断有没有超出库存
						var stock = $(this).parents("tr").find("td").first()
								.next().text();
						//判断数量是否大于库存
						if (value > stock) {
							//大于库存
							alert('对不起，您的数量超出库存量:' + stock);
							this.value = defaultValue;
						} else {
							//提交
							this.value = value;
							$("#form1").submit();
						}
					} else {
						alert('请输入合法的数量');
						this.value = defaultValue;
					}
				});
	});
</script>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">购物车</span>
		<div>
			<span>欢迎<span class="um_span">韩总</span>光临尚硅谷书城
			</span> <a href="pages/order/order.jsp">我的订单</a> <a href="index.html">注销</a>&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath }/index.jsp">返回</a>
		</div>
	</div>

	<div id="main">

		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${cart.cartItemList }" var="list">
				<tr>
					<td>${list.book.title}</td>
					<td style="display: none;">${list.book.stock}</td>
					<td>
						<form id="form1"
							action="${pageContext.request.contextPath }/CartServlet?methodName=updateCartItem&id=${list.book.id}"
							method="post">
							<input class="count" style="text-align: center;" type="text"
								name="count" value="${list.count}">
						</form>
					</td>
					<td>${list.book.price}</td>
					<td>${list.amount}</td>
					<td><a class="deleteCartItem"
						href="${pageContext.request.contextPath }/CartServlet?methodName=deleteCartItem&id=${list.book.id}">删除</a></td>
				</tr>
			</c:forEach>
		</table>

		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${cart.totalCount}</span>件商品
			</span> <span class="cart_span">总金额<span class="b_price">${cart.totalAmount}</span>元
			</span> <span class="cart_span"><a id="deleteCartBtn"
				href="${pageContext.request.contextPath }/CartServlet?methodName=deleteCart">清空购物车</a></span>
			<span class="cart_span"><a
				href="${pageContext.request.contextPath}/OrderServlet?methodName=creatOrder">去结账</a></span>
		</div>
	</div>
	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>