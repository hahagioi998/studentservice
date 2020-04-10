<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*" import="swu.zhj.model.*" import="swu.zhj.service.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%
    int id=(Integer)session.getAttribute("id");
    session.setAttribute("id", id);
    
    List<Yijian> yijian_list=new ArrayList<Yijian>();
    yijian_list=(ArrayList<Yijian>)request.getAttribute("yijian_list");
    session.setAttribute("yijian_list", yijian_list);
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
        <h2>意见箱</h2>
		<div class="row-fluid">
			<div class="span12">
				<form class="form-search" action="${pageContext.request.contextPath}/Search?action=yijian" method="post">
					<input class="input-medium search-query" type="text" />
					<button type="submit" class="btn btn-danger" name="search">查找</button>
				</form>
				<table class="table">
					<thead>
						<tr>
							<th>编号</th>
							<th>姓名</th>
							<th>年级</th>
							<th>qq</th>
							<th>内容</th>
							<th>时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					     <%if(!yijian_list.isEmpty()){
	    	             for(Yijian map:yijian_list){ %>
							<tr>

								<td><%=map.getId() %></td> 
								<td><%=map.getName() %></td>
								<td><%=map.getNianji() %></td>
								<td><%=map.getQq() %></td>
								<td><%=map.getContent() %></td>
								<td><%=map.getTime() %></td>
								<td>
								  <a href="${pageContext.request.contextPath}/Delect?jianzhi_id=<%=map.getId() %>&action=yijian">删除</a>
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

</body>
</html>