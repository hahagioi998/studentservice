<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<form action="${pageContext.request.contextPath}/AddNews" method="post">
<ul style="list-style-type:none">
    <li>新闻标题：<input type="text" name="title"></li>
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
      新闻内容：<textarea id="newsEditor" name="content"> </textarea> 
     </li>
</ul>  
   <div align="center" >
         <input type="submit" value="发布" > 
   </div> 
   <script type="text/javascript">  
           UE.getEditor('newsEditor');  
   </script>  
</form>
<form action="${pageContext.request.contextPath}/AddNews" method="post">
<ul style="list-style-type:none">
    <li>新闻标题：<input type="text" name="title"></li>
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
      新闻内容：<textarea id="newsEditor" name="content"> </textarea> 
     </li>
</ul>  
   <div align="center" >
         <input type="submit" value="发布" > 
   </div> 
   <script type="text/javascript">  
           UE.getEditor('newsEditor');  
   </script>  
</form>
</div>  
</body>
</html>
