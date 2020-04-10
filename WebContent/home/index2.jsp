<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<!-- Head -->
<%@ page language="java" contentType="text/html;charset=utf-8" import="swu.zhj.service.TiebaService" import="java.util.*" import="swu.zhj.util.*" import="swu.zhj.model.*"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path=request.getContextPath();
    String name=(String)session.getAttribute("name");
    int id=(Integer)session.getAttribute("id");
    String img=(String)session.getAttribute("img");
    String shen=(String)session.getAttribute("shen");
    System.out.println(id);
	session.setAttribute("id", id);
	session.setAttribute("img", img);
	session.setAttribute("name", name);
    
   List<Jianzhis> jianzhi_list=new ArrayList<Jianzhis>();
   jianzhi_list=(ArrayList<Jianzhis>)request.getAttribute("jianzhi_list");
   DividePage pUtil=(DividePage)request.getAttribute("pUtil");
%>
<head>
<title>兼职栏</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="" />

<!-- Property for sale section css files-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/owl.carousel.css" type="text/css" media="all">

<!-- default css files -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/bootstrap.css" type="text/css" media="all">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/style.css" type="text/css" media="all">
<style>
  html{
  height:100%;}
.zong{
     
     background:url("${pageContext.request.contextPath}/home/images/bg05.jpg");
     background-repeat:no-repeat;
     background-size:100% 100%;  
}
</style>
<script type="text/javascript">
  function dosubmit(){
	  var th=document.form1;
	  <%if(name==null){ %>
	    alert("登录后才可以发表说说和评论!");
	  <%}else {%>
	    //createInput('name','text',${name})
	    th.submit(); 
	  <%} %>
  }
  function huifu(){
	  var th1=document.form2;
	  <%if(name==null){ %>
	    alert("登录后才可以发表评论!");
	  <%}else {%>
	    //createInput('name','text',${name})
	    th1.submit(); 
	  <%} %>
  }
  function show(oEvent){
	  document.getElementById("a").style.display="block";
	  e=window.event||oEvent;
	  if(e.stopPropagation){
		    e.stopPropagation();
	     }else{
	         e.cancelBubble = true;
	     }
     }
  function first() {
      var th=document.form1;
      th.action="${pageContext.request.contextPath}/Jianzhi?pageNum=1"; //需要给提交加标志位，区分提交的是什么
      th.submit();
  }
  function forward() {
      var th=document.form1;
      th.action="${pageContext.request.contextPath}/Jianzhi?pageNum=<%=pUtil.getCurrentPage()-1%>"; //需要给提交加标志位，区分提交的是什么
      th.submit();
  }
  function next() {
      var th=document.form1;
      th.action="${pageContext.request.contextPath}/Jianzhi?pageNum=<%=pUtil.getCurrentPage()+1%>"; //需要给提交加标志位，区分提交的是什么
      th.submit();
  }
  function end() {
      var th=document.form1;
      th.action="${pageContext.request.contextPath}/Jianzhi?pageNum=<%=pUtil.getPageCount()%>"; //需要给提交加标志位，区分提交的是什么
      th.submit();
  }
  function changePage(currentPage) {
	  window.location.href="${pageContext.request.contextPath}/Jianzhi?pageNum="+currentPage
    /*  var th=document.form1;
      th.action="${pageContext.request.contextPath}/Jianzhi?pageNum="+currentPage; //需要给提交加标志位，区分提交的是什么
      th.submit();*/
  }
