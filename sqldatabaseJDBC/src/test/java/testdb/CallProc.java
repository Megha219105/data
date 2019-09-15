package testdb;

import java.sql.*;

public class CallProc {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/sakila";

	   //  Database credentials
	   static final String USER = "dev";
	   static final String PASS = "Pass1235";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   CallableStatement stmt = null;
	   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      String sql = "{call film_in_stock(?, ?, ?)}";
		      stmt = conn.prepareCall(sql);
		      
		      //Bind IN parameter first, then bind OUT parameter
		      int film_id = 10;
		      stmt.setInt(1, film_id); // This would set film_id to 10
		      int store_id = 23;
		      stmt.setInt(2, store_id);
		      // Because third parameter is OUT so register it which will be count
		      stmt.registerOutParameter(3, java.sql.Types.INTEGER);
		      
		      //Use execute method to run stored procedure.
		      System.out.println("Executing stored procedure..." );
		      stmt.execute();

		      //Retrieve employee name with getXXX method
		      int film_count = stmt.getInt(3);
		      System.out.println("The film count is " + 
		                film_count);
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
	   }

}
