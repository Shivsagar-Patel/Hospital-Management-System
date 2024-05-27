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

@WebServlet("/editDoctorProfile")
public class EditProfile  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String dob = request.getParameter("dob");
		String qualification = request.getParameter("quali");
		String specialist = request.getParameter("spec");
		String email = request.getParameter("email");
		String mobNo = request.getParameter("mobno");
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		
		Doctor d=new Doctor(id,fullname, dob, qualification, specialist, email, mobNo, "");
		
		DoctorDao dao=new DoctorDao(DBConnect.getCon());
		
		HttpSession session=request.getSession();
		
		if(dao.editDoctorProfile(d))
		{
			Doctor updateDoctor=dao.getDoctorById(id);
			session.setAttribute("succMsgd","Doctor Update Successfully");
			session.setAttribute("doctorObj",updateDoctor);
			response.sendRedirect("doctor/editProfile.jsp");
			
		}
		else
		{
			session.setAttribute("errMsgd","Something went wrong");
			response.sendRedirect("doctor/editProfile.jsp");
		}
	}
	
	

	

}
