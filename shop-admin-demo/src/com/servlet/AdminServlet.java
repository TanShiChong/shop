package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.AdminInfo;
import com.dao.AdminDao;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private AdminDao dao=new AdminDao();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminName=request.getParameter("adminName");
		String password=request.getParameter("password");
		
		AdminInfo admin=dao.login(adminName,password);
		if(admin!=null) {
			request.getSession().setAttribute("session_admin", admin);
			request.getRequestDispatcher("/main.html").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ,µ«¬º ß∞‹");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
