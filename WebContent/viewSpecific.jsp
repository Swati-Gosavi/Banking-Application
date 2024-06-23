<%@page import="com.swati.dbcon.*" %>
<%@page import="java.sql.*" %>
<%@page import="com.swati.services.User" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> View Specific Page </title>  
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
     
    <center> <h1> Welcome to People's Bank </h1> </center>
    <center> <h3> <a href="createAcc.html"> Delete Reminder </a> </h3> </center>   
    <center> <h3> <a href="deposit.html"> Deposit Money </a> </h3> </center>
    <center> <h3> <a href="withdraw.html"> Withdraw Money </a> </h3> </center>
    <center> <h3> <a href="viewAll.jsp"> View All Accounts </a> </h3> </center>
    <center> <h3> <a href="viewSpecific.jsp"> Search Account </a> </h3> </center>
 
    <form action ="viewSpecific.jsp">  
        <div class="container">   
          
           <label>Account Number : </label>   
            <input type="text" placeholder="Enter Account Number" name="accno" required>  
          
            <button type="submit">Search Account</button>   
          
            
        </div>   
    </form> 
    
    <%
    	String accno = request.getParameter("accno");
    	if(accno!=null)
    	{
    %>  
         <table>
			  <tr>
			    <th>Customer ID</th>
			    <th>Account Number</th>
			    <th>Account Holder Name</th>
			    <th>Contact Number</th>
			     <th>Balance</th>
			      <th>Action</th>
			   </tr>
			   
 



<%


	Connection con = ConnectDB.connect();
	try
	{
		//accno =User.getAccNo();
		PreparedStatement ps1 = con.prepareStatement("select * from users_tbl where accno=?");
		ps1.setString(1,accno);
		ResultSet rs = ps1.executeQuery();
		while(rs.next())
		{
%>

			<tr>
		    <td><%=rs.getString("cust_id") %></td>
		    <td><%=rs.getString("accno") %></td>
		    <td><%=rs.getString("uname") %></td>
		    <td><%=rs.getString("umob") %></td>
		    <td><%=rs.getString("ubal") %></td>
		  </tr>
		  


<%		
		}
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
%>
</table>
                        
     
</body>     
</html>