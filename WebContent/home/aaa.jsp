<%@page import="swu.zhj.model.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="swu.zhj.util.*" import="java.util.*" 
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Studentusers user=(Studentusers)session.getAttribute("user");
String shen=(String)session.getAttribute("shen");

 session.setAttribute("user", user);
   session.setAttribute("shen",shen);
  
%>
<!DOCTYPE html>
<html>
<head>
    <title>个人设置</title>
</head>

<style>
body{
   margin:0;
}

</style>
<script type="text/javascript">

</script>
<body>
   
</body>
<script>
   
</script>
</html>