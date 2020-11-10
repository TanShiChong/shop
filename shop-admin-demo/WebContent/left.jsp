<%@ page language="java" import="java.util.*,com.beans.*,com.dao.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
  
    <%
    	MenuDao dao=new MenuDao();
    
        AdminInfo admin=(AdminInfo)session.getAttribute("session_admin");
        int roleId= admin.getRoleId();
    
      //查询所有的一级菜单
       List<MenuInfo> menuList= dao.getMenuList(0,roleId);
       request.setAttribute("menuList", menuList);
    %>
    
    <ul>
	    <c:forEach var="m" items="${menuList }">
	    	<li>
	    		<a href="#">${m.menuName }</a>
	    		<ul>
	    			<c:forEach  var="m_sub" items="${m.subMenuList}">
	    				<li>
	    					<a  target="centerFrame" href="${m_sub.url }">${m_sub.menuName }</a>
	    				</li>
	    			</c:forEach>
	    		</ul>
	    	</li>
	    </c:forEach>
    </ul>
    
    
  </body>
</html>