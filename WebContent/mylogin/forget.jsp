<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>找回密码</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
</head>
<style>
html{
  height:100%;
}
body{
   background:url(${pageContext.request.contextPath}/mylogin/images/login_bg_0.jpg);
   background-repeat:no-repeat;
   background-size:100% 100%;
}
 .aa{
    padding:5px;
 }
</style>
<body>
<div style="width:477px;
    height:479px;
    background:url(${pageContext.request.contextPath}/mylogin/images/img1.jpg) no-repeat;
    margin:0 auto;
    position:absolute;
    top:50%;
    left:50%;
    margin-top:-239px;
    margin-left:-238px;">
    <form action="${pageContext.request.contextPath}/Forget" method="post" class="" style="margin:0 auto;width:300px;padding-top:70px;">
                 <div class="aa">姓名 :<input id="name" name="name" class=""  placeholder="输入姓名" maxlength="20" type="text" required autofocus style="width:190px;padding:10px;"></div> 
                 <div class="aa">qq号:<input id="qq" name="qq" class="" placeholder="输入qq号，用于验证" maxlength="20" type="text" required style="width:190px;padding:10px;"></div> 
                <div class="aa">电话 :<input id="phone" name="phone" class="" placeholder="请输入电话号码" maxlength="20" type="text" required style="width:190px;padding:10px;"></div> 
       <div class="aa" style="margin-top:100px;"> <input class="" id="submit" value="提&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;交" type="submit" style="display: block;
    width: 100%;
    padding-right: 0;
    padding-left: 0;    padding: 10px 16px;
    font-size: 18px;
    line-height: 1.33;    color: #fff;
    background-color: #d9534f;
    border-color: #d43f3a;">
        <div class="aa"> <input value="重置" id="reset" class="" type="reset" style="float:right;">
        
        <a href="${pageContext.request.contextPath}/mylogin/login.jsp" style="float:left;">登陆</a>
        </div>
        </form>
  </div>
</body>
</html>