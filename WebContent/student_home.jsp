<%@ page language="java" contentType="text/html; charset=utf-8" import="swu.zhj.util.*" import="java.util.*" 
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String name=(String)session.getAttribute("name");
String img=(String)session.getAttribute("img");
String xuehao=(String)session.getAttribute("xuehao");
String shen=(String)session.getAttribute("shen");
 session.setAttribute("name", name);
   session.setAttribute("img", img);
   session.setAttribute("xuehao",xuehao);
   session.setAttribute("shen",shen);
   
  /*List<Commodity_infor> commodity_infor_list1=new ArrayList<Commodity_infor>();
  commodity_infor_list1=(ArrayList<Commodity_infor>)request.getAttribute("commodity_infor_list1");*/
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
</style>
<script type="text/javascript">

</script>
<body>
    <div id="celan" onmouseenter="my0mouseenter()" onmouseleave="my0mouseleave()" style="overflow: hidden;transition:width .5s ease 0s;position:fixed;width:50px;height: 100%;top: 0;left: 0;background: #5c5c5c;z-index: 998;">
      <ul style="margin-top:50px;padding:0;width: 160px;">
        <li style=" list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">个人中心</p><img src="" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">我的课程</p><img src="" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">个人中心</p><img src="" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">个人中心</p><img src="" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">个人设置</p><img src="" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">消息中心</p><img src="" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">系统公告</p><img src="" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">安全退出</p><img src="" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
      </ul>
    </div>
    <div style="width:100%;height:100%;background:#f8f8f8;">
       <div style="width:100%;height:150px"></div>
       <div style="width:1200px;margin:0 auto;height:175px;border-radius: 3px;background: #fff;">
          <div style="float:left;width:145px;height:145px;padding: 15px 0px 0px 30px;">
             <img src="" style="width:100%;height:100%;border-radius: 50%;">
          </div>
          <div style="float:left;width:425px;height:135px;padding: 25px 0px 0px 30px;">
               <div style="color: #333;font-size: 16px;padding: 28px 0px 8px;">朱豪杰</div>
               <div style="color: #333;font-size: 12px;padding-bottom: 10px;">西南大学 17计科2</div>
          </div>
          <div style="float:left;width:285px;height:130px;padding-top: 15px;">
            <div style="height:60px;background: #f8f8f8;padding: 8px 13px 0px;margin-right: 15px;margin-bottom: 10px;"><a href=""><p style="float:left"><span style="background:url()"></span>我的课程</p><p style="float:right;">1</p></a></div>
            <div style="height:60px;background: #f8f8f8;padding: 8px 13px 0px;margin-right: 15px;margin-bottom: 10px;"><a href=""><p style="float:left"><span style="background:url()"></span>我的消息</p><p style="float:right;">1</p></a></div>
          </div>
         <div style="float:left;width:285px;height:130px;padding-top: 15px;">
            <div style="height:60px;background: #f8f8f8;padding: 8px 13px 0px;margin-right: 15px;margin-bottom: 10px;"><a href=""><p style="float:left"><span style="background:url()"></span>实验报告</p><p style="float:right;">1</p></a></div>
            <div style="height:60px;background: #f8f8f8;padding: 8px 13px 0px;margin-right: 15px;margin-bottom: 10px;"><a href=""><p style="float:left"><span style="background:url()"></span>系统公告</p><p style="float:right;">1</p></a></div>
          </div>
       </div>
       <div style="padding-bottom:10px;width:1200px;margin:0 auto;height: 22px;"><p style="font-size: 18px;margin-top:10px">我的课程</p></div>
       <div style="height:270px;width:1200px;margin:0 auto;padding-bottom: 20px;background: #fff;border-radius: 3px;">
          <div style=" height: 60px; line-height: 60px;padding: 15px 20px 0px;">
            <form>
               <select><option value="">操作系统：地画风</option></select>
            </form>
          </div>
          <div style="height: 190px;padding-top: 0px;"></div>
       </div>
        <div style="padding-bottom:10px;width:1200px;margin:0 auto;height: 22px;"><p style="font-size: 18px;margin-top:10px">所有课程</p></div>
       <div style="min-height:100px;width:1200px;margin:0 auto;padding-bottom: 20px;background: #fff;border-radius: 3px;">
          <div style="height: 60px;padding: 15px 20px 0px;">
           
          </div>
       </div>
    </div>
</body>
<script>
   var self=document.getElementById('self'),
  
   yincang=document.getElementById('yincang'),
   celan=document.getElementById('celan'),

   deng=document.getElementById('deng');

deng.onclick=function(){
	/*self.style.display="block";*/
	self.style.right="35px";
}
yincang.onclick=function(){
	/*self.style.display="block";*/
	self.style.right="-275px";
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