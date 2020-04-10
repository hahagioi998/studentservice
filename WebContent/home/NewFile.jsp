<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<!-- Head -->
<%@ page language="java" contentType="text/html;charset=utf-8" import="java.util.*" import="swu.zhj.model.*"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String name=(String)session.getAttribute("name");
    int o2=(Integer)session.getAttribute("o2");
    String img=(String)session.getAttribute("img");
    
   List<Newstudent_jiben> list_newstudent_jiben=new ArrayList<Newstudent_jiben>();
    list_newstudent_jiben=(ArrayList<Newstudent_jiben>)request.getAttribute("list_newstudent_jiben");
   
%>
<head>
<title>新生栏</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/owl.carousel.css" type="text/css" media="all">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/bootstrap.css" type="text/css" media="all">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/style.css" type="text/css" media="all">

<style>
.all{
  width:100%;
  margin:0 auto;
  position:absolute;
  top:0px;
  left:0;
  text-align: center;
  background-color:#abc;
  height:100%;
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
  height:450px;
  text-align: center;
  background-color:#eee;
}
</style>
</head>
<body>
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
						<li><a href="#team"><span data-hover="兼职栏">兼职栏</span></a></li>
						<li><a href="#contact" class="scroll"><span data-hover="联系我们">联系我们</span></a></li>
					</ul>
				</nav>
			</div>
					<div class="agileits-social top_content">
						<ul>
							<li>
							<%if(name!=null){
                             %>
                                <a href="${pageContext.request.contextPath}/Student_User">欢迎${name}</a>
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
<div class="all">
   <div class="liucheng"> 
      <img src="${pageContext.request.contextPath}/home/images/banner1.jpg" style="width:100%;height:100%">
   </div>
   <div class="sousuo">
      <div style="width:50%;height:50%;background-color:#ddd;margin:0 auto;padding:40px;">
        <h3>学生信息搜索</h3>
         <form class="new_search" action="${pageContext.request.contextPath}/NewstudentSearch" method="post" style="margin-top:25px; ">
					<input class="" type="text" name="search" style="height:34px;width:300px;" placeholder="请输入身份证号码"/>
					<button type="submit" class="btn btn-danger">查找</button>
	     </form>
      </div>
       <%if(!list_newstudent_jiben.isEmpty()){
	    	  for(Newstudent_jiben map:list_newstudent_jiben){ %>
	       <div>		  
	           <h4>身份证号：<%=map.getIdcard() %></h4>
			   <h4>姓名：<%=map.getName() %></h4>
			   <h4>学号：<%=map.getXuehao() %></h4>
			   <h4>专业：<%=map.getZhuanye() %></h4>
			   <h4>年级：<%=map.getNianji() %></h4>
			   <h4>班级：<%=map.getCla() %></h4>
			   <h4>寝室：<%=map.getQinshi() %></h4>
			  
		  </div>
	    	  <%
	    	    }
	    	  }
       else{%>	
	    	     <h4>未找到相关信息！</h4>
	    	  <%} %>
   </div>
</div>

 
	
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/numscroller-1.0.js"></script><!-- numscroller js file -->

<!-- property for sale js file-->
<script src="${pageContext.request.contextPath}/home/js/owl.carousel.js"></script>
<!-- //property for sale js file-->
	
<!-- flexSlider --><!-- testimonials -->
<script defer src="${pageContext.request.contextPath}/home/js/jquery.flexslider.js"></script>
	<script type="text/javascript">
		$(window).load(function(){
		  $('.flexslider').flexslider({
			animation: "slide",
			start: function(slider){
			  $('body').removeClass('loading');
			}
		  });
		});
	</script>
<!-- //flexSlider --><!-- //testimonials -->
 
<!-- banner slider js files -->
<script src="${pageContext.request.contextPath}/home/js/mainScript.js"></script>
<script src="${pageContext.request.contextPath}/home/js/rgbSlide.min.js"></script>
<!-- // banner slider js files -->

<!--tabs--><!-- for team -->
	<script src="${pageContext.request.contextPath}/home/js/easy-responsive-tabs.js"></script>
	<script>
	$(document).ready(function () {
	$('#horizontalTab').easyResponsiveTabs({
	type: 'default', //Types: default, vertical, accordion           
	width: 'auto', //auto or any width like 600px
	fit: true,   // 100% fit in a container
	closed: 'accordion', // Start closed if in accordion view
	activate: function(event) { // Callback function if tab is switched
	var $tab = $(this);
	var $info = $('#tabInfo');
	var $name = $('span', $info);
	$name.text($tab.text());
	$info.show();
	}
	});
	$('#verticalTab').easyResponsiveTabs({
	type: 'vertical',
	width: 'auto',
	fit: true
	});
	});
	</script>
<!--//tabs--><!-- //for team -->

<!-- Here stars scrolling -->
	<script src="${pageContext.request.contextPath}/home/js/SmoothScroll.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/move-top.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/easing.js"></script>
	<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
	<!-- //here ends scrolling icon -->
<!-- Here ends scrolling -->

</body>
<!-- //Body -->
</html>