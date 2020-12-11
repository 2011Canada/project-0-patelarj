package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.arjun.models.MyUsers;
import com.arjun.util.MyConnectionFactory;

public class MyAppDAO  {
	
	private Statement st;
	private PreparedStatement pst;
	
	private MyConnectionFactory mcf = MyConnectionFactory.getConnectionFactory();
			Connection conn = mcf.getConnection();
			
	// this method checks if the user exist in the data base
	public int checkLogin(String uname, String upass) {
		
		int uid = -1; // login is not successfull 
		
		String sql =  "select user_id from users " + 
				 "where user_name ='"+ uname +"' and pssword ='"+upass+"'";
		
	
		
		try {
			st = conn.createStatement();
			//st = conn.createStatement(sql);
			//st.setString(1, uname);
			//st.setString(2, upass);
			ResultSet res = st.executeQuery(sql);
			
			
			if(res.next()) {
				uid = res.getInt(1); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return uid;
	}
	
	// get the the first and last of the user form the user table 
	
	public MyUsers getUsers(int uid) {
		
		MyUsers newUser = new MyUsers();
		
		String sql = "select firstname, lastname, security_level from users where user_id ="+ uid;
		
			try {
				st = conn.createStatement();
				//pst = conn.prepareStatement(sql);
				//pst.setInt(1, uid);
				ResultSet res = st.executeQuery(sql);
				if(res.next()) {
				newUser.setFirstName(res.getString(1));
				newUser.setLastName(res.getString(2));
				newUser.setSecurityLevel(res.getInt(3));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return newUser;
		
		
	}
	
	

}
