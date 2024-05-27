package com.admin.servlet;

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

@WebServlet("/addDoctor")
public class AddDoctor extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String dob = request.getParameter("dob");
		String qualification = request.getParameter("quali");
		String specialist = request.getParameter("spec");
		String email = request.getParameter("email");
		String mobNo = request.getParameter("mobno");
		String password = request.getParameter("password");
		
		
		Doctor d=new Doctor(fullname, dob, qualification, specialist, email, mobNo, password);
		
		DoctorDao dao=new DoctorDao(DBConnect.getCon());
		
		HttpSession session=request.getSession();
		
		if(dao.registerDoctor(d))
		{
			
			session.setAttribute("succMsg","Doctor Added Successfully");
			response.sendRedirect("admin/doctor.jsp");
			
		}
		else
		{
			session.setAttribute("errMsg","Something went wrong");
			response.sendRedirect("admin/doctor.jsp");
		}

	}

}
