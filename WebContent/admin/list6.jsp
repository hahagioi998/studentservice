<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*" import="swu.zhj.model.*" import="swu.zhj.service.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%
    int id=(Integer)session.getAttribute("id");
    session.setAttribute("id", id);
    System.out.println(id+"list6");
    List<Jianzhis> jianzhi_list=new ArrayList<Jianzhis>();
    jianzhi_list=(ArrayList<Jianzhis>)request.getAttribute("jianzhi_list");
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
        <h2>兼职信息管理</h2>
		<div class="row-fluid">
			<div class="span12">
				<form class="form-search" action="${pageContext.request.contextPath}/Search?action=jianzhiguanli" method="post">
					<input class="input-medium search-query" type="text" />
					<button type="submit" class="btn btn-danger" name="search">查找</button>
				</form>
				<table class="table">
					<thead>
						<tr>
							<th>编号</th>
							<th>标题</th>
							<th>内容</th>
							<th>创建时间</th>
							<th>赞数</th>
							<th>图片</th>
							<th>是否为精选</th>
							<th>链接到</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					      <%if(!jianzhi_list.isEmpty()){
	    	             for(Jianzhis map:jianzhi_list){ %>
							<tr>
								<td><%=map.getId() %></td>
								    <%if(map.getTitle().length()>28){ %>
								<td style="width:110px;height:100px;"><%=map.getTitle().substring(0,28) %>...</td>
								    <%}else{ %>
								<td style="width:110px;height:100px;"><%=map.getTitle() %></td>
								<%} %>
								  <%if(map.getContent().length()>100){ %>
								  <td style="width:300px;height:100px;">
								   <%=map.getContent().substring(0, 100) %>...
								  </td>
								   <%}else{ %>
								   <td style="width:300px;height:100px;">
								   <%=map.getContent()%>
								    </td>
								 <%}%>
								<td><%=map.getTime() %></td>
								<td><%=map.getZan() %></td>
								<td><img src="${pageContext.request.contextPath}/<%=map.getImg() %>" style="width:100px;height:100px;"></td>
								<td> 
								   <%if(map.getJing()==0){ %>
								   否
								  <%}else{ %>
								  是
								  <%} %>
								</td>
								<td><%=map.getHref() %></td>
								<td><a href="${pageContext.request.contextPath}/Delete?jianzhi_id=<%=map.getId() %>&action=jianzhi">删除</a>
									<a href="${pageContext.request.contextPath}/Update?jianzhi_id=<%=map.getId() %>&action=jianzhi" target="_blank">更改</a>
								</td>
                              
							</tr>
								<%}} %>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>