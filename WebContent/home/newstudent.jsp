<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<!-- Head -->
<%@ page language="java" contentType="text/html;charset=utf-8" import="java.util.*" import="swu.zhj.model.*"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String name=(String)session.getAttribute("name");
    int o2=(Integer)session.getAttribute("o2");
    String img=(String)session.getAttribute("img");
%>
<head>
<title>新生栏</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="" />

<!-- Default-JavaScript-File -->
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/bootstrap.js"></script>
<!-- //Default-JavaScript-File -->

<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/mainStyles.css" /><!-- for banner -->

<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/flexslider.css" type="text/css" media="screen" property="" /><!-- for testimonials -->

<!-- Property for sale section css files-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/owl.carousel.css" type="text/css" media="all">
<link href="${pageContext.request.contextPath}/home/css/owl.theme.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/bootstrap.css" type="text/css" media="all">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/style.css" type="text/css" media="all">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/font-awesome.min.css" />
<style>
body{
   background:url(${pageContext.request.contextPath}/home/images/banner5.jpg) no-repeat 0px 0px;
	background-size:cover;
	-webkit-background-size:cover;
	-moz-background-size:cover;
	-o-background-size:cover;
	-ms-background-size:cover;
	min-height:750px;
}
.all{
  width:100%;
  margin:0 auto;
  position:absolute;
  top:0px;
  left:0;
  text-align: center;
  background-color:#abc;
  height:100%;
}
.liucheng{
  width:100%;
  height:180px;
  margin-top:100px;
  text-align: center;
  background-color:#bbb;
}
.sousuo{
  width:100%;
  height:400px;
  text-align: center;
  background-color:#eee;
}
</style>
</head>

<!-- Body -->
<body>

<!-- banner -->
	<div class="banner" id="home">
		<nav class="navbar navbar-default">
			<div class="navbar-header navbar-left">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<h1><a class="navbar-brand" href="index.html"><span>Build</span> Estate</a></h1>
					<i class="fa fa-home" aria-hidden="true"></i>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
				<nav class="link-effect-2" id="link-effect-2">
					<ul class="nav navbar-nav">
						<li class="active"><a href="${pageContext.request.contextPath}/Home"><span data-hover="首页">首页</span></a></li>
						<li><a href="${pageContext.request.contextPath}/home/newstudent.jsp"><span data-hover="新生栏">新生栏</span></a></li>
						<li><a href="${pageContext.request.contextPath}/Xiaonei"><span data-hover="部门协会">部门协会</span></a></li>
						<li><a href="${pageContext.request.contextPath}/moban3755/index.jsp" ><span data-hover="校园导航">校园导航</span></a></li>
						<li><a href="${pageContext.request.contextPath}/Jianzhi"><span data-hover="兼职栏">兼职栏</span></a></li>
						<li><a href="${pageContext.request.contextPath}/Home" class="scroll"><span data-hover="联系我们">联系我们</span></a></li>
					</ul>
				</nav>
			</div>
					<div class="agileits-social top_content">
						<ul>
							<li>
							<%if(name!=null){
                             %>
                       <a href="${pageContext.request.contextPath}/Student_User">欢迎${name}</a>
                             <a href="${pageContext.request.contextPath}/User">
							    <img alt="" data-original="${img }" src="${img }" style="height:40px;width:40px">
							  </a>
                             <%}else{ %>
                             <p>请登录</p>
							  <a href="${pageContext.request.contextPath}/mylogin/login.jsp">
							    <img alt="" src="${pageContext.request.contextPath}/mylogin/images/login_user.png" style="height:40px;width:40px">
							  </a>
							  <%} %>
							</li>
							<li><a><img alt="" src=""></a></li>
							<li><a><img alt="" src=""></a></li>
						</ul>
					</div>
		</nav>
		</div>
<!-- //banner -->	
<div class="all">
   <div class="liucheng"> 
      <img src="${pageContext.request.contextPath}/home/images/banner1.jpg" style="width:100%;height:100%">
   </div>
   <div class="sousuo">
      <div style="width:50%;height:50%;background-color:#ddd;margin:0 auto;padding:40px;">
        <h3>学生信息搜索</h3>
         <form class="new_search" action="${pageContext.request.contextPath}/NewstudentSearch" method="post" style="margin-top:25px; ">
					<input class="" type="text" name="search" style="height:34px;width:300px;" placeholder="请输入身份证号码"/>
					<button type="submit" class="btn btn-danger">查找</button>
	     </form>
      </div>
     
   </div>
</div>
</body>
<!-- //Body -->
</html>