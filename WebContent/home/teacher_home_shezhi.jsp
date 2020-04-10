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
       <div style="width:100%;height:130px"></div>
       <div style="padding-bottom:10px;width:1140px;margin:0 auto;height: 22px;"><p style="font-size: 18px;margin-top:10px">个人设置</p></div>
       <div style="width:1140px;margin:0 auto;height:505px;">
          <div style="float:left;width:200px;height:250px;padding: 30px 25px 0px;background: #fff;border-radius: 3px;text-align: center;margin-right:10px;">
             <img src="${pageContext.request.contextPath}/<%=teacher.getImg() %>" style="width: 80px;height: 80px;border-radius: 50%;margin: 0 auto;">
              <p><%=teacher.getName() %></p>
             <p></p>
             <p></p>
          </div>
          <div style="float:left;width: 880px;height:505px;background: #fff; border-radius: 3px;">
             <div style="color: #333;font-size: 16px;padding: 28px 0px 8px;">
                <div class="shezhi_daohang" id="geren">个人信息</div>
                <div class="shezhi_daohang" id="touxiang">头像设置</div>
                <div class="shezhi_daohang" id="mima">修改密码</div>
             </div>
             <div style="padding: 70px 0px 10px;width:370px;height:390px;margin: 0 auto;" id="geren_kuang">
                  <form method="post" action="" style="width:370px;height:375px;">
                     <div style="margin-bottom: 10px;height:36px;width:760px">
                        <div style="float:left;width:100px;text-align: right;padding-right: 5px;height: 36px;line-height: 36px;">姓名</div>
                        <div style="float:left"><input placeholder="请输入姓名" type="text" name="" value="<%=teacher.getName() %>" style=" height: 36px;padding-left: 10px;font-size: 14px;display: inline-block;border-radius: 3px;line-height: 36px;background: #fff;border: #dcdcdc solid 1px;"></div>
                     </div>  
                     <div style="margin-bottom: 10px;height:36px;width:760px">
                        <div style="float:left;width:100px;text-align: right;padding-right: 5px;height: 36px;line-height: 36px;">qq</div>
                        <div style="float:left"><input placeholder="请输入qq号" type="text" name="" value="<%=teacher.getQq() %>" style=" height: 36px;padding-left: 10px;font-size: 14px;display: inline-block;border-radius: 3px;line-height: 36px;background: #fff;border: #dcdcdc solid 1px;"></div>
                     </div>
                     <div style="margin-bottom: 10px;height:36px;width:760px">
                        <div style="float:left;width:100px;text-align: right;padding-right: 5px;height: 36px;line-height: 36px;">手机号</div>
                        <div style="float:left"><input placeholder="请输入手机号" type="text" name="" value="<%=teacher.getPhone() %>" style=" height: 36px;padding-left: 10px;font-size: 14px;display: inline-block;border-radius: 3px;line-height: 36px;background: #fff;border: #dcdcdc solid 1px;"></div>
                     </div>
                     <div style="border-top: 1px solid #e4e4e4;text-align: right;padding-right: 20px;height: 41px;padding-bottom:10px;margin-top: 220px;">
                       <input type="submit" style="width: 80px;height:35px;margin-top:7px;background: #00cd9d;color: #fff;border: 1px solid #00cd9d;">
                     </div>             
                  </form>
             </div>
              <div style="display:none;width: 370px;text-align: center;margin: auto;padding:70px 0 10px;height:390px" id="touxiang_kuang">
                  <form id="uploadForm" action="${pageContext.request.contextPath}/Tou" method="post" name="tou" enctype="multipart/form-data">
		             <center style="height:250px"><img src="${pageContext.request.contextPath}/<%=teacher.getImg() %>" alt="" id="selectImg" style="width:180px;height:180px;margin-top:10px;border-radius: 50%"></center>
                     <div class="preview" style="margin:0 auto;">
		               <input type="file" id="uploadImg" onchange="xmTanUploadImg(this)" name="uploadImg" style="margin-top:10px;">
		             </div>
		              <div style="border-top: 1px solid #e4e4e4;text-align: right;padding-right: 20px;height: 41px;padding-bottom:10px;margin-top: 63px;">
                       <input type="submit" style="width: 80px;height:35px;margin-top:7px;background: #00cd9d;color: #fff;border: 1px solid #00cd9d;">
                     </div>     
                 </form>
             </div>
              <div style="display:none;padding: 70px 0px 10px;width:370px;height:390px;margin: 0 auto;" id="mima_kuang">
                  <form method="post" action="" style="width:370px;height:375px;">
                     <div style="margin-bottom: 10px;height:36px;width:760px">
                        <div style="float:left;width:100px;text-align: right;padding-right: 5px;height: 36px;line-height: 36px;">原始密码</div>
                        <div style="float:left"><input placeholder="请输入原始密码" type="text" name="" style=" height: 36px;padding-left: 10px;font-size: 14px;display: inline-block;border-radius: 3px;line-height: 36px;background: #fff;border: #dcdcdc solid 1px;"></div>
                     </div>  
                     <div style="margin-bottom: 10px;height:36px;width:760px">
                        <div style="float:left;width:100px;text-align: right;padding-right: 5px;height: 36px;line-height: 36px;">新密码</div>
                        <div style="float:left"><input placeholder="请输入新密码" type="text" name="" style=" height: 36px;padding-left: 10px;font-size: 14px;display: inline-block;border-radius: 3px;line-height: 36px;background: #fff;border: #dcdcdc solid 1px;"></div>
                     </div>
                     <div style="margin-bottom: 10px;height:36px;width:760px">
                        <div style="float:left;width:100px;text-align: right;padding-right: 5px;height: 36px;line-height: 36px;">确认密码</div>
                        <div style="float:left"><input placeholder="确认密码" type="text" name="" style=" height: 36px;padding-left: 10px;font-size: 14px;display: inline-block;border-radius: 3px;line-height: 36px;background: #fff;border: #dcdcdc solid 1px;"></div>
                     </div>
                     <div style="border-top: 1px solid #e4e4e4;text-align: right;padding-right: 20px;height: 41px;padding-bottom:10px;margin-top: 220px;">
                       <input type="submit" style="width: 80px;height:35px;margin-top:7px;background: #00cd9d;color: #fff;border: 1px solid #00cd9d;">
                     </div>            
                  </form>
             </div>
          </div>
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
/*****/
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