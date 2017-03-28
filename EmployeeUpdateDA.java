package com.booktracking.dataaccess;



import java.sql.*;

import com.booktracking.dao.*;
import com.booktracking.dataaccess.DatabaseConnection;
//import DAO.Login;
public class EmployeeUpdateDA {
	
	public boolean updateEmployeeDetails(EmployeeUpdate eu)
	{//System.out.println("Hi");
		DatabaseConnection db=new DatabaseConnection();
		Statement st=null;
		ResultSet rs=null;
		Connection con=null;
		Boolean result=false;
		con=db.getConnection();
		System.out.println("Hi");
		
		EmployeeUpdate eu2 = new EmployeeUpdate();
		
		if(con!=null)
		{
			try
			{
				st=con.createStatement();
				String query="update student_employees set student_id="
				+ eu.getEmployeeId()+", employee_name='"+eu.getEmployeeName()+"', student_email='"+eu.getEmployeeEmail()+"', employee_status='"+eu.getEmployeeStatus()+"' where student_id="+eu.getEmployeeId()+"";
			
				System.out.println("Reached in EmployeeUpdateDA");
				System.out.println(query);
				rs=st.executeQuery(query);				
//				while(rs.next())
//				{
//						//System.out.println("Hiiiiiiii");
//						String id=""+rs.getInt("student_id");
//						eu2.setEmployeeId(id);
//						System.out.println(eu2.getEmployeeId());
//						eu2.setEmployeeEmail(rs.getString("student_email"));
//						eu2.setEmployeeName(rs.getString("employee_name"));
//						eu2.setEmployeeStatus(rs.getString("employee_status"));
//				}
				if(rs.next())
				{
						return true;
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
			finally
			{
				try{
					if(st!=null)
						st.close();
					if(rs!=null)
						rs.close();
					con.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		return true;
	}
	
	
	
	
	
	
	
	
	public EmployeeUpdate checkEmployeeByName(EmployeeUpdate eu)
	{//System.out.println("Hi");
		DatabaseConnection db=new DatabaseConnection();
		Statement st=null;
		ResultSet rs=null;
		Connection con=null;
		Boolean result=false;
		con=db.getConnection();
		System.out.println("Hi");
		
		EmployeeUpdate eu2 = new EmployeeUpdate();
		
		if(con!=null)
		{
			try
			{
				st=con.createStatement();
				String query="select * from student_employees where employee_name='"
				+ eu.getEmployeeName()+"'";
			
				System.out.println("Reached in EmployeeUpdateDA");
				System.out.println(query);
				rs=st.executeQuery(query);				
				while(rs.next())
				{
						//System.out.println("Hiiiiiiii");
						String id=""+rs.getInt("student_id");
						eu2.setEmployeeId(id);
						System.out.println(eu2.getEmployeeId());
						eu2.setEmployeeEmail(rs.getString("student_email"));
						eu2.setEmployeeName(rs.getString("employee_name"));
						eu2.setEmployeeStatus(rs.getString("employee_status"));
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			finally
			{
				try{
					if(st!=null)
						st.close();
					if(rs!=null)
						rs.close();
					con.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		return eu2;
	}
	
	
	
}
