package com.arjun.services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

import com.arjun.models.MyAccount;


import repositories.MyEmployeeDAO;

public class MyEmployeeServices {

	
	
	
		
		MyEmployeeDAO empDAO = new MyEmployeeDAO();
		List<MyAccount> accounts = new ArrayList<MyAccount>();
		Scanner newScan = new Scanner(System.in);
		
		
		public void pandingAccount() {
			
			
		accounts =	empDAO.getPendingAccount();
			
			
			
		for(int i = 0; i< accounts.size(); i++) {
				System.out.println("########################################################################################################################################");
				System.out.println("AccountID : "+accounts.get(i).getAccountId()+" UserID : "+accounts.get(i).getUserId()+" Ballence : "+accounts.get(i).getAccountBallence());
				
				
			}
		
			
		
	
		}
		
		
		private int[] isRequestExists(List<MyAccount> one, int accountID ) {
			
			int[] userinfo = new int[2];
			for(int i =0; i< one.size(); i++) {
				
				if(one.get(i).getAccountId() == accountID) {
					
					userinfo[0] = accountID;
					userinfo[1] = one.get(i).getUserId();
					
				}
				
				
			}
			
			return userinfo;
			
			
		} 
		
		
		public int approveAccount(){
			
			
			int[] userinfo = new int[2];
			
			int ans;
			do {
				
				pandingAccount();
				System.out.println("Please Enter the AccountID to Approve / reject or 0 to exit ");
			
				ans = newScan.nextInt();
				userinfo = isRequestExists(accounts, ans);
				
				if(userinfo[0] !=0 && userinfo[1] != 0) {
					
				 System.out.println("please enter 1 for Approve 2 for reject");
				 int apprej = newScan.nextInt();
				if(apprej> 0 & apprej <3) {
					
					if(empDAO.approveAccount(userinfo[0], apprej) & empDAO.approveCustomerAccount(userinfo[1], apprej) )   {
						
						System.out.println("Account "+ ans +" has been Successfully updated ");
						
						
					}
					
				}
				
				}
				
				pandingAccount();
				}
				while(ans != 0);
				
					return ans;
			
			
			
			
		}
		
}


	

