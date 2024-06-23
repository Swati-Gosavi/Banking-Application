package com.swati.services;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swati.dbcon.ConnectDB;




/**
 * Servlet implementation class CreateAccount
 */
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
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
		
		String accNo = request.getParameter("uaccno");
		String name = request.getParameter("uname");
		String mobile = request.getParameter("mobile");
		String balance = request.getParameter("balance");
		
		try
		{
		
		
			Connection con = ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("insert into users_tbl values (?,?,?,?,?)");
			
			ps1.setInt(1,0);
			ps1.setString(2, accNo);
			ps1.setString(3,name);
			ps1.setString(4, mobile);
			ps1.setInt(5,Integer.parseInt(balance));
			int i = ps1.executeUpdate();
			System.out.println(i+" record inserted..");
			if(i==1)
			{
				response.sendRedirect("success.html");
			}
			else
			{
				response.sendRedirect("failed.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
}


