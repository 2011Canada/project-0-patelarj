package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.arjun.models.MyAccount;
import com.arjun.models.MyUsers;
import com.arjun.util.MyConnectionFactory;

public class MyAppDAO  {
	
	private Statement st;
	private PreparedStatement pst;
	
	private MyConnectionFactory mcf = MyConnectionFactory.getConnectionFactory();
			Connection conn = mcf.getConnection();
			
	// this method checks if the user exist in the data base and compare the log in and password and retun user id
	// if user and password is fail then return -1
	// if user and password is true then retune user id form the table 
	public int checkLogin(String uname, String upass) {
		
		int uid = -1; // login is not successfull 
					
		try {
			String sql =  "select user_id from users " + 
					 "where user_name = ? and pssword = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, uname);
			pst.setString(2, upass);
						
			ResultSet res = pst.executeQuery();
						
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
	// take user id as the 
	
	public MyUsers getUsers(int uid) {
		
		MyUsers newUser = new MyUsers();
		
		String sql = "select firstname, lastname, security_level, user_id from users where user_id = ?";
		
			try {
				//st = conn.createStatement();
				pst = conn.prepareStatement(sql);
				pst.setInt(1, uid);
				ResultSet res = pst.executeQuery();
				if(res.next()) {
				newUser.setFirstName(res.getString(1));
				newUser.setLastName(res.getString(2));
				newUser.setSecurityLevel(res.getInt(3));
				newUser.setUserId(res.getInt(4));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return newUser;
		
		
	}
	
	// this method checks if user name is already exist in the data base if so it will return false if not will return true ,
	
	public Boolean isUserUnique(String userName) {
		
		Boolean ans = true;
		String sql = "select user_name from users where user_name = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userName);
			ResultSet res = pst.executeQuery();
			if(res.next()) {
				ans  = false ;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ans;
	}
	
	public Boolean creatLogin(MyUsers user) {
		Boolean userCreated = true;
		String sql = "insert into users (firstname, lastname, user_name, pssword, security_level)"
					+"values(?, ?, ?, ?, ?) ";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastName());
			pst.setString(3,  user.getUserName());
			pst.setString(4, user.getPssWord());
			pst.setInt(5, user.getSecurityLevel());
			
			int res = pst.executeUpdate();
			
			if(res == 0) userCreated = false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userCreated;
		
		
	}
	
	
	
	

}
