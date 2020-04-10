<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@page import="swu.zhj.service.*"%>
<%@page import="swu.zhj.model.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="swu.zhj.util.*" import="java.util.*" 
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Studentusers user=(Studentusers)session.getAttribute("user");
String shen=(String)session.getAttribute("shen");

 session.setAttribute("user", user);
   session.setAttribute("shen",shen);
   
  Tongzhi tongzhi=new Tongzhi();
  tongzhi=(Tongzhi)request.getAttribute("tongzhi");
%>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
</head>

<style>
body{
   margin:0;
}
#celan ul li:hover{

  border-left:2px solid #fff;
}
#mykecheng div:hover{
  background: #f8f8f8;
}
</style>
<script type="text/javascript">

</script>
<body>
    <div id="celan" onmouseenter="my0mouseenter()" onmouseleave="my0mouseleave()" style="overflow: hidden;transition:width .5s ease 0s;position:fixed;width:50px;height: 100%;top: 0;left: 0;background: #5c5c5c;z-index: 998;">
      <ul style="margin-top:50px;padding:0;width: 160px;">
         <li style=" list-style: none;width: 160px;"><a href="${pageContext.request.contextPath}/Student_home" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">个人中心</p><img src="${pageContext.request.contextPath}/home/images/tou.png" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="${pageContext.request.contextPath}/Student_home_mykecheng" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">我的课程</p><img src="${pageContext.request.contextPath}/home/images/kecheng.png" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">个人中心</p><img src="${pageContext.request.contextPath}/home/images/tou.png" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">个人中心</p><img src="${pageContext.request.contextPath}/home/images/tou.png" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="${pageContext.request.contextPath}/home/student_home_shezhi.jsp" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">个人设置</p><img src="${pageContext.request.contextPath}/home/images/shezhi.png" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="${pageContext.request.contextPath}/Student_xiaoxi" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">消息中心</p><img src="${pageContext.request.contextPath}/home/images/xiaoxi.png" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">系统公告</p><img src="${pageContext.request.contextPath}/home/images/gonggao.png" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="${pageContext.request.contextPath}/mylogin/login.jsp" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">安全退出</p><img src="${pageContext.request.contextPath}/home/images/tuichu.png" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
      </ul>
    </div>
    <div style="width:100%;height:760px;background:#f8f8f8;">
       <div style="width:100%;height:50px;text-align: center; padding-top: 50px;font-size: 21px;">
          <%=tongzhi.getTitle() %>
       </div>
       <div style="width:1200px;margin:0 auto;min-height:175px;border-radius: 3px;">
           <div style="margin:10px;background:#fff;min-height:200px;">
              <div style="margin: 5px;font-size: 13px">
              <%  char[] strCharArray=tongzhi.getSender().toCharArray();
	    	    	 String sendered_name;
	    	    	 if(strCharArray.length==6){
	    	        Teacherusers teacher=UserService.chauserTeacher(tongzhi.getSender());
	    	        sendered_name=teacher.getName();
	    	    	 }else{
	    	    	Admin admin=UserService.chauserManager(tongzhi.getSender());
	    	    	 sendered_name=admin.getName();
	    	    	 }%>
                  <%=sendered_name %>
              </div>
              <div style="margin: 5px;font-size: 12px">
                  <%=tongzhi.getTime() %>
              </div>
               <div style="margin: 5px;min-height:200px">
                  <%=tongzhi.getContent() %>
              </div>
           </div>
       </div>
    </div>
</body>
<script>
   var celan=document.getElementById('celan'),
       mykecheng_open=document.getElementById('mykecheng_open'),
       mykecheng_hidden=document.getElementById('mykecheng_hidden'),
       mykecheng=document.getElementById('mykecheng');
  /********/ 
  
  
/**************/
function my0mouseenter(){
	celan.style.width="160px";
}
/***************/
function my0mouseleave(){
	celan.style.width="50px";
}
</script>
</html>