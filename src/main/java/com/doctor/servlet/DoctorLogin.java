package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.DoctorDao;
import com.db.DBConnect;
import com.entity.Doctor;

@WebServlet("/doctorLogin")
public class DoctorLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			HttpSession session=request.getSession();
			
			DoctorDao dao=new DoctorDao(DBConnect.getCon());
			Doctor doctor=dao.loginDoctor(email, password);
			
			
			if(doctor!=null)
			{
				
				session.setAttribute("doctorObj", doctor);
				response.sendRedirect("doctor/index.jsp");
			}
			else
			{
				session.setAttribute("errMsg", "invalid email & password");
				response.sendRedirect("docter_login.jsp");
			}
			
		}
		catch(Exception e)
		{
			
		}
	
	}
	
	

}
