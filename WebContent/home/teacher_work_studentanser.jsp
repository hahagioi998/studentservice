<%@page import="swu.zhj.model.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="swu.zhj.util.*" import="java.util.*" 
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Teacherusers teacher=(Teacherusers)session.getAttribute("teacher");
String shen=(String)session.getAttribute("shen");

 session.setAttribute("teacher", teacher);
   session.setAttribute("shen",shen);
   
   Renwu_anser renwu_anser=new Renwu_anser();
   renwu_anser=(Renwu_anser)request.getAttribute("renwu_anser");
   String student_xuehao=request.getParameter("student_xuehao");
   int renwu_id=Integer.parseInt(request.getParameter("renwu_id"));
   Kecheng_chengji kecheng_chengji=new Kecheng_chengji();
   kecheng_chengji=(Kecheng_chengji)request.getAttribute("kecheng_chengji");
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
   <div>回答：</div>
   <div><%=renwu_anser.getAnser() %></div>
   <div>打分：</div> 
   <form method="post" action="${pageContext.request.contextPath}/Student_kechengrenwu_chengji?student_xuehao=<%=student_xuehao%>&renwu_id=<%=renwu_id%>">
      <input type="text" name="chengji" value="<%=kecheng_chengji.getChengji()%>">
      <input type="submit">
   </form>
</body>
<script>
   
</script>
</html>