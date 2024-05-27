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

@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		

		DoctorDao dao = new DoctorDao(DBConnect.getCon());

		HttpSession session = request.getSession();

		if (dao.deleteDoctor(id)) {

			session.setAttribute("succMsg", "Doctor delete Successfully");
			response.sendRedirect("admin/viewdoctor.jsp");

		} else {
			session.setAttribute("errMsg", "Something went wrong");
			response.sendRedirect("admin/viewdoctor.jsp");
		}

	}

}
