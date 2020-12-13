package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.arjun.models.MyAccount;
import com.arjun.util.MyConnectionFactory;

public class MyEmployeeDAO {
	
	private Statement st;
	private PreparedStatement pst;
	
	private MyConnectionFactory mcf = MyConnectionFactory.getConnectionFactory();
			Connection conn = mcf.getConnection();
			
			//get pending account 
			public List<MyAccount> getPendingAccount(){
				
				List<MyAccount> myAccounts = new ArrayList<MyAccount>();
				
				
				String sql ="Select accountid, userid, ballence from account where status = 0 ";
				
				try {
					pst = conn.prepareStatement(sql);
					
					ResultSet rst = pst.executeQuery();
					
					while(rst.next()) {
						MyAccount accounts = new MyAccount();
						accounts.setAccountId(rst.getInt(1));
						accounts.setUserId(rst.getInt(2));
						accounts.setAccountBallence(rst.getDouble(3));
						
						myAccounts.add(accounts);		
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return myAccounts;
				
				
			}
			
			// this method update the account table for the status of the account  
			
			public Boolean approveAccount(int accountId, int status) {
				
				Boolean isAccountApproved = false;
				
				String sql = "update account set status = ? where accountid = ?";
				
				try {
					pst = conn.prepareStatement(sql);
					pst.setInt(1, status);
					pst.setInt(2, accountId);
					
					int rst = pst.executeUpdate();
					
					if(rst != 0) isAccountApproved = true;  
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return isAccountApproved;
			}
			
			// this will update the users table for the security level for the manuchage
			
			public Boolean approveCustomerAccount(int uid, int status) {
				Boolean isAccountApproved = false;
				
				String sql = "update users set security_level = ? where user_id = ?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setInt(1, status);
					pst.setInt(2, uid);
					
					int rst = pst.executeUpdate();
					
					if(rst != 0) isAccountApproved = true;  
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return isAccountApproved;
				
				
				
			}

}
