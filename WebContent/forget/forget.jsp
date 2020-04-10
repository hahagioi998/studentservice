<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>找回密码</title>
</head>
<style>
a{
 text-decoration: none;
}
 .aa{
    padding:5px;
 }
</style>
<body style="background:url(${pageContext.request.contextPath}/mylogin/images/login_bg_0.jpg) #f8f6e9;">
 <div  style="width:477px;
    height:479px;
    background:url(${pageContext.request.contextPath}/mylogin/images/img1.jpg) no-repeat;
    margin:0 auto;
    position:absolute;
    top:50%;
    left:50%;
    margin-top:-239px;
    margin-left:-238px;">
 <form action="${pageContext.request.contextPath}/Forget" method="post" style="margin:0 auto;width:250px;padding-top:100px;">
       <div class="aa">姓名：<input name="name" placeholder="请输入姓名 " maxlength="20" type="text" style="padding:10px;"></div>
       <div class="aa">电话：<input name="phone" placeholder="请输入电话号码" maxlength="20" type="text" style="padding:10px;"></div>
      <div class="aa">qq号：<input name="qq" placeholder="请输入qq号，用于验证" maxlength="20" type="text" style="padding:10px;"></div>
      <div class="aa"> <input type="submit" style="display: block;
    width: 100%;
    margin-top:20px;
    padding-right:0;
    padding-left:0;
    padding:10px 16px;
    font-size: 18px;
    line-height: 1.33;
    color: #fff;
    background-color:#d9534f;
    border-color:#d43f3a;"></div>
    </form>
 </div> 
   
</body>
</html>