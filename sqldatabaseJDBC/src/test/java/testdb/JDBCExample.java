package testdb;


import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JDBCExample {
	


	    public static void main(String[] args) {

	        System.out.println("MySQL JDBC Connection Testing ~");
	        Statement stmt = null;
	        Connection conn = null;


	        String SQL_TABLE = "create table test.testemployees(" + 
	        		"employee_id INT(11), " + 
	        		"name varchar(100) NOT NULL, " + 
	        		"salary DECIMAL(6,2) NOT NULL, " + 
	        		"PRIMARY KEY (employee_id) );";
	        
	        //connect to sql db
	        try {System.out.println("Connected to database...");
	        	conn = DriverManager.getConnection(
	                "jdbc:mysql://127.0.0.1:3306/test", "dev", "Pass1235");
	        	System.out.println("Connected database successfully...");
	        		
	        		stmt = conn.createStatement();
	        		stmt.executeUpdate(SQL_TABLE);
	        		System.out.println("Created table in given database...");
	             
	    } catch(SQLException se){
	        //Handle errors for JDBC
	        se.printStackTrace();
	     }catch(Exception e){
	        //Handle errors for Class.forName
	        e.printStackTrace();
	     }finally{
	        //finally block used to close resources
	        try{
	           if(stmt!=null)
	              conn.close();
	        }catch(SQLException se){
	        }// do nothing
	        try{
	           if(conn!=null)
	              conn.close();
	        }catch(SQLException se){
	           se.printStackTrace();
	        }//end finally try
	     }//end try


	    }

}
