package com.dsrc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsrc.bean.LoginBean;
import com.dsrc.bo.ProfileManagementBO;
import com.dsrc.exceptions.LoginBusinessException;
import com.dsrc.exceptions.LoginException;
import com.dsrc.exceptions.RegistrationBusinessException;
import com.dsrc.exceptions.RegistrationException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object logBean;
       
    
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("pass");
		LoginBean logBean = new LoginBean();
		logBean.setId(id);
		logBean.setPass(password);
		
		ProfileManagementBO bo= new ProfileManagementBO();
		
		try{
			boolean res=bo.validateLogin(logBean);
			if(res)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
				request.setAttribute("id", logBean.getId());
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				request.setAttribute("errorReason",  "Login failed due to wrong credentials");
				rd.forward(request, response);
			}
		}
		catch(LoginBusinessException | LoginException | RegistrationException e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			request.setAttribute("errorReason",  e.getMessage());
			rd.forward(request, response);
				
		}
	}

}