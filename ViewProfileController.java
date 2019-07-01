package com.dsrc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewProfileController
 */
@WebServlet("/ViewProfileController")
public class ViewProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		String gender=request.getParameter("gender");
		String contactNumber=request.getParameter("contact");
		String password=request.getParameter("pass");
		
		String email=request.getParameter("email");
		
		pw.println("<html> <body> <form> <table>");
		pw.println("<tr> <td> ID </td> <td>" +id+ "</td>");
		pw.println("<tr> <td> Name </td> <td>" +name+ "</td>");
		pw.println("<tr> <td> Age </td> <td>" +age+ "</td>");
		pw.println("<tr> <td> Gender </td> <td>" +gender+ "</td>");
		pw.println("<tr> <td> ContactNumber </td> <td>" +contactNumber+ "</td>");
		pw.println("<tr> <td> Password </td> <td>" +password+ "</td>");
		pw.println("<tr> <td> Email </td> <td>" +email+ "</td>");
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
