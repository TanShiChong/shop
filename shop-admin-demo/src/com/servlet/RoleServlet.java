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

	//�����Ľ���Ȩ�޵ĸ���
	private void roleUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roleId=Integer.parseInt(request.getParameter("roleId"));
		
		//�����û���ѡ��menuid�б�
		String []  idList= request.getParameterValues("menuIds");
		
		roleDao.updateRoleMenu(roleId,idList );
		
		request.setAttribute("msg", "��ɫ���³ɹ�");
		roleMenu(request,response);

	}

	//ת����ɫ��Ȩҳ��
	private void roleMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��ѯ��ɫ��Ϣ
		int roleId= Integer.parseInt( request.getParameter("roleId"));
		RoleInfo roleInfo=roleDao.getRoleInfoById(roleId);
		
		
		//��ѯ�����ɫ��Ӧ�Ĳ˵�id(���ڻ���)
		String menuIdStr=roleDao.getMenuIdStr(roleId);
		
		//��ѯ���еĲ˵�
		List<MenuInfo> menuList=menuDao.getMenuList(0);
		
		
		
		request.setAttribute("roleInfo", roleInfo);
		request.setAttribute("menuList", menuList);
		request.setAttribute("menuIdStr",menuIdStr);
		
		request.getRequestDispatcher("/role/role-edit.jsp").forward(request, response);
	}
	
	

	//��ѯ���н�ɫ,ת����ɫ�б�
	private void manager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<RoleInfo> roleList= roleDao.getRoleList();
		request.setAttribute("roleList", roleList);
		request.getRequestDispatcher("/role/role-manager.jsp").forward(request, response);
	}

}
