<%@page import="com.swati.dbcon.*" %>
<%@page import="java.sql.*" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Delete Page </title>  
<style>   
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: lightpink;  
}  
button {   
       background-color:darkblue;   
       width: 100%;  
        color: white;   
        padding: 15px;   
        margin: 10px 0px;   
        border: none;   
        cursor: pointer;   
         }   
 form {   
        border: 3px solid white;   
    }   
 input[type=text], input[type=password] {   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px darkblue;   
        box-sizing: border-box;   
    }  
 button:hover {   
        opacity: 0.7;   
    }   
  .cancelbtn {   
        width: auto;   
        padding: 10px 18px;  
        margin: 10px 5px;  
    }   
        
     
 .container {   
        padding: 25px;   
        background-color: mediumslateblue;  
    }   
</style>   
</head>    
<body>    
     
 
 
    <form action ="delete.jsp">  
        <div class="container">   
          
    </div>   
    </form> 
    
<%
	try
	{
		String accno = request.getParameter("accno");
		Connection con = ConnectDB.connect();
		PreparedStatement ps1 = con.prepareStatement("delete from users_tbl where accno=?");
		ps1.setString(1,accno);
		int i = ps1.executeUpdate();
		if(i>0)
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
	
	
%>

                        
     
</body>     
</html>