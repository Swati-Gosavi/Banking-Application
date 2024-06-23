package com.swati.services;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swati.dbcon.ConnectDB;

/**
 * Servlet implementation class DepositMoney
 */
public class DepositMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositMoney() {
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
		String accNo = request.getParameter("accno");
		String damt = request.getParameter("damt");
		
		try
		{	
			if(Integer.parseInt(damt)>0)
			{
				Connection con = ConnectDB.connect();
				PreparedStatement ps1 = con.prepareStatement("select * from users_tbl where accno=?");
				ps1.setString(1, accNo);
				ResultSet rs1 = ps1.executeQuery();
				if(rs1.next())
				{
			
	
					int balance = rs1.getInt("ubal");
					balance = balance + Integer.parseInt(damt);
					PreparedStatement ps2 = con.prepareStatement("update users_tbl set ubal=? where accno=?");
					ps2.setInt(1, balance);
					ps2.setString(2, accNo);
					int i = ps2.executeUpdate();
					if(i==1)
					{
						response.sendRedirect("success.html");
					}
					else
					{
						response.sendRedirect("failed.html");
					}
				}
				else
				{
					response.sendRedirect("failed.html");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		

	}

}
