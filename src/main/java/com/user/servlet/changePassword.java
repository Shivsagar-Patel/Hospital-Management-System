package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDao;
import com.db.DBConnect;

@WebServlet("/userChangePassword")
public class changePassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid=Integer.parseInt(request.getParameter("uid"));
		String oldPassword=request.getParameter("oldPassword");
		String newPassword=request.getParameter("newPassword");
		
		UserDao dao=new UserDao(DBConnect.getCon());
		HttpSession session=request.getSession();
		
		if(dao.checkOldPassword(uid, oldPassword))
		{
			if(dao.changePassword(uid, newPassword))
			{
				session.setAttribute("succMsg", "Password Change SuccessFully");
				response.sendRedirect("changePassword.jsp");
			}
			else
			{
				session.setAttribute("errMsg","Something is wrong on sever");
				response.sendRedirect("changePassword.jsp");
				
			}
		}
		else
		{
			session.setAttribute("errMsg","Old Password is wrong");
			response.sendRedirect("changePassword.jsp");
		}
	}
	
	

}