</script>
</head
<body>
<!-- banner -->
	<div class="banner" id="home">
		<nav class="navbar navbar-default">
			<div class="navbar-header navbar-left">
				<h1><a class="navbar-brand" href="index.html"><span>Student</span>services</a></h1>
					<i class="fa fa-home" aria-hidden="true"></i>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="navbar-right" id="bs-example-navbar-collapse-1">
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
							<li><a><img alt="" src=""></a></li>
							<li><a><img alt="" src=""></a></li>
						</ul>
					</div>
		</nav>
		</div>
      <div class="zong" style="width:100%;height:1228px;padding-top:125px;">
         <div class="all" style="width:70%;height:100%;margin:0 auto;" >
            <form action="${pageContext.request.contextPath}/Search?action=jianzhi" method="post" style="float:right;width:250px;height:30px;margin-top:0x;padding:6px;">
                          <input type="text" name="search" width:200px;>
                          <input type="submit" value="搜索" style="height:26px;border-radius:5px;" >
            </form>
            <div class="daohang" style="width:40%;height:40px;padding:10px;margin:0 auto;">
               <ul style="float:left;margin-top:5px;">
                  <li style="float:left;list-style:none;margin-left:50px;"> <a href="${pageContext.request.contextPath}/Jianzhi" style="color:#fff;">最新</a></li>
                  <li style="float:left;list-style:none;margin-left:50px;"> <a href="${pageContext.request.contextPath}/Jianzhi?biao=jing" style="color:#fff;">精品</a></li>
                  <li style="float:left;list-style:none;margin-left:50px;"><a href="${pageContext.request.contextPath}/Jianzhi?biao=zan" style="color:#fff;">热门</a></li>
                  <li style="float:left;list-style:none;margin-left:50px;">分类</li>
          
               </ul>
            </div>
           
            <div class="content">
            <%if(!jianzhi_list.isEmpty()){
	    	  for(Jianzhis map:jianzhi_list){ %>
                <div style="width:100%;height:200px">
                    <div style="float:right;background-color:#ccc;width:20%;height:100%;padding:5px;">
                        <img src="${pageContext.request.contextPath}/<%=map.getImg()%>" style="width:100%;height:100%;">
                    </div>
                    <div style="float:left;background-color:#aaa;width:80%;height:100%;padding:5px;border-bottom:1px solid #fff">
                       <h4><%=map.getTitle() %></h4>
                       <div style="width:90%;margin:0 auto;height:160px;padding:4px;"><h5><%=map.getContent() %></h5></div>
                       <div>
                         <div style="float:right"><%=map.getTime() %></div>
                         
                         <div style="float:left">
                         <%if(shen.equals("student")){ %>
                            <a href="${pageContext.request.contextPath}/Zan?id=<%=map.getId()%>&zan=<%=map.getZan()%>">点赞&#10084;</a><%=map.getZan() %>
                       <%}else{ %>
                            <a>点赞&#10084;</a><%=map.getZan() %>
                            <%} %>
                        </div>
                         
                         <center><a href="${pageContext.request.contextPath}/<%=map.getHref()%>" >了解更多&#10148;</a></center>
                       </div>
                    </div>
                </div>
                <%}} %>
            </div>
            <form name="form1" method="post">
            
            </form>
            <table width="100%" border="0" cellpadding="4" cellspacing="0" style="margin:10px 0 10px 0;">
                               <tbody>
                                <tr bgcolor="#ffffff" height="20">
                                    <td height="20" align="center" valign="middle" nowrap>
                                        <span class="style7">共<%=pUtil.getPageCount()%>页</span>&nbsp;
                                        <a href="${pageContext.request.contextPath}/Jianzhi?pageNum=1" class="dh2">首页</a>&nbsp;
                                        <a href="${pageContext.request.contextPath}/Jianzhi?pageNum=<%=pUtil.getCurrentPage()-1%>" class="dh2">上一页</a>&nbsp;
                                        <a href="${pageContext.request.contextPath}/Jianzhi?pageNum=<%=pUtil.getCurrentPage()+1%>" class="dh2">下一页</a>&nbsp;
                                        <a href="${pageContext.request.contextPath}/Jianzhi?pageNum=<%=pUtil.getPageCount()%>" class="dh2">尾页</a>&nbsp;
                                        <span class="style7">跳转到</span>
                                        <select name="select" id="" class="text2" style="width: 40px" onchange="changePage(this.value)">
                                            <%
                                              int len=pUtil.getPageCount();
                                              for(int i=1;i<=len;i++){
                                            %>
                                            <option value="<%=i %>" <%=(i==pUtil.getCurrentPage()?"selected":"") %>>  <!--selected表示选中-->
                                                <%=i %>
                                            </option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </td>
                                </tr>
                               </tbody>
                           </table>
         </div>
         
      </div>
</body>
<!-- //Body -->
</html>