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
import com.entity.User;

@WebServlet("/userLogin")
public class userLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			HttpSession session=request.getSession();
			
			UserDao dao=new UserDao(DBConnect.getCon());
			User user=dao.login(email,password);
			
			
			if(user!=null)
			{
				
				session.setAttribute("userObj", user);
				response.sendRedirect("index.jsp");
			}
			else
			{
				session.setAttribute("errMsg", "invalid email & password");
				response.sendRedirect("user_login.jsp");
			}
			
		}
		catch(Exception e)
		{
			
		}
	
	}
	

}
