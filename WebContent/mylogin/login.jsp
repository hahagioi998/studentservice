<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
</head>
<style>
html{
  height:100%;
}

</style>
<body style="background:url(${pageContext.request.contextPath}/mylogin/images/login_bg_0.jpg);background-repeat:no-repeat;background-size:100% 100%;">
<div class="signin">
	<div class="signin-head">
	 <input style="position:absolute;opacity:0;width:120px;height:120px;" type="file" name="file1" id="file1"/>
	  <img src="images/test/head_120.png" alt="" class="img-circle" style="width:120px;height:120px;"> 
	</div>
	<form class="form-signin" role="form" action="${pageContext.request.contextPath}/Userlogin" method="post">
		<input type="text" class="form-control" placeholder="学号" name="xuehao" required autofocus />
		<input type="password" class="form-control" placeholder="密码" name="password" required />
		<button class="btn btn-lg btn-danger btn-block" type="submit">登录</button>
		<label class="checkbox">
			<input type="radio" name="shen" value="student" checked="checked">学生
			<input type="radio" name="shen" value="teacher">老师
			<input type="radio" name="shen" value="admin">管理员
		</label>
		<a href="${pageContext.request.contextPath}/mylogin/forget.jsp" style="float:right">忘记密码?</a>
		<a href="${pageContext.request.contextPath}/mylogin/register.jsp" style="float:left">注册</a>
	</form>
</div>
<div style="text-align:center;">
</div>
</body>
</html>
