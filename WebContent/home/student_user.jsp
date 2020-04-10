<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<!-- Head -->
<%@ page language="java" contentType="text/html;charset=utf-8" import="java.util.*" import="swu.zhj.service.*" import="swu.zhj.model.*"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    int id=(Integer)session.getAttribute("id");
    String name=(String)session.getAttribute("name");
    String img=(String)session.getAttribute("img");
    session.setAttribute("id", id);
    Studentusers studentuser=new Studentusers();
    studentuser=(Studentusers)request.getAttribute("studentuser");
    
    Bumen_menber bumen_menber=new Bumen_menber();
    bumen_menber=(Bumen_menber)request.getAttribute("bumen_menber");
    
    List<Tongzhi> tongzhi_list=new ArrayList<Tongzhi>();
    tongzhi_list=(ArrayList<Tongzhi>)request.getAttribute("tongzhi_list");
   
%>
<head>
<title>${name }的主页</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/owl.carousel.css" type="text/css" media="all">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/bootstrap.css" type="text/css" media="all">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/style.css" type="text/css" media="all">

<style>
p{
 padding:10px 0 10px 0;
}
.all{
   background:url("${pageContext.request.contextPath}/home/images/snow_bk.jpg");
   background-repeat:no-repeat;
    background-size:100% 100%;  
  width:100%;
  margin:0 auto;
  position:absolute;
  top:0px;
  left:0;
  text-align: center;
  background-color:#abc;
  height:100%;
}
.zong{
   background:url("${pageContext.request.contextPath}/home/images/snow_bk.jpg");
   background-repeat:no-repeat;
    background-size:100% 100%; 
}
.liucheng{
  width:100%;
  height:180px;
  margin-top:100px;
  text-align: center;
  background-color:#bbb;
}
.sousuo{
  width:100%;
  height:400px;
  text-align: center;
  background-color:#eee;
}
.bt_box{
	width: 100%;
	text-align: center;
	font-size: 14px;
	padding:50px;
}
.bt_box .gb{
	display:inline-block;
	width:120px;
	height:35px;
	border-radius: 8px;
	background:#f3f3f3;
	color:#444;
	line-height: 35px;
}
.bt_box .queren{
	display: inline-block;
	width:120px;
	height:35px;
	border-radius: 8px;
	background:#4B8BF5;
	color:#fff;
	line-height: 35px;
	    border-width: 0px;
}
.preview{
      width: 150px;
    }
  .preview img{
      margin: 5px 0;
      width: 100%;
    }
</style>
</head>

<!-- Body -->
<body>

<!-- banner -->
	<div class="banner" id="home">
		<nav class="navbar navbar-default">
		<div class="navbar-header navbar-left">
				<h1><a class="navbar-brand" href="index.html"><span>Student</span>services</a></h1>
					<i class="fa fa-home" aria-hidden="true"></i>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
				<nav class="link-effect-2" id="link-effect-2">
					<ul class="nav navbar-nav">
						<li class="active"><a href="${pageContext.request.contextPath}/Home"><span data-hover="首页">首页</span></a></li>
						<li><a href="${pageContext.request.contextPath}/home/newstudent.jsp"><span data-hover="新生栏">新生栏</span></a></li>
						<li><a href="${pageContext.request.contextPath}/Xiaonei"><span data-hover="部门协会">部门协会</span></a></li>
						<li><a href="${pageContext.request.contextPath}/moban3755/index.jsp" ><span data-hover="校园导航">校园导航</span></a></li>
						<li><a href="${pageContext.request.contextPath}/Jianzhi"><span data-hover="兼职栏">兼职栏</span></a></li>
						<li><a href="${pageContext.request.contextPath}/Home" class="scroll"><span data-hover="联系我们">联系我们</span></a></li>
					</ul>
				</nav>
			</div>
					<div class="agileits-social top_content">
						<ul>
							<li>
							<%if(name!=null){
                             %>
                             <a href="${pageContext.request.contextPath}/Student_User">欢迎${name}</a>
                             <a href="${pageContext.request.contextPath}/Student_User">
                                <%if(img.equals("")){ %>
                                 <img alt="" id="tou1" src="${pageContext.request.contextPath}/mylogin/images/login_user.png" style="height:40px;width:40px">
                                <%}else{ %>
							    <img alt="" id="tou1" src="${img }" style="height:40px;width:40px">
							     <%} %>
							  </a>
                             <%}else{ %>
                             <p>请登录</p>
							  <a href="${pageContext.request.contextPath}/mylogin/login.jsp">
							    <img alt="" src="${pageContext.request.contextPath}/mylogin/images/login_user.png" style="height:40px;width:40px">
							  </a>
							  <%} %>
							</li>
							<li><a><img alt="" src=""></a></li>
							<li><a><img alt="" src=""></a></li>
						</ul>
					</div>
		</nav>
		</div>
