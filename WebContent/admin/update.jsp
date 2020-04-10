<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    int id=(Integer)session.getAttribute("id");
    int jianzhi_id=(Integer)session.getAttribute("jianzhi_id");
    session.setAttribute("id", id);
    session.setAttribute("jianzhi_id", jianzhi_id);
    String action=(String)session.getAttribute("action");
    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="../ueditor/ueditor.config.js"></script>  
<script type="text/javascript" src="../ueditor/ueditor.all.js"></script> 
<LINK rel=stylesheet href="../ueditor/themes/default/ueditor.css">
<script>
        var UEDITOR_HOME_URL = "/ueditor/";//从项目的根目录开始
</script>
</head>
<body>
<div align="left">  
 <%
     if(action.equals("news")){
  %>
<form action="${pageContext.request.contextPath}/UpdateNews?action=news" method="post">
<ul style="list-style-type:none">
  <c:forEach items="${news}" var="news">
    <li>新闻标题：<input type="text" name="title" value=${news.title}></li>
    <li>新闻类别：<select name="parenttitle" id="kind"> 
         <option value="国际新闻">国际新闻</option> 
         <option value="国内新闻">国内新闻</option> 
         <option value="军事新闻">军事新闻</option> 
         <option value="经济新闻">经济新闻</option> 
         <option value="社会新闻">社会新闻</option> 
         <option value="体育新闻">体育新闻</option> 
        </select>
     </li>
     <li>
      新闻内容：<textarea id="newsEditor" name="content" > ${news.content }</textarea> 
     </li>
     </c:forEach>
</ul>  
   <div align="center" >
         <input type="submit" value="发布" > 
   </div> 
   <script type="text/javascript">  
           UE.getEditor('newsEditor');  
   </script>  
</form>
<%
     }else if(action.equals("home_data")){%>
     <form action="${pageContext.request.contextPath}/UpdateNews?action=home_data" method="post">
         <ul style="list-style-type:none">
          <c:forEach items="${home_data}" var="home_data">
          <li>最大值:<input type="text" name="max_data" value=${home_data.max_data}></li>

         <li>
                    标题：<textarea id="newsEditor" name="content" > ${home_data.h5 }</textarea> 
         </li>
           </c:forEach>
        </ul>  
   <div align="center" >
         <input type="submit" value="发布" > 
   </div> 
   <script type="text/javascript">  
           UE.getEditor('newsEditor');  
   </script> 
     </form>
     <%
     }else if(action.equals("home_nongchang")){%>
       <form action="${pageContext.request.contextPath}/UpdateNews?action=home_nongchang" method="post">
     <ul style="list-style-type:none">
          <c:forEach items="${home_nongchang}" var="home_nongchang">
          <li>图片名:<input type="text" name="image" value="${home_nongchang.image}"></li>
          <li>标题:<input type="text" name="title" value="${home_nongchang.title}"></li>
         <li>
                  内容：<textarea id="newsEditor" name="content" > ${home_data.content }</textarea> 
         </li>
           </c:forEach>
        </ul>  
   <div align="center" >
         <input type="submit" value="发布" > 
   </div> 
   <script type="text/javascript">  
           UE.getEditor('newsEditor');  
   </script> 
     </form>
     <%
     }else if(action.equals("gamelei")){%>
      <form action="${pageContext.request.contextPath}/UpdateNews?action=gamelei" method="post">
         <ul style="list-style-type:none">
          <c:forEach items="${gamelei}" var="gamelei">
          <li>类名:<input type="text" name="lei" value=${gamelei.lei}></li>
          <li>游戏一:<input type="text" name="name1" value=${gamelei.name1}></li>
         <li>游戏二:<input type="text" name="name2" value=${gamelei.name2}></li>
         <li>游戏三:<input type="text" name="name3" value=${gamelei.name3}></li>
         <li>游戏四:<input type="text" name="name4" value=${gamelei.name4}></li>
           </c:forEach>
        </ul>  
   <div align="center" >
         <input type="submit" value="发布" > 
   </div> 
   <script type="text/javascript">  
           UE.getEditor('newsEditor');  
   </script> 
     </form>
     <%
     }else if(action.equals("home_yin")){%>
      <form action="${pageContext.request.contextPath}/UpdateNews?action=home_yin" method="post">
     <ul style="list-style-type:none">
          <c:forEach items="${home_yin}" var="home_nongchang">
          <li>图片名:<input type="text" name="image" value=${home_yin.image}></li>
          <li>标题:<input type="text" name="title" value=${home_yin.title}></li>
           <li>地址:<input type="text" name="adr" value=${home_yin.adr}></li>
            <li>电话:<input type="text" name="phone" value=${home_yin.phone}></li>
         <li>
                    简介：<textarea id="newsEditor" name="jian" > ${home_yin.jian }</textarea> 
         </li>
           </c:forEach>
        </ul>  
   <div align="center" >
         <input type="submit" value="发布" > 
   </div> 
   <script type="text/javascript">  
           UE.getEditor('newsEditor');  
   </script> 
     </form>
     <%
     }else if(action.equals("lunbo")){%>
       <form action="${pageContext.request.contextPath}/UpdateNews?action=lunbo" method="post">
      <ul style="list-style-type:none">
          <c:forEach items="${lunbo}" var="lunbo">
          <li>图片名:<input type="text" name="image" value=${lunbo.image}></li>
          <li>标题:<input type="text" name="title" value=${lunbo.title}></li>
         <li>
                    内容：<textarea id="newsEditor" name="content" > ${lunbo.content }</textarea> 
         </li>
           </c:forEach>
        </ul>  
   <div align="center" >
         <input type="submit" value="发布" > 
   </div> 
   <script type="text/javascript">  
           UE.getEditor('newsEditor');  
   </script> 
   </form>
   <% }else if(action.equals("jianzhi")){%>
       <form action="${pageContext.request.contextPath}/UpdateNews?action=jianzhi" method="post"  enctype="multipart/form-data">
      <ul style="list-style-type:none">
          <c:forEach items="${jianzhi}" var="jianzhi">
          <li style="height:30px;margin-bottom: 15px;">标题:<input type="text" name="title" value="${jianzhi.title}" style="width:300px;height:28px;padding:5px;"></li>
          <li style="height:30px;margin-bottom: 15px;">图片:<input type="file" id="uploadImg" name="uploadImg" value="${jianzhi.img}" ></li>
          <li style="height:30px;margin-bottom: 15px;">链接:<input type="text" name="href" value="${jianzhi.href}"></li>
         <li>
                    内容：<textarea id="newsEditor" name="content" > ${jianzhi.content }</textarea> 
         </li>
           </c:forEach>
        </ul>  
   <div align="center" >
         <input type="submit" value="发布" > 
   </div> 
   <script type="text/javascript">  
           UE.getEditor('newsEditor');  
   </script> 
   </form>
   <%} %>
</div>  
  
</body>
</html>
