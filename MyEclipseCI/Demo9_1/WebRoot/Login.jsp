<%@ page pageEncoding="UTF-8"%>
<html>
	<head>
		<title>带图形验证码的登录</title>
	</head>
	<body>
		<form method="post" name="form1">
			用户名
			<input type="text" name="userid" onclick="mes.innerHTML=''"
				value="${param.userid}" />
			<br />
			密码
			<input type="password" name="userpwd" value="${param.userpwd}" />
			<br />
			验证码
			<input type="text" name="checkcode" />
			<img border="0" src="checkcode" />
			<input type="submit" value="换一张"
				onclick="form1.action='changecheckcode'" />
			<br />
			<input type="submit" value="登录" onclick="form1.action='logcheck'" />
			<input type="reset" value="重置" />
			<div id="mes">
				${info}
			</div>
		</form>
	</body>
</html>