<!-- //banner -->	
<div class="zong" style="width:100%;height:800px;background-color:#aaa;padding:135px 10% 0 10%;">
  <div class="right" style="width:50%;height:100%;background-color:#bbb;float:right;"> 
      学校比赛，活动
  </div>
  <div class="left" style="width:50%;height:100%;background-color:#ccc;float:left">
      <div class="left_top" style="width:100%;height:24%;background-color:#ddd">
          <div class="left_top_right" style="width:60%;height:100%;background-color:#fff;float:right;">
              <div class="tou" style="width:100%;height:75%;background-color:#abf;padding:10px;">
                  <div style="width:65%;height:100%;float:right;padding:10px;">
                     <p>${name }</p><br><br>
                     <p><% Teacherusers teacherusers=TiebaService.chauserbumenByBumen_id(bumen_menber.getBumen_id());
                     %><%=teacherusers.getName() %>：<%=bumen_menber.getZhiwei() %></p><br><br>
                     <a href="${pageContext.request.contextPath}/mylogin/login.jsp">退出登录</a>
                  </div>
                  <div style="width:35%;height:100%;float:left">
                     <%if(img.equals("")){ %>
                                 <img alt="" id="tou" src="${pageContext.request.contextPath}/mylogin/images/login_user.png" style="border-radius: 50%;width:90%;height:100%;cursor: pointer;">
                                <%}else{ %>
							    <img alt="" id="tou1" src="${img }"  style="border-radius: 50%;width:90%;height:100%;cursor: pointer;">
							     <%} %>

                  </div>
              </div>
             <div class="update" style="width:100%;height:25%;background-color:#acc">
               <div id="xiangxixinxi" style="padding:15px 0 0 15px;float:left;cursor: pointer;">详细信息</div>
               <div style="float:right;padding:15px 15px 0 0;cursor: pointer;" id="update_password">修改密码</div>
             </div>
          </div>
          <div class="left_top_left" style="width:40%;height:100%;padding:25px 0 0 25px;">
             <div class="time" id="time" style="width:100%;height:50%;"></div>
             <div class="tianqi" style="width:100%;height:50%;">
               <iframe name="weather_inc" src="http://i.tianqi.com/index.php?c=code&id=99" width="160" height="36" frameborder="0" marginwidth="0" marginheight="0" scrolling="no">
               </iframe>
             </div>
          </div>
      </div>
       <form action="${pageContext.request.contextPath}/Search?action=xiaoxi" method="post" style="width:68%;height:4%;margin:0 auto;">
					<input type="text"  name="search" style="width:80%;"/>
					<button type="submit" style="height:25px;padding:5px;">查找</button>
		</form>
      <div class="left_bottom" style="width:100%;height:72%;background-color:#eee;overflow:auto;">
          <%if(!tongzhi_list.isEmpty()){
	    	  for(Tongzhi map:tongzhi_list){ %>
	      <div style="width:100%;height:100px;background-color:#acc;border-bottom:1px solid #fff;padding:3px;">
	         <% Teacherusers teacherusers1=TiebaService.chauserbumenByBumen_id(map.getBumen_id());
                     %>
	          <p><%=teacherusers1.getName() %></p>
	          <div style="height:35px;padding-left:10px;">
	               <%if(map.getContent().length()>70){%>
	             <h5>
	              <%=map.getContent().substring(0, 70) %>......
	             </h5>
	               <%}else{ %>
	               <h5>
	              <%=map.getContent() %>
	             </h5>
	               <%} %>
	            </div>
	            <p style="float:right;cursor: pointer;" id="xiang<%=map.getId()%>">详情</p>
	            
	         
              <p><%=map.getTime() %></p>
	      </div>
	     <div id="xiangl<%=map.getId()%>" style="width:100%;height:400px;position:fixed;top:200px;display:none;padding:40px;">
             <div style="background-color:#ccc;width:600px;margin:0 auto;height:100%;position:relative;">
                  <div style="padding:30px;"><h5><%=map.getContent() %></h5></div>
             
                <div id="closel<%=map.getId() %>" style="position:absolute;right:0px;top:0px;border-radius:50%;width:30px;height:30px;">
                 <img src="${pageContext.request.contextPath}/home/images/close.png">
                </div>
            </div>
        </div>
	      <script>
								  document.getElementById('xiang<%=map.getId()%>').onclick = function() {
									 document.getElementById('xiangl<%=map.getId()%>').style.display="block";
								  };

									  document.getElementById('closel<%=map.getId() %>').onclick = function() {
											 document.getElementById('xiangl<%=map.getId()%>').style.display="none";
										  };
								</script>
	    	  <%}} %>

      </div>
  </div>
