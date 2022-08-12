package Pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class ReadDataFromMySqlNonSelectQuery 
{
	public static void main(String[] args) throws Throwable 
	{
		//step 1: Register or load the MySql database
				Driver driverRef=new Driver();
				DriverManager.registerDriver(driverRef);
				
				//step 2: Get connect to database
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_information","root","root");
				
				//strep 3:create sql statement
				Statement stat = conn.createStatement();
		
			String query="insert into student(first_name,last_name,address)values('Rathin','BN','INDIA')";
			    
				//step 4:Execute query
				 int result = stat.executeUpdate(query);  //primitive datatype content level comparison
				                                         //non-primitive datatype address level comparison
				if(result==1)
				{
					System.out.println("user is created");
				}
				else
				{
					System.out.println("user is not created");
				}
		
				
				//step 5:close the connection
				conn.close();
		
		
	

}}
