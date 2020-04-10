<%@page import="swu.zhj.model.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="swu.zhj.util.*" import="java.util.*"
    pageEncoding="utf-8"%>
    <%
    Admin admin=(Admin)session.getAttribute("admin");
    String shen=(String)session.getAttribute("shen");
    session.setAttribute("shen", shen);
    session.setAttribute("admin", admin);
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
<body>
   <p><a href="${pageContext.request.contextPath}/ListNews" target="mainFrame">首页界面管理</a></p>
   <p><a href="${pageContext.request.contextPath}/ListXiaoyuan" target="mainFrame">校园导航界面管理</a></p>
   <p><a href="${pageContext.request.contextPath}/ListJianzhi" target="mainFrame">兼职栏管理</a></p>
   <p><a href="${pageContext.request.contextPath}/ListStudentUser" target="mainFrame">学生用户管理</a></p>
   <p><a href="${pageContext.request.contextPath}/ListManagerUser" target="mainFrame">部门协会用户管理</a></p>
   <p><a href="${pageContext.request.contextPath}/ListTeacherUser" target="mainFrame">教师用户管理</a></p>
   <p><a href="${pageContext.request.contextPath}/ListYijian" target="mainFrame">意见箱</a></p>
</body>
</html>