<%@page import="swu.zhj.service.NewsService"%>
<%@page import="swu.zhj.service.UserService"%>
<%@page import="swu.zhj.model.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="swu.zhj.util.*" import="java.util.*" 
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Teacherusers teacher=(Teacherusers)session.getAttribute("teacher");
String shen=(String)session.getAttribute("shen");


 session.setAttribute("teacher", teacher);
   session.setAttribute("shen",shen);
   
  List<Renwu_anser> renwu_anser_list=new ArrayList<Renwu_anser>();
  renwu_anser_list=(ArrayList<Renwu_anser>)request.getAttribute("renwu_anser_list");
  Kecheng_renwu kecheng_renwu=new Kecheng_renwu();
  kecheng_renwu=(Kecheng_renwu)request.getAttribute("kecheng_renwu");

  
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
    <div id="celan" onmouseenter="my0mouseenter()" onmouseleave="my0mouseleave()" style="overflow: hidden;transition:width .5s ease 0s;position:fixed;width:50px;height: 100%;top: 0;left: 0;background:#292e3d;z-index: 998;">
      <ul style="margin-top:50px;padding:0;width: 160px;">
        <li style=" list-style: none;width: 160px;"><a href="${pageContext.request.contextPath}/Teacher_home" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">个人中心</p><img src="${pageContext.request.contextPath}/home/images/tou.png" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="${pageContext.request.contextPath}/Teacher_home_mykecheng" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">我的课程</p><img src="${pageContext.request.contextPath}/home/images/kecheng.png" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">个人中心</p><img src="${pageContext.request.contextPath}/home/images/tou.png" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">个人中心</p><img src="${pageContext.request.contextPath}/home/images/tou.png" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="${pageContext.request.contextPath}/home/teacher_home_shezhi.jsp" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">个人设置</p><img src="${pageContext.request.contextPath}/home/images/shezhi.png" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="${pageContext.request.contextPath}/Teacher_xiaoxi" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">消息中心</p><img src="${pageContext.request.contextPath}/home/images/xiaoxi.png" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
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
          <div style="overflow-y:scroll;float:left;width:300px;height: 475px;padding: 30px 25px 0px;background: #fff;border-radius: 3px;text-align: center;margin-right:10px;">
             <form method="post" action="">
               <input type="text" placeholder="搜索学生">
               <input type="submit" value="搜索">
             </form>
                <%if(!renwu_anser_list.isEmpty()){
	    	    for(Renwu_anser map:renwu_anser_list){
	    	    	Studentusers student=UserService.chauserStudent(map.getStudent_xuehao());
	    	    	Kecheng_chengji kecheng_chengji=NewsService.getKecheng_chengjiByStudent_xuehaoandrenwu_id(map.getStudent_xuehao(), map.getRenwu_id());
	    	    	%>
             <a href="${pageContext.request.contextPath}/Teacher_work_studentanser?student_xuehao=<%=student.getXuehao() %>&renwu_id=<%=map.getRenwu_id() %>" target="kecheng_xiangqinFrame">
               <div style="width:50px;height:70px;float:left;margin: 5px;text-align: center">
                 <img src="${pageContext.request.contextPath}/<%=student.getImg() %>" style="width:50px;height:50px">
                 <div style="font-size:13px"><%=student.getName() %></div>  
                 <%if(kecheng_chengji.getId()!=0){ %>
                     <div><%=kecheng_chengji.getChengji() %></div>
                     <%}else{ %>
                     <div>未批改</div>
                     <%} %>                  
               </div>
             </a>
               <%}} %>
          </div>
          <div style="float:left;width: 780px;height:505px;background: #fff; border-radius: 3px;">
            <iframe src="${pageContext.request.contextPath}/home/aaa.jsp" style="border: 0px;width:780px;min-height:590px" name="kecheng_xiangqinFrame">
       
            </iframe>
          </div>
          <div style="">
             <a href="${pageContext.request.contextPath}/Weiwanchengstudent?renwu_id=<%=kecheng_renwu.getId() %>&kecheng_id=<%=kecheng_renwu.getKecheng_id() %>" style="text-decoration: none" target="_blank">查看未提交作业学生</a>
             <a href="${pageContext.request.contextPath}/shiyan3?renwu_id=<%=kecheng_renwu.getId() %>" style="text-decoration: none">成绩导出</a>
          </div>
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