<%@page import="swu.zhj.model.*"%>
<%@page import="swu.zhj.service.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="swu.zhj.util.*" import="java.util.*" 
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Teacherusers teacher=(Teacherusers)session.getAttribute("teacher");
String shen=(String)session.getAttribute("shen");

 session.setAttribute("teacher", teacher);
   session.setAttribute("shen",shen);

  List<Teacher_kecheng> kecheng_list=new ArrayList<Teacher_kecheng>();
  kecheng_list=(ArrayList<Teacher_kecheng>)request.getAttribute("kecheng_list");
  session.setAttribute("kecheng_list", kecheng_list);
  
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
    <title><%=teacher.getName() %>教师首页</title>
</head>

<style>
a{
text-decoration: none;
}
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
    <div style="width:100%;height:100%;background:#f8f8f8;">
       <div style="width:100%;height:150px"></div>
       <div style="width:1200px;margin:0 auto;height:175px;border-radius: 3px;background: #fff;">
          <div style="float:left;width:145px;height:145px;padding: 15px 0px 0px 30px;">
             <img src="${pageContext.request.contextPath}/<%=teacher.getImg() %>" style="width:100%;height:100%;border-radius: 50%;">
          </div>
          <div style="float:left;width:425px;height:135px;padding: 25px 0px 0px 30px;">
               <div style="color: #333;font-size: 16px;padding: 28px 0px 8px;"><%=teacher.getName() %></div>
               <div style="color: #333;font-size: 12px;padding-bottom: 10px;">西南大学 </div>
               <div style="color: #333;font-size: 12px;padding-bottom: 10px;"></div>
               <div style="color: #333;font-size: 12px;padding-bottom: 10px;"></div>
          </div>
          <div style="float:left;width:285px;height:130px;padding-top: 15px;">
            <div style="height:60px;background: #f8f8f8;padding: 8px 13px 0px;margin-right: 15px;margin-bottom: 10px;"><a href="${pageContext.request.contextPath}/home/teacher_home_mykecheng.jsp"><p style="float:left"><span style="background:url()"></span>我的课程</p><p style="float:right;"><%=kecheng_list.size() %></p></a></div>
            <div style="height:60px;background: #f8f8f8;padding: 8px 13px 0px;margin-right: 15px;margin-bottom: 10px;"><a href="${pageContext.request.contextPath}/Teacher_xiaoxi"><p style="float:left"><span style="background:url()"></span>我的消息</p><p style="float:right;"><%=j %></p></a></div>
          </div>
         <div style="float:left;width:285px;height:130px;padding-top: 15px;">
            <div style="height:60px;background: #f8f8f8;padding: 8px 13px 0px;margin-right: 15px;margin-bottom: 10px;"><a href=""><p style="float:left"><span style="background:url()"></span>实验报告</p><p style="float:right;">1</p></a></div>
            <div style="height:60px;background: #f8f8f8;padding: 8px 13px 0px;margin-right: 15px;margin-bottom: 10px;"><a href=""><p style="float:left"><span style="background:url()"></span>系统公告</p><p style="float:right;">1</p></a></div>
          </div>
       </div>
       <div style="padding-bottom:10px;width:1200px;margin:0 auto;height: 22px;">
          <p style="float:right;font-size: 18px;margin-top:10px"><a href="${pageContext.request.contextPath}/home/addkecheng.jsp">添加课程</a></p>
          <p style="float:left;font-size: 18px;margin-top:10px">我的课程</p>
       </div>
       
       <div style="height:270px;width:1200px;margin:0 auto;padding-bottom: 20px;background: #fff;border-radius: 3px;">
          <div style="padding:5px 0 0 10px;width:300px;border-radius: 3px;height: 31px;border: #dcdcdc solid 1px;">
            
             <span id="mykecheng_xianshi"><%=NewsService.getKechengBykecheng_id(kecheng_list.get(0).getKecheng_id()).getKe_name() %></span>
             <span style="margin-right:5px;float:right;cursor: pointer;transform:rotate(90deg);" id="mykecheng_open">></span>
             <span style="display:none;margin-right:5px;float:right;cursor: pointer;transform:rotate(-90deg);" id="mykecheng_hidden">></span>
          </div>
          <div id="mykecheng" style="display:none;margin-top:5px;width:300px;border-radius: 3px;border: #dcdcdc solid 1px;">
              <%if(!kecheng_list.isEmpty()){
	    	    for(Teacher_kecheng map:kecheng_list){ 
	    	    Kecheng kecheng=NewsService.getKechengBykecheng_id(map.getKecheng_id());
	    	    %>
              <div id="mykecheng<%=map.getId() %>" style="cursor: pointer;height:26px;padding:10px 0px 0 10px"><%=kecheng.getKe_name() %></div>
               <%}}else{ %>
               <div style="height:26px;padding:10px 0px 0 10px">暂无课程</div>
                <%} %>
          </div>
            
       
          <div style="height: 190px;padding-top: 0px;"></div>
       </div>
        <div style="padding-bottom:10px;width:1200px;margin:0 auto;height: 22px;"><p style="font-size: 18px;margin-top:10px">所有课程</p></div>
       <div style="min-height:100px;width:1200px;margin:0 auto;padding-bottom: 20px;background: #fff;border-radius: 3px;">
          <div style="height: 60px;padding: 15px 20px 0px;">
            
             <div style="text-align:center;float:left;width:200px;height:300px;margin:15px;">
               <img src="${pageContext.request.contextPath}/" style="width:200px;height:200px">
               <div style="">
                 <p></p>
                 <div></div>
               </div>
             </div>
              
              <div>  暂无课程</div> 
             
       </div>
    </div>
</body>
<script>
   var celan=document.getElementById('celan'),
       mykecheng_open=document.getElementById('mykecheng_open'),
       mykecheng_hidden=document.getElementById('mykecheng_hidden'),
       mykecheng=document.getElementById('mykecheng');
  /********/ 
   mykecheng_open.onclick=function(){
	/*self.style.display="block";*/
	mykecheng.style.display="block";
	mykecheng_hidden.style.display="block";
	mykecheng_open.style.display="none";
}
   mykecheng_hidden.onclick=function(){
		/*self.style.display="block";*/
		mykecheng.style.display="none";
		mykecheng_hidden.style.display="none";
		mykecheng_open.style.display="block";
	}
   <%if(!kecheng_list.isEmpty()){
	    for(Teacher_kecheng map:kecheng_list){ %>
	    document.getElementById('mykecheng<%=map.getId()%>').onclick=function(){
	    	var a=document.getElementById('mykecheng<%=map.getId()%>').innerHTML;
	    	document.getElementById('mykecheng_xianshi').innerHTML=a;
	    }
	    <%}}%>
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