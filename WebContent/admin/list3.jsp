<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*" import="swu.zhj.model.*" import="swu.zhj.service.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%
 Admin admin=(Admin)session.getAttribute("admin");
 String shen=(String)session.getAttribute("shen");
 session.setAttribute("shen", shen);
 session.setAttribute("admin", admin);
    
    List<Studentusers> student_user_list=new ArrayList<Studentusers>();
    student_user_list=(ArrayList<Studentusers>)request.getAttribute("student_user_list");
    session.setAttribute("student_user_list", student_user_list);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>bootstrapTable</title>
<!-- 必要css包 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/admin/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/admin/css/bootstrap-theme.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-table.js"></script>
<script src="js/bootstrap-table-zh-CN.js"></script>
</head>
<body>
    
    <div class="container-fluid">
        <h2>学生用户管理</h2>
		<div class="row-fluid">
			<div class="span12">
				<form class="form-search" action="${pageContext.request.contextPath}/Search?action=lunbo" method="post">
					<input class="input-medium search-query" type="text"/>
					<button type="submit" class="btn btn-danger" name="search">查找</button>
				</form>
				<div>
				    <form id="file_form" action="${pageContext.request.contextPath}/Daoru_Student_user" enctype="multipart/form-data" method="post"
				    style="width:50%;height:80px;float:right;">
                    <p> 导入excel表数据：</p>
                     <div>
                        <input type="file" name="file1" id="file1"/> 
                        <input type="submit" value="文件上传" id='upFile-btn'>
                      </div>
                   </form>
                  <div style="width:50%;height:80px;float:left;">
                   <p>将数据导出成excel:</p>
                   <a href="${pageContext.request.contextPath}/shiyan2" style="display:block;margin-left:50px;width:35px;height:20px;background-color: #ccc;border-radius: 2px;">导出</a>
                  </div>
				</div>
				<center><a id="qunfa" style="display:block;width:80px;height:20px;background-color: #ccc;margin-top:90px;border-radius: 2px;">群发消息</a></center>
				<table class="table">
					<thead>
						<tr>
						<th> <input type="checkbox" id="checkAll" onclick="checkAll()"/>全选/全不选</th>
							<th>编号</th>
							<th>姓名</th>
							<th>专业</th>
							<th>班级</th>
							<th>学号</th>
							<th>电话</th>
							<th>qq</th>
							<th>寝室</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<form action="${pageContext.request.contextPath}/Send?action=student" method="post">
					   <div id="qunfa_content" style="background-color:#ccc;position:fixed;top:100px;right:35%;width:520px;height:280px;display:none;padding:10px;">
			
					    选择方式：<input name="method" type="radio" checked="checked" value="zhannei"/>站内方式 
                        <input name="method" type="radio" value="qq"/>qq邮件
                        <br>
                        <span>标题：</span><textarea rows="2" cols="53" name="title"></textarea>
                        <textarea rows="18" cols="60" style="width:500px;height:200px;" name="content">内容。。。</textarea>
                         <a id="close_qunfa" style="float:right;display:block;background-color: #fff;width:44px;height:26px;padding:1px 6px;border-width:2px;;border-radius: 3px;cursor: pointer;"> 取消</a>
                        <button type="submit">发表</button>
                       </div>
                     </form>
					     <%if(!student_user_list.isEmpty()){
	    	             for(Studentusers map:student_user_list){ %>
							<tr>
							    <td><input type="checkbox" name="tongzhi" value="<%=map.getXuehao() %>"></td>
								<td><%=map.getId() %></td> 
								<td><%=map.getName() %></td>
								<td><%=map.getZhuanye() %></td>
								<td><%=map.getNianji()%>级<%=map.getCla() %>班</td>
								<td><%=map.getXuehao() %></td>
								<td><%=map.getPhone() %></td>
								<td><%=map.getQq() %></td>
								<td><%=map.getQinshi() %></td>
								<td><a href="${pageContext.request.contextPath}/Delete?jianzhi_id=<%=map.getId() %>&action=student">删除</a>
								</td>
                              
							</tr>
								<%}} %>
								<script>
								  document.getElementById('qunfa').onclick = function() {
									 document.getElementById('qunfa_content').style.display="block";
								  };
								  document.getElementById('close_qunfa').onclick = function() {
										 document.getElementById('qunfa_content').style.display="none";
									  };
							</script>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script>
           document.getElementById('checkAll').onclick=function(){
        	   var checkAllEle=document.getElementById('checkAll');
        	   var checkOnes=document.getElementsByName('tongzhi');
        	
        	   if(checkAllEle.checked==true){
        		   for(var i=0;i<checkOnes.length;i++){
        			   checkOnes[i].checked=true;
        		   }
        	   }else{
        		   for(var i=0;i<checkOnes.length;i++){
        			   checkOnes[i].checked=false;
        		   }
        	   }
           }
</script>
</body>
</html>