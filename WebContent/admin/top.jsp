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
<title>后台管理系统</title>
</head>
<style>
  body{
     background-image:url("${pageContext.request.contextPath}/admin/images/bg1.jpg");
     background-repeat:no-repeat;
     background-size:100% 100%; 
  }
  a{
      text-decoration: none;
  }
</style>
<body>
<table cellspacing="0" cellpadding="0" width="100%" border="0">
    <tbody>
    <tr>
        <td width="100%" background="" height="80">
            <table height="80" cellpadding="0" cellspacing="0" width="100%" border="0">
                <tbody>
                <tr>
                    <td valign="top" align="right">&nbsp;</td>
                </tr>
                <tr>
                    <td valign="bottom" align="middle" colspan="2">
                        <table height="38" cellspacing="0" cellpadding="0" width="776" border="0">
                            <tbody>
                            <tr>
                                <td width="84">&nbsp</td>
                                <td width="97" valign="center" align="middle">&nbsp</td>
                                <td width="97" valign="center" align="middle">&nbsp</td>
                                <td class="our" valign="center" align="middle" width="97">&nbsp</td>
                                <td valign="center" align="middle" width="97" background=""><a
                                        href="${pageContext.request.contextPath}/forget/forget.jsp" target="main" class="dh">密码修改</a></td>
                                <td valign="center" align="middle" width="97" background=""><span class="white"></span><span class="font1">
                                   <%=admin.getName()%></span></td>
                                <td valign="center" align="middle" width="97" background=""><a
                                        href="${pageContext.request.contextPath}/Home" target="main" class="dh">首页</a></td>
                                <td valign="center" align="middle" width="97" background=""><a
                                        href="${pageContext.request.contextPath}/mylogin/login.jsp" target="_parent" class="dh">退出登录</a></td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>