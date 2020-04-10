<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    String path=request.getContextPath();
    int id=(Integer)session.getAttribute("id");
    session.setAttribute("id", id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<style>
html{
    height:100%;
}
    body{
     margin:10px 0 10px 0;
     background-image:url("${pageContext.request.contextPath}/admin/images/bg.jpg");
     background-repeat:no-repeat;
     background-size:100% 100%; 
  }
  a{
      text-decoration: none;
  }
  p{
     height:25px;
     background-color:#BEBEBE;
     padding:10px;
  }
  p:hover{
      padding-left:15px;
      transition: 0.2s all linear;
      background-color:	#CDBA96;
  }
</style>
<body style="background-color:#aaa">
   <p><a href="${pageContext.request.contextPath}/ListNews" target="mainFrame">首页</a></p>
   <p><a href="${pageContext.request.contextPath}/ListUser" target="mainFrame">用户</a></p>
   <p>dsadsad</p>
   <p>dsadsad</p> 
   <p>dsadsad</p> 
<a href="${pageContext.request.contextPath}/My_ListNews" target="mainFrame">我的</a>
</body>
</html>