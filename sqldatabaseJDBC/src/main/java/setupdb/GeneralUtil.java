package setupdb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneralUtil {
	
	//  Database credentials
	   
	   public static Connection conn;
	   public static PreparedStatement psmt;
	   public static CallableStatement csmt;
	   public static Statement smt;
	   
	   
	   
	   
	   public static void verfiyDB(Connection conn, Statement smt, String DB) {
		   System.out.println("Verifying database...");
		   String SQL = "Select databases;";
		   List<String> dbList = new ArrayList<>();
		   try {
			   ResultSet result = smt.executeQuery(SQL);
			   
			   while(result.next()) {
				  String db = result.getString("Database");
				  dbList.add(db);
				  
			   }
			   
			   if(dbList.contains(DB)) {
				   System.out.println(DB+" is present");
			   }
		   } catch (SQLException se) {
			   se.printStackTrace();
		   }
		   
		   
	   }
	   
	   public static void verifyTable(Connection conn, Statement smt, String table, String DB) {
		   System.out.println("Verifying table...");
		   String SQL = "show tables in "+ DB ;
		   List<String> tbList = new ArrayList<>();
		   try {
			   ResultSet result = smt.executeQuery(SQL);
			   
			   while(result.next()) {
				  String tab = result.getString("Tables_in_"+ DB);
				  tbList.add(tab);
				  
			   }
			   
			   if(tbList.contains(table)) {
				   System.out.println(table+" is present");
			   }
		   } catch (SQLException se) {
			   se.printStackTrace();
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
	   
	   //Step 4a.1 Close callable statement finally after execution
	   public static void closeCallableStmt(CallableStatement csmt ) {
		   System.out.println("closing Callable statement...");
		   try {
			   if(csmt!=null) {
				   csmt.close();}
		   } catch (SQLException se) {
			   se.printStackTrace();
		   }
	   }
	   
	   //Step 4a.2 Close prepared statement after execution
	   public static void closePreparedStmt(PreparedStatement psmt ) {
		   System.out.println("closing Prepared statement...");
		   try {
			   if(psmt!=null) {
				   psmt.close();}
		   } catch (SQLException se) {
			   se.printStackTrace();
		   }
	   }
	   
	 //Step 4a.3 Close statement after execution
	   public static void closeStatement(Statement smt ) {
		   System.out.println("closing statement...");
		   try {
			   if(smt!=null) {
				   smt.close();}
		   } catch (SQLException se) {
			   se.printStackTrace();
		   }
	   }
	   
	   
	   
	   
	

}
