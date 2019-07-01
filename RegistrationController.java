package com.dsrc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsrc.bean.RegisterBean;
import com.dsrc.bo.ProfileManagementBO;
import com.dsrc.exceptions.RegistrationBusinessException;
import com.dsrc.exceptions.RegistrationException;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		String gender=request.getParameter("gender");
		String contactNumber=request.getParameter("contact");
		String password=request.getParameter("pass");
		String email=request.getParameter("email");
		RegisterBean regBean=new RegisterBean();
		regBean.setID(id);
		regBean.setName(name);
		regBean.setAge(age);
		regBean.setGender(gender);
		regBean.setContactNumber(contactNumber);
		regBean.setPassword(password);
		regBean.setEmail(email);
				
		ProfileManagementBO bo= new ProfileManagementBO();
		try{
			boolean res=bo.registerUser(regBean);
			if(res)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
				request.setAttribute("name",  regBean.getName());
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
				request.setAttribute("errorReason",  "Registration failed");
				rd.forward(request, response);
			}
		}
		catch(RegistrationException | RegistrationBusinessException e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
			request.setAttribute("errorReason",  e.getMessage());
			rd.forward(request, response);
				
		}
	}

}
