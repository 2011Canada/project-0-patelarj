package com.arjun.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// this calss will create the connection to database. 

public class MyConnectionFactory {
	
	
	private static MyConnectionFactory mcf = new MyConnectionFactory(1);
	
	
	public static  MyConnectionFactory getConnectionFactory() {
		
		return mcf;
		
	}
	
	
	private Connection [] conn;
	
	
	private MyConnectionFactory(int numberOfConnections) {
		
		 String url =System.getenv("URL");
		 String uname =System.getenv("U_NAME");
		 String upass =System.getenv("U_PASS");
		 
		 this.conn = new Connection[numberOfConnections];
		 for(int i = 0; i< this.conn.length; i++) {
			 
			 try {
				Connection conn = DriverManager.getConnection(url, uname, upass);
				this.conn[i] = conn;
			 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
		
		
	}
	
	public Connection getConnection() {
		//TODO
		return this.conn[0];
	}
	
	public void releaseConnection(Connection conn) {
		//TODO
	}


}
