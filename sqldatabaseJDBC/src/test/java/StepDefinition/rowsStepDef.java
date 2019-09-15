package StepDefinition;

import java.sql.*;
import java.sql.Statement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import setupdb.CountRows;
import setupdb.GeneralUtil;
import setupdb.JDBCConnection;
import setupdb.Entity;


public class rowsStepDef {
	
	public static CountRows cr = new CountRows();
	public static Statement smt; 
	public static CallableStatement cstmt;
	public static Connection conn;
	
	
	@Given("^I am connected to Sakila database$")
	public void i_am_connected_to_Sakila_database() throws Throwable {
		//try conn.getschema;
	    System.out.println("Connected to sakila already");
	}

	
	@Given("^The tables (.*) and (.*) in (.*) are there$")
	public void the_database_are_there(String tab1,  String tab2, String db) throws Throwable {
		System.out.println("Verifying tables are there");
		
		try {
			System.out.println("Verifying table one " + tab1);
			smt = JDBCConnection.getConnection().createStatement();
			GeneralUtil.verifyTable(JDBCConnection.getConnection(), smt, tab1, db);
			GeneralUtil.closeStatement(smt);
			System.out.println("Closing table one " + tab1);
			
			smt = JDBCConnection.getConnection().createStatement();
			System.out.println("Verifying table two " + tab2);
			GeneralUtil.verifyTable(JDBCConnection.getConnection(), smt, tab2, db);
			GeneralUtil.closeStatement(smt);
			System.out.println("Closing table two " + tab2);
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	@When("^I call no_of_films_cat procedure for table film_category$")
	public void i_call_no_of_film_cat_procedure_for_table() throws Throwable {
		String sql = "{call no_of_films_cat(?)}";
	    cstmt = JDBCConnection.getConnection().prepareCall(sql);
	    cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
	    System.out.println("Executing the procedure");
	    cstmt.execute();
	    int film_count = cstmt.getInt(1);
	    Entity.setIntResult(film_count);
	    System.out.println("Procedure result is " + film_count);
	    System.out.println("Closing the statement");
	    GeneralUtil.closeCallableStmt(cstmt);
	}

	@Then("^the count of rows is equal to table film_cate rows$")
	public void the_count_of_rows_is_equal_to_table_rows() throws Throwable {
	    String sql = "select count(*) from sakila.film_cate";
	    smt = JDBCConnection.getConnection().createStatement();
	    System.out.println("Executing the procedure");
	    ResultSet rs = smt.executeQuery(sql);
	    rs.first();
	    int result2 = rs.getInt(1);
	    System.out.println("The film count is " + result2);
	    GeneralUtil.closeStatement(smt);
		System.out.println("Closing statement " );
		//get the result from above and compare it
	}
	
	@Then("^the resources are closed$")
	public void the_resources_are_closed() throws Throwable {
		System.out.println("Closing resources " );
	}


}