</div>
<div id="touxiang" style="width:100%;height:400px;position:fixed;top:200px;display:none;border-radius: 5px;padding:40px;">
    <div style="background-color:#ccc;width:600px;margin:0 auto;height:100%;position:relative;">
     <form id="uploadForm" action="${pageContext.request.contextPath}/Tou" method="post" name="tou" enctype="multipart/form-data">
        <div class="preview" style="margin:0 auto;">
		   <input type="file" id="uploadImg" onchange="xmTanUploadImg(this)" name="uploadImg" style="margin-top:10px;">
		</div>
		<center><img src="" alt="" id="selectImg" style="width:100px;height:100px;margin-top:10px;"></center>
		<div class="bt_box">
			<a class="gb" id="gb">关闭</a>
			<input type="submit" value="保存头像" class="queren">
		</div>
    </form>
        <div id="close" style="position:absolute;right:0px;top:0px;border-radius:50%;width:30px;height:30px;">
                 <img src="${pageContext.request.contextPath}/home/images/close.png">
        </div>
    </div>
</div>
<div id="xinxi1" style="width:100%;height:400px;position:fixed;top:200px;display:none;border-radius:5px;padding:40px;">
  
    <div style="background-color:#ccc;width:600px;margin:0 auto;height:100%;position:relative;">
     <form action="${pageContext.request.contextPath}/Update_xinxi" method="post" name="xinxi" enctype="multipart/form-data" style="margin:0 auto;width:300px;padding-top:20px;">
	    <div>学号:<input type="text" name="xuehao" value="<%=studentuser.getXuehao() %>"></div>   
		<div>姓名:<input type="text" name="name" value="<%=studentuser.getName() %>"></div>   
		<div>电话:<input type="text" name="phone" value="<%=studentuser.getPhone() %>"></div>   
		<div>q<a>&nbsp;</a>q<a>&nbsp;</a>:<input type="text" name="qq" value="<%=studentuser.getQq() %>"></div>   
		<div>专业:<input type="text" name="zhuanye" value="<%=studentuser.getZhuanye() %>"></div>   
        <div>班级:<input type="text" name="cla" value="<%=studentuser.getCla() %>"></div>   
        <div>寝室:<input type="text" name="qinshi" value="<%=studentuser.getQinshi() %>"></div> 
          
        <div>部门:<input type="text" name="qinshi" value="<%=studentuser.getQinshi() %>"></div>  
        <div>社团:<input type="text" name="qinshi" value="<%=studentuser.getQinshi() %>"></div>  
		<div class="bt_box" style="padding:5px;">
			<a class="gb" id="gb1">关闭</a>
			<input type="submit" value="保存修改" class="queren">
		</div>
    </form>
        <div id="close1" style="position:absolute;right:0px;top:0px;border-radius:50%;width:30px;height:30px;">
                 <img src="${pageContext.request.contextPath}/home/images/close.png">
        </div>
    </div>
    
