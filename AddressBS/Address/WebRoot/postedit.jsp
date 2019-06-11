<%@ page language="java" import="java.util.*,ssl.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>联系人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <% PostDataBean postData=(PostDataBean)request.getAttribute("object_post"); %>

      <form action="servlet/PostEditServlet" method="post">
    <table border="1">
  			<caption>修改联系人信息</caption>
  				<tr><td>姓名</td><td><input type="text" name="postername" value="<%=postData.getPostername()%>" readonly/></td></tr>
  		    	<tr><td>电话</td><td><input type="text" name="posttitle" value="<%=postData.getPosttitle()%>" /></td></tr>
  			<tr><td>地址</td><td><textarea name="postconts"  rows="5" cols="35"  ><%=postData.getPostconts()%></textarea></td>
			</tr>
  			</table>
  		<input type="submit" value="修改"/>
  		</form>
  </body>
</html>
