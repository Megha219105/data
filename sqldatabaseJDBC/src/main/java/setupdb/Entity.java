package setupdb;

import java.sql.Connection;

//import java.sql.*;

public class Entity {
	
	private static String dbURL = "jdbc:mysql://localhost:3306/";
	private static String database = "sakila";
	private static String dbUserName = "dev";
	private static String dbPassword = "Pass1235";
	private static String dbDriver = "com.mysql.jdbc.Driver";
	public static Connection conn;
	public static int intResult;
	
	
	//Set dburl
	public void setDbUrl(String url) {
		dbURL = url;
	}
	
	//Get dbURL
	public static String getDbUrl() {
		return dbURL;
	}
	
	//setDatabase
	public void setDatabase(String db) {
		database = db;
	}
	
	//getDatabse
	public static String getDatabase() {
		return database;
	}
	
	//set dbUserName
	public void setUserName(String un) {
		dbUserName = un;
	}
	
	//getDatabse
	public static String getUserName() {
		return dbUserName;
	}
		
	//setPassword
	public void setPassword(String pass) {
		dbPassword = pass;
	}
	
	//getDatabse
	public static String getPassword() {
		return dbPassword;
	}
	
	//set dbdriver
	public void setDbDriver(String driver) {
		dbDriver = driver;
	}
	
	//get dbdriver
	public static String getDbDriver() {
		return dbDriver;
	}
	
	//set int result
	public static void setIntResult(int result) {
				intResult = result;
	}

}
