package StepDefinition;

import java.net.URL;

import java.sql.*;

import setupdb.Entity;
import setupdb.JDBCConnection;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CommonHooks {
	
	public CommonHooks() {
	}

	@Before
	public static void initJdbcCon() throws Exception {
		System.out.println("initialising server set up");
		Connection conn;
		conn = JDBCConnection.getConnection();
		System.out.println("setting connection as conn");
		JDBCConnection.setDbConn(conn);
		
	}


	@After
	public static void closeResources() throws Exception {
		System.out.println("Closing the connection");

		if (JDBCConnection.getConnection() != null) {
			JDBCConnection.closeConnection(JDBCConnection.getConnection());
		}
		System.out.println("Connection closed");
		
	}

}
