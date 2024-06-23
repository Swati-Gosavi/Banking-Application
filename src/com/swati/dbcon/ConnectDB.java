package com.swati.dbcon;

import java.sql.*;

public class ConnectDB {
	static Connection con = null;
	public static Connection connect()
	{
		if(con==null)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db","root","");
			}
			catch(Exception e)
			{
				System.err.println("Something went wrong..!!");
				e.printStackTrace();
			}
		}
		return con;
	}
}
