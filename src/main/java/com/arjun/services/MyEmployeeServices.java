package com.arjun.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

import com.arjun.models.MyAccount;
import com.arjun.models.MyTransfer;
import com.arjun.models.MyUsers;

import repositories.MyAppDAO;
import repositories.MyEmployeeDAO;

public class MyEmployeeServices {

	
	
		File two = new File("E:\\project-0-patelarj\\logs\\trace.log");
		
		
		MyEmployeeDAO empDAO = new MyEmployeeDAO();
		MyAppDAO appDAO = new MyAppDAO();
		List<MyAccount> accounts = new ArrayList<MyAccount>();
		List<MyTransfer> transfers = new ArrayList<MyTransfer>();
		MyUsers user = new MyUsers();
		Scanner newScan = new Scanner(System.in);
		
		
		private void pandingAccount() {
			
			
		accounts =	empDAO.getPendingAccount();
			
			
			
		for(int i = 0; i< accounts.size(); i++) {
				System.out.println("########################################################################################################################################");
				System.out.println("AccountID : "+accounts.get(i).getAccountId()+" UserID : "+accounts.get(i).getUserId()+" Ballence : "+accounts.get(i).getAccountBallence());
				
				
			}
		
			
		
	
		}
		
		public void getAllAccount() {
			
			accounts =	empDAO.getAllApprov();
			
			
			
			
			for(int i = 0; i< accounts.size(); i++) {
				user = appDAO.getUsers(accounts.get(i).getUserId());
				
					System.out.println("########################################################################################################################################");
					System.out.println("Name : "+ user.getFirstName() +" "+ user.getLastName() +" Account ID : "+accounts.get(i).getAccountId()+" User ID : "+ accounts.get(i).getUserId()+" Ballence : "+accounts.get(i).getAccountBallence());
					
					
				}
			
			
			
			
		}
		
		
	// chekes if the account request is exists 	
		
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
		
		
	// this will ask for user input to approve the or rejest
		
		
		public int approveAccount() throws InputMismatchException, NumberFormatException {
			
			
			
			int[] userinfo = new int[2];
			
			int ans;
			do {
				
				pandingAccount();
				System.out.println("Please Enter the AccountID to Approve / reject or 0 to exit ");
			
				ans = Integer.parseInt(newScan.nextLine());
				userinfo = isRequestExists(accounts, ans);
				
				if(userinfo[0] !=0 && userinfo[1] != 0) {
					
				 System.out.println("please enter 1 for Approve 2 for reject");
				 int apprej =Integer.parseInt(newScan.nextLine()) ;
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
		
		public void getAllTrenasfer() {
			
			
			transfers  = empDAO.getAllTransfer();

			for(int i = 0; i< transfers.size(); i++) {
				System.out.println("########################################################################################################################################");
				System.out.println("Transfer ID : "+transfers.get(i).getTransactionId()+" From Account ID : "+transfers.get(i).getFromAccountId()+" To Account ID :"+ transfers.get(i).getToAccountId() +" Amount : "+transfers.get(i).getAmount());

			}
			
		}
		
		public void getAllLog() {
			
			try {
				Scanner scan = new Scanner(two);
				while(scan.hasNextLine()) {
					String line = scan.nextLine();
					System.out.println(line);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
}


	

