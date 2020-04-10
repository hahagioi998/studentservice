<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*" import="swu.zhj.model.*" import="swu.zhj.service.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%
    int id=(Integer)session.getAttribute("id");
    session.setAttribute("id", id);
    
    List<Classes> cla_list=new ArrayList<Classes>();
    cla_list=(ArrayList<Classes>)request.getAttribute("cla_list");
    session.setAttribute("cla_list", cla_list);
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
        <h2>班级学生管理</h2>
		<div class="row-fluid">
			<div class="span12">
				<form class="form-search" action="${pageContext.request.contextPath}/Search?action=fudao" method="post">
					<input class="input-medium search-query" type="text" />
					<button type="submit" class="btn btn-danger" name="search">查找</button>
				</form>
				<center><a id="qunfa" style="display:block;width:80px;height:20px;background-color: #ccc;margin:20px;border-radius: 2px;">群发消息</a></center>
				<table class="table">
					<thead>
						<tr>
						<th> <input type="checkbox" id="checkAll" onclick="checkAll()"/>全选/全不选</th>
							<th>编号</th>
							<th>专业</th>
							<th>班级</th>
							<th>年级</th>
							<th>班主任</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<form action="${pageContext.request.contextPath}/Send?action=fudao" method="post">
					   <div id="qunfa_content" style="background-color:#ccc;position:fixed;top:100px;right:35%;width:520px;height:280px;display:none;padding:10px;">
			
					    选择方式：<input name="method" type="radio" checked="checked" value="zhannei"/>站内方式 
                        <input name="method" type="radio" value="qq"/>qq邮件
                        <br>
                        <input type="text" style="width:500px;height:200px;" placeholder="内容......" name="content">
                         <a id="close_qunfa" style="float:right;display:block;background-color: #fff;width:44px;height:26px;padding:1px 6px;border-width:2px;;border-radius: 3px;cursor: pointer;"> 取消</a>
                        <button type="submit">发表</button>
                       </div>
					     <%if(!cla_list.isEmpty()){
	    	             for(Classes map:cla_list){ %>
							<tr>
							    <td><input type="checkbox" name="tongzhi" value="<%=map.getId() %>"></td>
								<td><%=map.getId() %></td> 
								<td><%=map.getZhuanye() %></td>
								<td><%=map.getCla() %></td>
								<td><%=map.getNianji() %></td>
								<td><%=map.getTeacher() %></td>
								<td><a href="${pageContext.request.contextPath}/ListClastudent?cla_id=<%=map.getId() %>">查看</a>
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