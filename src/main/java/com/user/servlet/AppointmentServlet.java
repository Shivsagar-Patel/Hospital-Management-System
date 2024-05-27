package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AppointmentDao;
import com.db.DBConnect;
import com.entity.Appointment;

@WebServlet("/addAppointment")
public class AppointmentServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId=Integer.parseInt(request.getParameter("userid"));
		String fullname=request.getParameter("fullname");
		String gender=request.getParameter("gender");
		String age=request.getParameter("age");
		String appoinDate=request.getParameter("appoint_date");
		String email=request.getParameter("email");
		String phno=request.getParameter("phno");
		String diseases=request.getParameter("diseases");
		int doctorId=Integer.parseInt(request.getParameter("doct"));
		String address=request.getParameter("address");
		
		System.out.println(address);
		
		Appointment ap=new Appointment(userId, fullname, gender, age, appoinDate, email, phno, diseases, doctorId, address, "Pending");
		
		AppointmentDao dao=new AppointmentDao(DBConnect.getCon());
		
		HttpSession session=request.getSession();
		if(dao.addAppointment(ap))
		{
			session.setAttribute("succMsg", "Appointment Added Successfully");
			response.sendRedirect("userAppointment.jsp");
		}
		else {
			session.setAttribute("errMsg", "Something wrong on server");
			response.sendRedirect("userAppointment.jsp");
			
		}
		
	}

}
