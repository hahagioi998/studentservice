<%@page import="swu.zhj.model.*"%>
<%@page import="swu.zhj.service.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="swu.zhj.util.*" import="java.util.*" 
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Studentusers user=(Studentusers)session.getAttribute("user");
String shen=(String)session.getAttribute("shen");
int kecheng_id=(Integer)session.getAttribute("kecheng_id");

 session.setAttribute("user", user);
   session.setAttribute("shen",shen);
   
  List<Kecheng_renwu> kecheng_renwu_list=new ArrayList<Kecheng_renwu>();
  kecheng_renwu_list=(ArrayList<Kecheng_renwu>)request.getAttribute("kecheng_renwu_list");
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
  <div id="addrenwu_kuang" style="display:none;z-index:999;position:fixed;width:100%;height:400px;top:80px;">
    <div style="opacity:0.9;border-radius:10px;position: relative;;margin:0 auto;width:400px;height:100%;background: #cfc">
      <a href="javascript:cha()"><img alt="" src="${pageContext.request.contextPath}/home/images/error.jpg" style="cursor:pointer;border-radius: 50px;width:20px;height:20px;position:absolute;top:0;right:0;">
      </a>
      <form method="post" action="${pageContext.request.contextPath}/Addkecheng_renwu?kecheng_id=<%=kecheng_id%>">
          <input name="name" type="text">
          <input name="content" type="text">
          <input type="submit" value="提交">
      </form>
    </div>
  </div>
  
    <div style="width:270px;margin:0 auto;color: #333;font-size: 16px;padding: 28px 0px 8px;">
         <div class="shezhi_daohang" id="geren">任务</div>
         <div class="shezhi_daohang" id="touxiang">章节</div>
         <div class="shezhi_daohang" id="mima">更多</div>
    </div>
    <div style="padding:40px 0px 10px;width:370px;height:390px;margin: 0 auto;" id="geren_kuang">
       
        
      <%if(!kecheng_renwu_list.isEmpty()){
	    	    for(Kecheng_renwu map:kecheng_renwu_list){ 
	    	       boolean flag=NewsService.checkAnser(user.getXuehao(),map.getId());
	    	    %>
        <a href="${pageContext.request.contextPath}/Student_home_work?renwu_id=<%=map.getId() %>" target="_blank">
        <div style="margin:5px 0 5px 0;background: #f8f8f8;width: 100%;height: 50px;border-radius: 8px;padding: 5px;">
           <div style="float:left;width:40px;height:50px;margin-right:10px"">
               <img src="" style="width:40px;height:40px;margin-top:5px">
           </div>
           <div style="float:left;width:200px;height:50px">
               <%=map.getName() %>
           </div>  
           <div style="float:left;width:120px;height:50px;font-size:12px">
              <p style="margin:0px;"><%=map.getTime() %></p>
              <%if(flag){ %>
              <p>已完成</p>
              <%}else{ %>
              <p>未完成</p>
              <%} %>
           </div>
        </div>
        </a>
        <%}} %>
    </div>
           <div style="display:none;width: 370px;text-align: center;margin: auto;padding:70px 0 10px;height:390px" id="touxiang_kuang">
                
           </div>
           <div style="display:none;padding: 50px 0px 10px;width:670px;height:390px;margin: 0 auto;" id="mima_kuang">
              
               
            </div>
          </div>
       </div>
    </div>
</body>
<script>
   var geren=document.getElementById('geren'),
       touxiang=document.getElementById('touxiang'),
       mima=document.getElementById('mima'),
       addrenwu=document.getElementById('addrenwu'),
       addrenwu_kuang=document.getElementById('addrenwu_kuang'),
       addxuesheng=document.getElementById('addxuesheng'),
       addxuesheng_kuang=document.getElementById('addxuesheng_kuang'),
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

 addrenwu.onclick=function(){
	 addrenwu_kuang.style.display="block";
}
 addxuesheng.onclick=function(){
	 addxuesheng_kuang.style.display="block";
}
 function cha(){
	 addrenwu_kuang.style.display="none";
 }
 function cha1(){
	 addxuesheng_kuang.style.display="none";
 }
/******/
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