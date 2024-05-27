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

@WebServlet("/user_register")
public class UserRegister extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try
		{
			String fullname=req.getParameter("fullname");
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			User u=new User(fullname, email, password);
			
			UserDao dao=new UserDao(DBConnect.getCon());
			
			boolean f=dao.userRegister(u);
			
			HttpSession session=req.getSession();
			
			if(f)
			{
				session.setAttribute("succmsg","Registration Successfully");
			//	resp.sendRedirect("signup.jsp");
				resp.sendRedirect("user_login.jsp");
			}
			else
			{
				session.setAttribute("errmsg","Something went wrong");
				resp.sendRedirect("signup.jsp");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	

}
