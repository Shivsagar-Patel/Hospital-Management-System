package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.specialistDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/addSpecialist")
public class AddSpecialist extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String specName=request.getParameter("specName");
		
		specialistDao dao=new specialistDao(DBConnect.getCon());
		boolean f=dao.addSpecialist(specName);
		
	    HttpSession session=request.getSession();
	    
		if(f)
		{
			
			session.setAttribute("succMsg","Specialist Added Succesfully");
			response.sendRedirect("admin/index.jsp");
		}
		else
		{
			session.setAttribute("errMsg", "Something wrong on server");
			response.sendRedirect("admin_login.jsp");
		}
	}
	
	

}
