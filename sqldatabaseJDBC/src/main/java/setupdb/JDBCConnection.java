package setupdb;

import java.sql.*;

public class JDBCConnection extends Entity {
	
	private static Connection conn;
	
 
    public static Connection getConnection() throws Exception {
        
    	
    	if (conn == null) {
        	System.out.println("Connecting to database...");
            Class.forName(getDbDriver()).newInstance();
            conn = DriverManager.getConnection(getDbUrl() + getDatabase(),
                    getUserName(), getPassword());
            System.out.println("Connected to database...");
            
            System.out.println("Returning Connection...");
            
            
        	return conn;}
        	
      
    	 else return conn;
 
    }
    
    //Set connection to conn
    public static void setDbConn(Connection dbConn) {
		conn = dbConn;
	}
 
    

	public static void closeConnection(Connection dbConnection) {
        try {
            if (dbConnection != null) {
            dbConnection.close();}
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
 
    }
 
    /*
     * Usage Example
     
    public static void main(String args[]) throws Exception {
        JDBCConnection jdbc = new JDBCConnection();
        Connection conn = jdbc.getConnection();
 
        String sqlQuery = "Select * from myTable";
        Statement st = conn.createStatement();
        st.execute(sqlQuery);
 
        /*
         * Finally Close the connection The second parameter is just used for
         * error printing
         
        jdbc.closeConnection(conn, JDBCConnection.class.getName());
 
    }
	*/

}
