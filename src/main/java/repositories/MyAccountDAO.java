package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.arjun.models.MyAccount;
import com.arjun.util.MyConnectionFactory;

public class MyAccountDAO {
	
	private Statement st;
	private PreparedStatement pst;
	
	private MyConnectionFactory mcf = MyConnectionFactory.getConnectionFactory();
			Connection conn = mcf.getConnection();
			
			
			// this will return true if account gets created 
			// this will return false if account dose not gets create
			// it take instance of the account object 
			public Boolean creatAccount(MyAccount account) {
				Boolean accountCreated = true;
				
				String sql = "insert into account (userid, ballence, status)"
							+"values(?, ?, ?)";
				
				try {
					pst = conn.prepareStatement(sql);
					
					
					pst.setInt(1, account.getUserId());
					pst.setDouble(2, account.getAccountBallence());
					pst.setInt(3, account.getAccountStatus());
					
					int res = pst.executeUpdate();
					
					if(res == 0) accountCreated = false;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return accountCreated;
			}
			
			// return true if account request is in database 
			// return false if account request is not in database
			// takes user id as input
			
			public Boolean isAccountUnique(int uid) {
				
				Boolean isAccoutunique = true;
				
				String sql = "select * from account where userid = ? ";
				
				try {
					pst = conn.prepareStatement(sql);
					pst.setInt(1, uid);
					ResultSet res = pst.executeQuery();
					if(res.next()) {
						isAccoutunique  = false ;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				return isAccoutunique;
				
				
				
			}

}
