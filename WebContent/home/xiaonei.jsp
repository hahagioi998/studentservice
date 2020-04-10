<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<!-- Head -->
<%@ page language="java" contentType="text/html;charset=utf-8" import="java.util.*" import="swu.zhj.model.*" import="swu.zhj.service.UserService"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path=request.getContextPath();
    String name=(String)session.getAttribute("name");
    int id=(Integer)session.getAttribute("id");
    String img=(String)session.getAttribute("img");
    String shen=(String)session.getAttribute("shen");
    
    List<Bumen_baoming> bumen_baoming_list=new ArrayList<Bumen_baoming>();
    bumen_baoming_list=(ArrayList<Bumen_baoming>)request.getAttribute("bumen_baoming_list");
    
    List<Shetuan_baoming> shetuan_baoming_list=new ArrayList<Shetuan_baoming>();
    shetuan_baoming_list=(ArrayList<Shetuan_baoming>)request.getAttribute("shetuan_baoming_list");
    
    List<Lunbo> lunbo_list=new ArrayList<Lunbo>();
    lunbo_list=(ArrayList<Lunbo>)request.getAttribute("lunbo_list");
    
    List<Home_nongchang> home_nongchang_list=new ArrayList<Home_nongchang>();
    home_nongchang_list=(ArrayList<Home_nongchang>)request.getAttribute("home_nongchang_list");
    
    List<Home_data> home_data_list=new ArrayList<Home_data>();
    home_data_list=(ArrayList<Home_data>)request.getAttribute("home_data_list");
    
    List<Home_yin> home_yin_list=new ArrayList<Home_yin>();
    home_yin_list=(ArrayList<Home_yin>)request.getAttribute("home_yin_list");
   // List<Map<String,Object>> list_lunbo=(List<Map<String,Object>>)request.getAttribute("list_lunbo");
%>
<head>
<title>校内导航</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="" />

<!-- Default-JavaScript-File -->
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/bootstrap.js"></script>
<!-- //Default-JavaScript-File -->

<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/mainStyles.css" /><!-- for banner -->

<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/flexslider.css" type="text/css" media="screen" property="" /><!-- for testimonials -->

<!-- Property for sale section css files-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/owl.carousel.css" type="text/css" media="all">
<link href="${pageContext.request.contextPath}/home/css/owl.theme.css" rel="stylesheet">
<!-- //Property for sale section css files -->

<!-- for team section tabs -->
<link href="${pageContext.request.contextPath}/home/css/easy-responsive-tabs.css" rel='stylesheet' type='text/css'/>
<!-- // for team section tabs -->

<!-- default css files -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/bootstrap.css" type="text/css" media="all">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/style.css" type="text/css" media="all">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/font-awesome.min.css" />
<!-- default css files -->
	
<!--web font-->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Hind:300,400,500,600,700&amp;subset=devanagari,latin-ext" rel="stylesheet">
<!--//web font-->
	
<!-- scrolling script -->
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script> 
<!-- //scrolling script -->

<!-- Property for sale section Script-->
<script>
$(document).ready(function() { 
	$("#owl-demo").owlCarousel({
 
		autoPlay: 3000, //Set AutoPlay to 3 seconds
		autoPlay:true,
		items : 3,
		itemsDesktop : [640,5],
		itemsDesktopSmall : [414,4]
 
	});
	
}); 
</script>
<!-- //Property for sale section Script-->
<style>
body{
    background-color:#abc;
}
.team{
   background:url("${pageContext.request.contextPath}/home/images/bg02.jpg");
   background-repeat:no-repeat;
     background-size:100% 100%;  
}
.baomingbiao{
  width:100%;
  height:400px;
  position:fixed;
  top:200px;
  display:none;
  
  }
