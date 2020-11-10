package com.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.MenuInfo;
import com.beans.RoleInfo;
import com.dao.MenuDao;
import com.dao.RoleDao;


@WebServlet("/RoleServlet.do")        
public class RoleServlet extends HttpServlet {
	private RoleDao roleDao=new RoleDao();
	private MenuDao menuDao=new MenuDao();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag =request.getParameter("flag");
		
		if("manage".equals(flag)) {
			
			manager(request,response);
		}
		
		else if("roleMenu".equals(flag)) {
			roleMenu(request,response);	
		}
		else if("roleUpdate".equals(flag)) {
			roleUpdate(request,response);	
		}
	}

	//真正的进行权限的更新
	private void roleUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roleId=Integer.parseInt(request.getParameter("roleId"));
		
		//所有用户勾选的menuid列表
		String []  idList= request.getParameterValues("menuIds");
		
		roleDao.updateRoleMenu(roleId,idList );
		
		request.setAttribute("msg", "角色更新成功");
		roleMenu(request,response);

	}

	//转到角色授权页面
	private void roleMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//查询角色信息
		int roleId= Integer.parseInt( request.getParameter("roleId"));
		RoleInfo roleInfo=roleDao.getRoleInfoById(roleId);
		
		
		//查询这个角色对应的菜单id(用于回显)
		String menuIdStr=roleDao.getMenuIdStr(roleId);
		
		//查询所有的菜单
		List<MenuInfo> menuList=menuDao.getMenuList(0);
		
		
		
		request.setAttribute("roleInfo", roleInfo);
		request.setAttribute("menuList", menuList);
		request.setAttribute("menuIdStr",menuIdStr);
		
		request.getRequestDispatcher("/role/role-edit.jsp").forward(request, response);
	}
	
	

	//查询所有角色,转到角色列表
	private void manager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<RoleInfo> roleList= roleDao.getRoleList();
		request.setAttribute("roleList", roleList);
		request.getRequestDispatcher("/role/role-manager.jsp").forward(request, response);
	}

}
