package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.arjun.models.MyAccount;
import com.arjun.models.MyTransfer;
import com.arjun.models.MyUsers;
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
			
			// this method returns true if active account is available else return false 
			// takes in account id
			
			public Boolean isAccountAvilable(int accountid) {
				
				Boolean isAccoutunique = false;
				
				String sql = "select * from account where accountid = ? and status = 1 ";
				
				try {
					pst = conn.prepareStatement(sql);
					pst.setInt(1, accountid);
					ResultSet res = pst.executeQuery();
					if(res.next()) {
						isAccoutunique  = true ;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				return isAccoutunique;
				
			}
			
			
			// returns account_id takes user id if account not found or not approved then returns -1
			
			
			public int findAccountId(int uid) {
				
				int accountNumber = -1 ;
				
				String sql = "select accountid from account where userid =? and status = 1";
				
				try {
					pst = conn.prepareStatement(sql);
					pst.setInt(1, uid);
					
					ResultSet res = pst.executeQuery();
					if(res.next()) {
						accountNumber = res.getInt(1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				return accountNumber;
				
				
			}
			
			// returns true if transfer request successfully added to the database 
			
			public Boolean transfer(MyTransfer transfer) {
				Boolean done = false;
				
				String sql = "insert into transfer (from_account_acid, to_account_acid, amount, approval)"+
							"values(?, ?, ?, ?)";
				
					try {
						pst = conn.prepareStatement(sql);
						pst.setInt(1, transfer.getFromAccountId());
						pst.setInt(2, transfer.getToAccountId());
						pst.setDouble(3, transfer.getAmount());
						pst.setInt(4, transfer.getApproval());
						
						int rst = pst.executeUpdate();
						if(rst != 0) {
							done = true;
							
						}
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				return done;
			}
			
			
			// update the transection if approve or not in transection table in data base if success returns true or false
			
			public Boolean updateTransferTable(MyTransfer transfer, int responce) {
				Boolean done = false;
				
				String sql = "update transfer set approval = ? where transaction_id = ?";
				
				try {
					pst = conn.prepareStatement(sql);
					pst.setInt(1, responce);
					pst.setInt(2, transfer.getTransactionId());
					
					int rst = pst.executeUpdate();
					if(rst != 0) {
						done = true;
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return done;
				
			}
			
			
		// return the account ballece of perticuler user 
			
			public double getBallence(int userId) {
				double ballence = 0 ;
				
				String sql = "select ballence from account where userid = ? ";
				
				try {
					pst = conn.prepareStatement(sql);
					pst.setInt(1, userId);
					
					ResultSet rest = pst.executeQuery();
					
					if(rest.next()) {
						
						ballence = rest.getDouble(1);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return ballence; 
					
				
				
			}
			
			public Boolean updateBallence(double ballence, int userid  ) {
				Boolean done = false;
				
				String sql = "Update account set ballence = ? where userid = ?";
				
				try {
					pst = conn.prepareStatement(sql);
					pst.setDouble(1, ballence);
					pst.setInt(2, userid);
					
					int rst = pst.executeUpdate();
					
					if(rst != 0) done = true;  
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return done;
			}
			
			public List<MyTransfer> getPendigTransfer(int accountId){
				
				
				List<MyTransfer> transfer = new ArrayList<MyTransfer>();
				
				
				String sql ="Select transaction_id, from_account_acid, to_account_acid, amount from transfer where approval = 0 and to_account_acid = ? and amount > 0 ";
				
				try {
					pst = conn.prepareStatement(sql);
					pst.setInt(1, accountId);
					
					ResultSet rst = pst.executeQuery();
					
					while(rst.next()) {
						MyTransfer accounts = new MyTransfer();
						accounts.setTransactionId(rst.getInt(1));
						accounts.setFromAccountId(rst.getInt(2));
						accounts.setToAccountId(rst.getInt(3));
						accounts.setAmount(rst.getDouble(4));
						
						transfer.add(accounts);		
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return transfer;
			}
			
			
			// this will return -1 if user id not found 
			// this will find the userid from the account id; 
			public int getUserIdByAccountId(int accountId) {
				
				int userid = -1;
				
				String sql ="Select userid from account where accountid = ?";
				
				try {
					pst = conn.prepareStatement(sql);
					pst.setInt(1, accountId);
					
					ResultSet rst = pst.executeQuery();
					
					while(rst.next()) {
						
						userid = rst.getInt(1);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				return userid;
				
				
			}
			

}