</div>
<div id="password" style="width:100%;height:400px;border-radius:5px;position:fixed;top:200px;display:none;padding:40px;">
    <div style="background-color:#ccc;width:600px;margin:0 auto;height:100%;position:relative;">
     <form action="${pageContext.request.contextPath}/Update_password" method="post" style="margin:0 auto;width:300px;padding-top:20px;">
	          <div><a>&nbsp;</a>新<a>&nbsp;</a>密<a>&nbsp;</a>码:<a>&nbsp;</a><input type="password" name="new_password"></div>
		     <div>确认密码:<a>&nbsp;</a><input type="password" name="sure_password"></div>  
		<div class="bt_box" style="padding:5px;margin-top:200px;">
			<a class="gb" id="gb2">关闭</a>
			<input type="submit" value="保存修改" class="queren">
		</div>
    </form>
        <div id="close2" style="position:absolute;right:0px;top:0px;border-radius:50%;border-radius:50%;width:30px;height:30px;">
                 <img src="${pageContext.request.contextPath}/home/images/close.png">
        </div>
    </div>
</div>
<form name="form2" style="display:none;">
  
</form>
	<script>
	function getRTime(){
        var NowTime = new Date();
        var d=NowTime.toLocaleDateString();
        var x=NowTime.getDay();
        var t =NowTime.toLocaleTimeString();
        var weekday=["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
        document.getElementById("time").innerHTML =weekday[x]+"<br><br><br>"+d+"<br><br><br>"+t;
    }
    setInterval(getRTime,1000);
    
    var touxiang=document.getElementById('touxiang'),
        close=document.getElementById('close'),
        close1=document.getElementById('close1'),
        gb1=document.getElementById('gb1'),
        close2=document.getElementById('close2'),
        gb2=document.getElementById('gb2'),
        update_password=document.getElementById('update_password'),
        password=document.getElementById('password'),
        xinxi1=document.getElementById('xinxi1'),
        xiangxixinxi=document.getElementById('xiangxixinxi'),
       tou=document.getElementById('tou'),
        gb=document.getElementById('gb');
       tou.onclick = function() {
			touxiang.style.display = "block";
		};
	  close.onclick = function() {
			touxiang.style.display = "none";
		};
		 gb.onclick = function() {
				touxiang.style.display = "none";
			};
			close1.onclick = function() {
				xinxi1.style.display = "none";
			};
			 gb1.onclick = function() {
					xinxi1.style.display = "none";
				};
				close2.onclick = function() {
					password.style.display = "none";
				};
				 gb2.onclick = function() {
						password.style.display = "none";
					};
					update_password.onclick=function(){
						password.style.display="block";
					}
				xiangxixinxi.onclick = function() {
					xinxi1.style.display = "block";
				};
				
		function xmTanUploadImg(obj) {
		
		    var file = obj.files[0];
		    var reader = new FileReader();
		    reader.readAsDataURL(file);
		    reader.onload = function (e) {  
		        var img = document.getElementById("selectImg");
		        var tou = document.getElementById("tou");
		        var tou1 = document.getElementById("tou1");
		        img.src = e.target.result;  
                /*tou.src=e.target.result;
                tou1.src=e.target.result;*/
		       
		    };
		}
	</script>

</body>
<!-- //Body -->
</html>