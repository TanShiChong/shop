<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

  <body>
    <table border=1 >
    	<c:forEach var="r" items="${roleList }">
    		<tr>
    			<td>${r.id }</td>
    			<td>${r.roleName }</td>
    			<td>${r.des }</td>
    			<td><a>删除</a>  <a href="RoleServlet.do?flag=roleMenu&roleId=${r.id}">角色权限分配</a></td>
    		</tr>
    	</c:forEach>
    	
    	
    </table>
  </body>
</html>