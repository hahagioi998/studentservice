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
   
  List<Tongzhi> tongzhi_list=new ArrayList<Tongzhi>();
  tongzhi_list=(ArrayList<Tongzhi>)request.getAttribute("tongzhi_list");
  int j=0;
  for(Tongzhi map1:tongzhi_list){
	  if(map1.getFlag()==0) j++;
  }
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
       <div style="width:100%;height:50px;text-align: center; padding-top: 50px">
         <div> 全部消息 <%=tongzhi_list.size() %><div>
         <div style="color:red;">未读 <%=j %></div>
         <form>
            <input type="text">
            <input type="submit" value="搜索">  
         </form>
       </div>
       <div style="width:1200px;margin:0 auto;min-height:175px;border-radius: 3px;">
           <%if(!tongzhi_list.isEmpty()){
	    	    for(Tongzhi map:tongzhi_list){
	    	    	 char[] strCharArray=map.getSender().toCharArray();
	    	    	 String sendered_name;
	    	    	 String sendered_img;
	    	    	 System.out.println(strCharArray.length+"长度");
	    	    	 if(strCharArray.length==6){
	    	        Teacherusers teacher1=UserService.chauserTeacher(map.getSender());
	    	        sendered_name=teacher.getName();
	    	        sendered_img=teacher.getImg();
	    	    	 }else{
	    	    	Admin admin=UserService.chauserManager(map.getSender());
	    	    	 sendered_name=admin.getName();
	    	    	 sendered_img=admin.getImg();
	    	    	 }
	    	    
	    	    %>
	    	<a href="${pageContext.request.contextPath}/Teacher_xiaoxi_xiangqin?xiaoxi_id=<%=map.getId()%>">
           <div style="margin:10px;background:#fff;height:60px;">
              <div style="float:left;width:60px;height:60px;margin: 5px;"><img src="<%=sendered_img %>"style="width: 50px;height: 50px;"></div>
              <div style="float:left;width:800px;margin-top: 5px;height: 55px;">
                 <div style="font-size: 15px;margin-bottom: 5px;"><%=map.getTitle() %></div>
                 <div style="font-size: 13px;">
                   <%=sendered_name %>
                 </div>
              </div>
              <div style="float:left;width:200px;height: 40px;font-size: 13px;margin-top: 20px;"><%=map.getTime() %></div>
               <%if(map.getFlag()==0) {%>
              <div style="width:8px;height:8px;background: red;border-radius: 50%"></div>
              <%} %>
           </div> 
           </a>
           <%}
	    	    }else{%>
           <div>暂无消息</div>
	    	   <%}%>
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