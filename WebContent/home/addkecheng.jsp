<%@page import="swu.zhj.model.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="swu.zhj.util.*" import="java.util.*" 
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Teacherusers teacher=(Teacherusers)session.getAttribute("teacher");
String shen=(String)session.getAttribute("shen");

 session.setAttribute("teacher", teacher);
   session.setAttribute("shen",shen);
  /*List<Commodity_infor> commodity_infor_list1=new ArrayList<Commodity_infor>();
  commodity_infor_list1=(ArrayList<Commodity_infor>)request.getAttribute("commodity_infor_list1");*/
%>
<!DOCTYPE html>
<html>
<head>
    <title>添加课程</title>
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
        <li style=" list-style: none;width: 160px;"><a href="${pageContext.request.contextPath}/Student_home" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">个人中心</p><img src="" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">我的课程</p><img src="" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">个人中心</p><img src="" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">个人中心</p><img src="" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="${pageContext.request.contextPath}/home/teacher_home_shezhi.jsp" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">个人设置</p><img src="" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">消息中心</p><img src="" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">系统公告</p><img src="" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
        <li style="list-style: none;width: 160px;"><a href="" style="text-decoration:none;height: 55px;line-height: 55px;padding: 0px 10px 0px 15px;color: #bbb;"><p style="margin:0;float:right;padding-right:30px;">安全退出</p><img src="" style="float:left;width:30px;height:30px;margin-top:12px;margin-left:10px"></a></li>
      </ul>
    </div>
    <div style="width:100%;height:760px;background:#f8f8f8;">
       <div style="width:100%;height:130px"></div>
       <div style="padding-bottom:10px;width:1140px;margin:0 auto;height: 22px;"><p style="font-size: 18px;margin-top:10px">添加课程</p></div>
       <div style="width:1140px;margin:0 auto;height:505px;">
         <form action="${pageContext.request.contextPath}/Addkecheng" method="post" enctype="multipart/form-data">
            <input type="text" name="ke_name">
            <center style="height:250px"><img src="${pageContext.request.contextPath}/" alt="" id="selectImg" style="width:180px;height:180px;margin-top:10px;border-radius: 50%"></center>
            <div class="preview" style="margin:0 auto;">
		         <input type="file" id="uploadImg" onchange="xmTanUploadImg(this)" name="uploadImg" style="margin-top:10px;">
		    </div>
		   <div style="border-top: 1px solid #e4e4e4;text-align: right;padding-right: 20px;height: 41px;padding-bottom:10px;margin-top: 63px;">
              <input type="submit" style="width: 80px;height:35px;margin-top:7px;background: #00cd9d;color: #fff;border: 1px solid #00cd9d;">
          </div>   
         </form>
       </div>
    </div>
</body>
<script>
   var geren=document.getElementById('geren'),
       touxiang=document.getElementById('touxiang'),
       mima=document.getElementById('mima'),
       geren_kuang=document.getElementById('geren_kuang'),
       touxiang_kuang=document.getElementById('touxiang_kuang'),
       mima_kuang=document.getElementById('mima_kuang'),
       celan=document.getElementById('celan');
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