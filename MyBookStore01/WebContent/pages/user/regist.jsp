<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<link type="text/css" rel="stylesheet" href="../../static/css/style.css">
<style type="text/css">
.login_form {
	height: 420px;
	margin-top: 25px;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		//使用Ajax查询用户名是否存在,增强用户的体验性

		$("#username")
				.change(
						function() {
							var username = $(this).val();
							var url = "${pageContext.request.contextPath}/UserServlet?methodName=registName&username="
									+ username;
							$.post(url, function(data) {
								$(".errorMsg").html(data);
							});
						});

		//获取注册按钮并给它绑定单击响应函数
		$("#sub_btn").click(function() {
			//获取用户名、密码、确认密码、邮箱、验证码
			var userName = $("#username").val();
			var password = $("#password").val();
			var repwd = $("#repwd").val();
			var email = $("#email").val();
			var code = $("#code").val();
			//使用正则表达式对用户名、密码、邮箱进行验证
			var userReg = /^[a-zA-Z0-9_-]{3,16}$/;
			if (!userReg.test(userName)) {
				alert("请输入3-16位的数字、字母、下划线或减号的用户名！");
				return false;
			}
			;
			var pwdReg = /^[a-zA-Z0-9_-]{6,18}$/;
			if (!pwdReg.test(password)) {
				alert("请输入6-18位的数字、字母、下划线或减号的密码！");
				return false;
			}
			;
			if (repwd != password) {
				alert("两次输入的密码不一致！");
				return false;
			}
			var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if (!emailReg.test(email)) {
				alert("邮箱格式不正确！");
				return false;
			}
			if (code == "") {
				alert("验证码不能为空！");
				return false;
			}
		});
	});
</script>
</head>
<body>
	<div id="login_header">
		<img class="logo_img" alt="" src="../../static/img/logo.gif">
	</div>

	<div class="login_banner">

		<div id="l_content">
			<span class="login_word">欢迎注册</span>
		</div>

		<div id="content">
			<div class="login_form">
				<div class="login_box">
					<div class="tit">
						<h1>注册尚硅谷会员</h1>
						<span class="errorMsg"></span>
					</div>
					<div class="form">
						<form action="regist_success.html">
							<label>用户名称：</label> <input class="itxt" type="text"
								placeholder="请输入用户名" autocomplete="off" tabindex="1"
								name="username" id="username" />
							<br /> <br /> <label>用户密码：</label> <input class="itxt"
								type="password" placeholder="请输入密码" autocomplete="off"
								tabindex="1" name="password" id="password" /> <br /> <br /> <label>确认密码：</label>
							<input class="itxt" type="password" placeholder="确认密码"
								autocomplete="off" tabindex="1" name="repwd" id="repwd" /> <br />
							<br /> <label>电子邮件：</label> <input class="itxt" type="text"
								placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
								name="email" id="email" /> <br /> <br /> <label>验证码：</label>
							<input class="itxt" type="text" style="width: 150px;" id="code" />
							<img alt="" src="../../static/img/code.bmp"
								style="float: right; margin-right: 40px"> <br /> <br />
							<input type="submit" value="注册" id="sub_btn" />

						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>