<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'up.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

  </head>
  
  <body>
    
    <form action="/testweb/upload/img" method="post" enctype="multipart/form-data">
    
    <input type="file" name="file" ><br>
    <input type="text" name="str" ><br>
    
    <input type="submit" name="sub" value="submit">
    
    </form>
    
    
  </body>
</html>
