<%@ page language="java" import="java.util.*,ssl.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>帖子管理</title>
    
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
   
  <jsp:useBean id="postManager" class="ssl.PostManagerBean" scope="application"/>
  
  <% List<PostDataBean> postList=(List<PostDataBean>)request.getAttribute("postqueryResult");
  	 if(postList==null) postList=postManager.getPostList();
  	 PostQueryCondition postcond=(PostQueryCondition) request.getAttribute("postqueryCond");
  	 if(postcond==null) postcond=new PostQueryCondition();
   %>
   
  <form action="servlet/PostQueryServlet" method="post">
  查询条件：<select name="postqueryField">
  <option value="1" <%=postcond.getPostqueryField()==1?"selected":"" %>></option>
  <option value="2" <%=postcond.getPostqueryField()==2?"selected":"" %>>姓名</option>
  <option value="3" <%=postcond.getPostqueryField()==3?"selected":"" %>>电话</option>
  <option value="4" <%=postcond.getPostqueryField()==4?"selected":"" %>>地址</option>
 
  </select>
  包含<input type="text" name="postqueryValue" value="<%=postcond.getPostqueryValue() %>"/>
  <input type="submit" value="查询"/>
  </form>
  
     <table border="1">
  <caption>联系人列表</caption>
  <tr><th>姓名</th><th>电话</th><th>地址</th><th>删除</th><th>修改</th><th>增加</th></tr>
  <%  Iterator<PostDataBean> iter=postList.iterator();
  	  while(iter.hasNext()){
  	  PostDataBean postData=iter.next();	%>
      <tr><td><%=postData.getPostername() %></td><td><%=postData.getPosttitle() %></td>
      <td><%=postData.getPostconts() %></td>
       <td><a href="servlet/PostDeleteServlet?id=<%=postData.getId()%>">删除</a></td>
       <td><a href="servlet/PostEditServlet?id=<%=postData.getId()%>">修改</a></td>
       <td><a href="servlet/PostAddServlet?id=<%=postData.getId()%>">增加</a></td>
      </tr> 	  
  <% }   %>
  </table>
  </body>
</html>