.baoming{
 font-size:18px;
 border:1px solid #000000;
 width:100px;
 height:30px;
 padding-top:7px;
 display:block;
 background-color: #ccc;
}
.baoming:hover {
    background-color:#bbb;
}
.flag_baoming{
       cursor: pointer;
   margin-top:10px;
   padding:5px;
   width:100%;
   height:25px;
   display:block;
   /*margin:0 auto;*/
   border:1px solid #ccc;
   background-color: #bbb;
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

<!-- team -->
	<div class="team" id="team" style="padding-top:150px;">
			<h3 class="heading"><span>部门</span></h3>
			<%if(shen.equals("student")){ %>
						   <center  style="font-size:20px; cursor: pointer;"><a id="baoming" class="baoming">参加报名</a></center>
						   <%} %>
		<div class="container">
			<div class="inner_w3l_agile_grids">
				<div id="horizontalTab">
						<ul class="resp-tabs-list">
						<%if(!home_nongchang_list.isEmpty()){
	    	  for(Home_nongchang map:home_nongchang_list){ %>
						<li>
							<img src="${pageContext.request.contextPath}/home/images/<%=map.getImage() %>" alt=" " class="img-responsive" />
						</li>
						<%
						}
	    	          }%>
						</ul>
						<!-- 点击参加报名需要验证是否登录，如果未登录，则提示登录，已登录则弹出窗口 -->
						
						<div class="resp-tabs-container">
						<%if(!home_nongchang_list.isEmpty()){
	    	  for(Home_nongchang map:home_nongchang_list){ %>
							<div class="<%=map.getCla() %>">
								<div class="col-md-6 team-img-w3-agile" style="background:url(${pageContext.request.contextPath}/home/images/<%=map.getImage() %>) no-repeat 0px 0px;background-size:cover;width:300px;min-height:300px;border-radius:50%;"></div>
								<div class="col-md-6 team-Info-agileits">
									<h4><%=map.getTitle() %></h4>
									<p><%=map.getContent() %></p>
								</div>
								
								<div class="clearfix"> </div>
						    </div>
							<%}
	    	                 }%>
							
				</div>
			</div>
		</div>
	</div>
</div>
<!-- //team -->

<!--count-->
<div class="count-agileits" id="stats">
	<h3 class="heading"><span>位置</span></h3>
		<div class="container">
					<div class="count-grids">
					<div class="count-bgcolor-w3ls">
					<%if(!home_data_list.isEmpty()){
	    	  for(Home_data map:home_data_list){ %>
						<div class="col-md-3 count-grid">
							<div class="count hvr-bounce-to-bottom">
								<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='<%=map.getMax_data() %>' data-delay='.5' data-increment="1"><%=map.getMax_data() %></div>
									<span></span>
									<br>
									<h5><%=map.getH5() %></h5>
							</div>
						</div>
						<%}
	    	            }%>
						<div class="clearfix"></div>
						</div>
					</div>
	</div>
</div>
<!--count-->

<!-- property for sale -->
<div class="special" id="offers">
	<h3 class="heading"><span>社团</span></h3>
		<div class="container">
			<div class="agileits-special-grids">
				<div id="owl-demo" class="owl-carousel owl-theme">
				<%if(!home_yin_list.isEmpty()){  
	    	  for(Home_yin map:home_yin_list){ 
	    		  int t=0;
	    	  %>
	    	      
					<div class="item">
						<div class="special-info" style="background: url(${pageContext.request.contextPath}/home/images/<%=map.getImage() %>) no-repeat 0px 0px;background-size: cover;">
							<div class="special-info-top">
								<div class="special-star">
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star" aria-hidden="true"></i>
								</div>
								<h4><%=map.getTitle() %></h4>
							</div>
							<div class="special-info-bottom">
							  <div style="height:200px;"><%=map.getJian() %></div> 
								<p><span class="glyphicon glyphicon-phone" aria-hidden="true"></span>联系电话：<%=map.getPhone() %></p>
								<p><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>营业地址：<%=map.getAdr() %></p>
								  
								   <% 
								    if(shen.equals("student")){
								      if(!shetuan_baoming_list.isEmpty()){
	    		                         for(Shetuan_baoming map1:shetuan_baoming_list){
	    			                     if(map.getId()==map1.getShetuan_id()){
	    			                        t=1;
	    			                        }
	    			                     }
	    		                      }
	    			                   if(t==1){%>
								      <center><a class="flag_baoming">已报名</a></center> 
								       <% }else{
								        if(name!=null){ %>
								           <center> <a class="flag_baoming" href="${pageContext.request.contextPath}/Shetuanbaoming?shetuan_id=<%=map.getId() %>">点击报名</a></center> 
								           <% }else{%>
								         <center>   <a class="flag_baoming" href="${pageContext.request.contextPath}/mylogin/login.jsp">点击报名</a></center> 
								          <%}
								        }
	    			                   } %>
							</div>
						</div>	
					</div>
					<%}
	    	  }%>
				</div>
			</div>
		</div>
</div>
<!-- //property for sale -->

<!-- testimonials -->		
	<div class="testimonials" id="testimonials">
		<div class="w3layouts_event_right">
			<h3 class="heading"><span>what people says</span></h3>
			<section class="slider">
				<div class="flexslider">
					<ul class="slides">
						<li>
							<div class="col-md-4 w3_event_right_grid">
								<div class="w3_agile_event_right_grids">
									<div class="col-xs-4 w3_agile_event_right_grid_left">
										<img src="images/t1.jpg" alt=" " class="img-responsive" />
									</div>
									<div class="col-xs-8 w3_agile_event_right_grid_right">
										<h4>Williamson</h4>
										<p><i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star-half-o" aria-hidden="true"></i></p>
									</div>
									<div class="clearfix"> </div>
								</div>
								<div class="w3layouts_event_right_para">
									<p>Nam tempus lobortis sem non ornare. Curabitur dignissim interdum sem, et mollis lorem. 
										Mauris hendrerit, mi in aliquet egestas, nisi mi turpis.</p>
								</div>
							</div>
							<div class="col-md-4 w3_event_right_grid">
								<div class="w3_agile_event_right_grids">
									<div class="col-xs-4 w3_agile_event_right_grid_left">
										<img src="images/t2.jpg" alt=" " class="img-responsive" />
									</div>
									<div class="col-xs-8 w3_agile_event_right_grid_right">
										<h4>jennifer lopez</h4>
										<p><i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star-half-o" aria-hidden="true"></i></p>
									</div>
									<div class="clearfix"> </div>
								</div>
								<div class="w3layouts_event_right_para">
									<p>Nam tempus lobortis sem non ornare. Curabitur dignissim interdum sem, et mollis lorem. 
										Mauris hendrerit, mi in aliquet egestas, nisi mi turpis.</p>
								</div>
							</div>
							<div class="col-md-4 w3_event_right_grid">
								<div class="w3_agile_event_right_grids">
									<div class="col-xs-4 w3_agile_event_right_grid_left">
										<img src="images/t3.jpg" alt=" " class="img-responsive" />
									</div>
									<div class="col-xs-8 w3_agile_event_right_grid_right">
										<h4>Selena Gomez</h4>
										<p><i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star-half-o" aria-hidden="true"></i></p>
									</div>
									<div class="clearfix"> </div>
								</div>
								<div class="w3layouts_event_right_para">
									<p>Nam tempus lobortis sem non ornare. Curabitur dignissim interdum sem, et mollis lorem. 
										Mauris hendrerit, mi in aliquet egestas, nisi mi turpis.</p>
								</div>
							</div>
							<div class="clearfix"></div>
						</li>
						<li>
							<div class="col-md-4 w3_event_right_grid">
								<div class="w3_agile_event_right_grids">
									<div class="col-xs-4 w3_agile_event_right_grid_left">
										<img src="images/t4.jpg" alt=" " class="img-responsive" />
									</div>
									<div class="col-xs-8 w3_agile_event_right_grid_right">
										<h4>Catherine Mark</h4>
										<p><i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star-half-o" aria-hidden="true"></i></p>
									</div>
									<div class="clearfix"> </div>
								</div>
								<div class="w3layouts_event_right_para">
									<p>Nam tempus lobortis sem non ornare. Curabitur dignissim interdum sem, et mollis lorem. 
										Mauris hendrerit, mi in aliquet egestas, nisi mi turpis.</p>
								</div>
							</div>
							<div class="col-md-4 w3_event_right_grid">
								<div class="w3_agile_event_right_grids">
									<div class="col-xs-4 w3_agile_event_right_grid_left">
										<img src="images/t5.jpg" alt=" " class="img-responsive" />
									</div>
									<div class="col-xs-8 w3_agile_event_right_grid_right">
										<h4>Victoria demi </h4>
										<p><i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star-half-o" aria-hidden="true"></i></p>
									</div>
									<div class="clearfix"> </div>
								</div>
								<div class="w3layouts_event_right_para">
									<p>Nam tempus lobortis sem non ornare. Curabitur dignissim interdum sem, et mollis lorem. 
										Mauris hendrerit, mi in aliquet egestas, nisi mi turpis.</p>
								</div>
							</div>
							<div class="col-md-4 w3_event_right_grid">
								<div class="w3_agile_event_right_grids">
									<div class="col-xs-4 w3_agile_event_right_grid_left">
										<img src="images/t6.jpg" alt=" " class="img-responsive" />
									</div>
									<div class="col-xs-8 w3_agile_event_right_grid_right">
										<h4>Kate perry</h4>
										<p><i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star" aria-hidden="true"></i>
										<i class="fa fa-star-half-o" aria-hidden="true"></i></p>
									</div>
									<div class="clearfix"> </div>
								</div>
								<div class="w3layouts_event_right_para">
									<p>Nam tempus lobortis sem non ornare. Curabitur dignissim interdum sem, et mollis lorem. 
										Mauris hendrerit, mi in aliquet egestas, nisi mi turpis.</p>
								</div>
							</div>
							<div class="clearfix"></div>
						</li>
					</ul>
				</div>
			</section>
		</div>
		<div class="clearfix"> </div>
	</div>
<!-- //testimonials -->	

<!-- footer -->
<div class="footer">

	<div class="col-md-6 copyright">
		<ul>
			<li><a href="#home" class="scroll">Home</a></li>
			<li><a href="#about" class="scroll">About</a></li> 
			<li><a href="#services" class="scroll">Services</a></li> 
			<li><a href="#stats" class="scroll">Stats</a></li> 
			<li><a href="#team" class="scroll">Agents</a></li> 
			<li><a href="#testimonials" class="scroll">Testimonials</a></li>
		</ul>
		<p>Copyright &copy; 2017.Company name All rights reserved.</p>
	</div>
	<div class="clearfix"></div>
</div>
<!-- //footer -->
 <div id="baomingbiao" class="baomingbiao">
    <div style="background-color:#ccc;width:600px;margin:0 auto;height:100%;position:relative;border-radius:5px;padding:40px;">
       <%if(name!=null){
    	   if(!bumen_baoming_list.isEmpty()){
 	    	  for(Bumen_baoming map1:bumen_baoming_list){ %>
 	    	     <center>
 	    	        <h4>${name } 已报名</h4><br><br><br><br>
            	    <h4>第一志愿：<%=map1.getFirst() %></h4> 
            	    <br>
            	    <h4>第二志愿：<%=map1.getTwo()%></h4>
            	    <br>
            	    <h4>是否服从调剂：<%=map1.getTiao()%></h4>
            	 </center>
              <%}}else{%>
                    
       <!-- 得到用户是否报名或参加部门的信息，如果已报名则显示报名的信息，如果未报名，则显示报名表 -->
       <form method="post" action="${pageContext.request.contextPath}/Zhiyuan">
        <div class="right" style="width:50%;height:100%;float:right;">
           <h3>第二志愿</h3><br>
           <input name="two" type="radio" checked="checked" value="部门一  "/>部门一  
           <br><br>
           <input name="two" type="radio" value="部门二  "/>部门二
           <br><br>
           <input name="two" type="radio" value="部门三"/>部门三
           <br><br>
           <input name="two" type="radio" value="部门四 "/>部门四
           <br><br>
           <input name="two" type="radio" value="部门五"/>部门五
           <br><br>
           <input name="two" type="radio" value="部门六"/>部门六
           <br><br>
           <input name="two" type="radio" value="部门七 "/>部门七
           <br><br>
           <input name="two" type="radio" value="部门八  "/>部门八
        </div>
       <div class="left" style="width:50%;height:100%;float:left;">
          <h3>第一志愿</h3><br>
           <input name="first" type="radio" checked="checked" value="部门一  "/>部门一  
           <br><br>
           <input name="first" type="radio" value="部门二  "/>部门二
           <br><br>
           <input name="first" type="radio" value="部门三  "/>部门三
           <br><br>
           <input name="first" type="radio" value="部门四 "/>部门四
           <br><br>
           <input name="first" type="radio" value="部门五  "/>部门五
           <br><br>
           <input name="first" type="radio" value="部门六"/>部门六
           <br><br>
           <input name="first" type="radio" value="部门七  "/>部门七
           <br><br>
           <input name="first" type="radio" value="部门八  "/>部门八
       </div>
        <br><br>
        <div style="width:100%;height:100px;top:300px;position:absolute;">
           <h3>是否服从调剂</h3><br>
           <input name="tiao" type="radio" value="是 "  checked="checked"/>是
           <br><br>
           <input name="tiao" type="radio" value="否"/>否
        </div>
        <br><br>
        <input type="submit" style="height:30px;padding-bottom:7px;position:absolute;bottom:30px;right:250px;">
           
      
      </form> 
      <%}
       }else{
      %>
      <p>请登录</p>
      <%} %>
        <div id="close" style="position:absolute;right:0px;top:0px;border-radius:50%;width:30px;height:30px;">
             <img src="${pageContext.request.contextPath}/home/images/close.png">
        </div>
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
		var baoming=document.getElementById('baoming'),
		    close=document.getElementById('close'),
		   baomingbiao=document.getElementById('baomingbiao');
		   baoming.onclick = function() {
	   			baomingbiao.style.display = "block";
	   		};
	   	  close.onclick = function() {
	   			baomingbiao.style.display = "none";
	   		};
	       
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