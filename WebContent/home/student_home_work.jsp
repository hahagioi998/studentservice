<%@page import="swu.zhj.model.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="swu.zhj.util.*" import="java.util.*" 
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Studentusers user=(Studentusers)session.getAttribute("user");
String shen=(String)session.getAttribute("shen");


 session.setAttribute("user", user);
   session.setAttribute("shen",shen);
  Kecheng_renwu kecheng_renwu=new Kecheng_renwu();
  kecheng_renwu=(Kecheng_renwu)request.getAttribute("kecheng_renwu");
  Renwu_anser renwu_anser=new Renwu_anser();
  renwu_anser=(Renwu_anser)request.getAttribute("renwu_anser");
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
#celan ul li:hover{

  border-left:2px solid #fff;
}
.shezhi_daohang{
float:left;font-size: 16px;height: 40px;color: #333;line-height: 30px; margin-right: 15px; cursor: pointer;padding: 0 20px;
}
.shezhi_daohang:hover{
color: #00cd9d;
    border-bottom: 2px solid #00cd9d;
}
.preview{
      width: 150px;
    }
  .preview img{
      margin: 5px 0;
      width: 100%;
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
       <div style="width:100%;height:10px"></div>
       <div style="padding-bottom:10px;width:1140px;margin:0 auto;height: 22px;"><p style="font-size: 18px;margin-top:10px">问题：</p></div>
       <div style="width:1140px;margin:0 auto;height:120px">
         <%=kecheng_renwu.getContent() %>
       </div>
       <div style="width:1140px;margin:0 auto;height:505px;">
          <form method="post" action="${pageContext.request.contextPath}/Anser?renwu_id=<%=kecheng_renwu.getId()%>">
            <textarea rows="25" cols="170" name="anser"><%=renwu_anser.getAnser()%></textarea>
            <br>
            <button style="float:right;margin-right:32px">重置</button>
            <input type="submit">
          </form>
       </div>
    </div>
</body>
<script>
   var add=document.getElementById('geren'),
       touxiang=document.getElementById('touxiang'),
       mima=document.getElementById('mima'),
     
       geren_kuang=document.getElementById('geren_kuang'),
       touxiang_kuang=document.getElementById('touxiang_kuang'),
       mima_kuang=document.getElementById('mima_kuang'),
       celan=document.getElementById('celan');
/******/
geren.onclick=function(){
	geren_kuang.style.display="block";
	touxiang_kuang.style.display="none";
	mima_kuang.style.display="none";
}
touxiang.onclick=function(){
	geren_kuang.style.display="none";
	touxiang_kuang.style.display="block";
	mima_kuang.style.display="none";
}
mima.onclick=function(){
	geren_kuang.style.display="none";
	touxiang_kuang.style.display="none";
	mima_kuang.style.display="block";
}

 /***********/

	function xmTanUploadImg(obj) {
		    var file = obj.files[0];
		    var reader = new FileReader();
		    reader.readAsDataURL(file);
		    reader.onload = function (e) {  
		        var img = document.getElementById("selectImg");
		       /* var tou = document.getElementById("tou");
		        var tou1 = document.getElementById("tou1");*/
		        img.src = e.target.result;  
                /*tou.src=e.target.result;
                tou1.src=e.target.result;*/

		    };
		}
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