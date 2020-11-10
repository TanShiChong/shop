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

	<script src="js/jquery-1.8.0.js" ></script>
  </head>

  <body>
  	<h1>角色管理</h1>
    	当前角色名称 ${roleInfo.roleName }
    	
    	
    	${menuIdStr}
    	<hr />
    	
    	<form action="RoleServlet.do?flag=roleUpdate" method="post">	
    		<input type="hidden" name="roleId" value="${roleInfo.id }" >
    		
    		<table border="1">
    			<c:forEach var="m" items="${menuList }">
    				<tr>
    					<td>
    						<input type="checkbox" name="menuIds" value="${m.id }"> ${m.menuName }_${m.id }
    					</td>
    					<td>
    						<c:forEach var="m_sub" items="${m.subMenuList }">
    							<input type="checkbox"  name="menuIds"  value="${m_sub.id }" > ${m_sub.menuName}_${m_sub.id }
    						</c:forEach>
    					</td>
    				</tr>
    			</c:forEach>
    		</table>
    	
    	   <input type="submit" value="保存" >
    	   
    	   ${msg }
    	   
    	</form>
    	
  	<hr>
  	
  	
  	<script>
  	   var menuStr="${menuIdStr}"; 
  	   var menuIdArray = menuStr.split(",");
  	   
  	   //取得所有的复选框
  	   var checkBoxList=$("input[name=menuIds]");
  	   
  	   
  	   //扩展Array,给它加一个 contains
  	   Array.prototype.contains=function(e){
  		   for(var i=0;i<this.length;i++){
  			   if(this[i]==e){
  				   return true;
  			   }   
  		   }
  		   return false;
  	   }
  	   
	  checkBoxList.each(function(){
	  		 if(menuIdArray.contains(this.value)){
	  			 this.checked=true;
	  		 } 
	  });
	  	 
	  		
  	</script>
    
  </body>
</html>