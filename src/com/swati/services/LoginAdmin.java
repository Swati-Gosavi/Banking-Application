package com.swati.services;
import java.sql.*;
import com.swati.dbcon.ConnectDB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LoginAdmin
 */
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String aemail = request.getParameter("uemail");
		String apass = request.getParameter("upassword");
		
		try
		{
	
			
			if(aemail.equals("admin@gmail.com")&& apass.equals("admin"))
			{
				response.sendRedirect("option.html");
			}
			else
			{
				response.sendRedirect("index.html");
			}
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
