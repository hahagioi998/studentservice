<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@page import="swu.zhj.service.*"%>
<%@page import="swu.zhj.model.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="swu.zhj.util.*" import="java.util.*" 
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Teacherusers teacher=(Teacherusers)session.getAttribute("teacher");
String shen=(String)session.getAttribute("shen");

 session.setAttribute("teacher", teacher);
   session.setAttribute("shen",shen);
   List<Student_kecheng> student_kecheng_list=new ArrayList<Student_kecheng>();
   student_kecheng_list=(ArrayList<Student_kecheng>)request.getAttribute("student_kecheng_list");
   List<Renwu_anser> renwu_anser_list=new ArrayList<Renwu_anser>();
   renwu_anser_list=(ArrayList<Renwu_anser>)request.getAttribute("renwu_anser_list");
   int renwu_id=(Integer)request.getAttribute("renwu_id");
   int kecheng_id=(Integer)request.getAttribute("kecheng_id");
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
    <div id="celan" onmouseenter="my0mouseenter()" onmouseleave="my0mouseleave()" style="overflow: hidden;transition:width .5s ease 0s;position:fixed;width:50px;height: 100%;top: 0;left: 0;background: #292e3d;z-index: 998;">
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
       <div style="width:100%;height:50px;text-align: center; padding-top: 50px;font-size: 21px;">
                         未完成的学生
       </div>
       <form action="${pageContext.request.contextPath}/Send?action=teachersendstudent&renwu_id=<%=renwu_id %>&kecheng_id=<%=kecheng_id %>" method="post">
       <div style="width:1200px;margin:0 auto;min-height:175px;border-radius: 3px;">
           <div style="margin:10px;background:#fff;min-height:200px;">
          <%if(!student_kecheng_list.isEmpty()){
	    	  for(Student_kecheng map1:student_kecheng_list){  
	    		 int i=0;
                 if(!renwu_anser_list.isEmpty()){
 	    	        for(Renwu_anser map:renwu_anser_list){
	    	    	   if(map.getStudent_xuehao().equals(map1.getStudent_xuehao())){
	    	    	    	i=1; 
	    	    	    }
 	    	        }
                 }
	    	    if(i==0){
	    	    	Studentusers student=UserService.chauserStudent(map1.getStudent_xuehao());
	    	    %>
               <div style="width:50px;height:70px;float:left;margin: 5px;text-align: center">
                 <img src="${pageContext.request.contextPath}/<%=student.getImg() %>" style="width:50px;height:50px">
                 <div style="font-size:13px"><%=student.getName() %></div>                    
               </div>
               <input type="checkbox" name="tongzhi" checked="checked" value="<%=student.getXuehao() %>" style="display: none;">
               <%}}} %>
           </div>
       </div>
       <div style="width:600px;margin:0 auto;">
         
		     <div style="width:520px;padding:10px;">
			              选择方式：<input name="method" type="radio" checked="checked" value="zhannei"/>站内方式 
                        <input name="method" type="radio" value="qq"/>q q邮件
                        <br>
                        <button type="submit">一键提醒</button>
              </div>
         
       </div>
        </form>
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
/**********/
 
 /************/
</script>
</html>