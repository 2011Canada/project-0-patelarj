package com.arjun.services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.arjun.models.MyAccount;
import com.arjun.models.MyTransfer;
import com.arjun.models.MyUsers;

import repositories.MyAccountDAO;
import repositories.MyAppDAO;

public class MyAccountServices {

	
	MyAccountDAO accountDAO = new MyAccountDAO();
	 MyAccount account = new MyAccount();
	 MyTransfer transfer = new MyTransfer();
	 List<MyTransfer> transfers = new ArrayList<MyTransfer>();
	Scanner newScan = new Scanner(System.in);
	
	
	// this method request MyAppDAO to create the account with the balance if fails return false 
	// Success will return true
	
	public Boolean accountApplication(MyUsers one) {
		
		
		double ballence = -1;
		
		
		if(accountDAO.isAccountUnique(one.getUserId())) {
		
			account.setUserId(one.getUserId());
		do {
			
		System.out.println("Please enter initial account balance : ");	
		try {
			
		ballence = newScan.nextDouble(); 
		account.setAccountBallence(ballence);	
		}
		catch(InputMismatchException e) {
			
			e.getMessage();
		}
		
		}
		while(ballence < 0);
		
	 
		return accountDAO.creatAccount(account);
		}
		
		return false;
		 
		
	}
	
	
	// this takes all the input form the users and creates the instance of MyTransfer and checks the user input
	// takes the user instance as argument. 
	public MyTransfer createTransfer(MyUsers one) throws InputMismatchException {
		
		
		int reciveAccount;
		do {
		System.out.println("Please enter active recipient account number");
		reciveAccount = newScan.nextInt();
		if(accountDAO.isAccountAvilable(reciveAccount) && accountDAO.findAccountId(one.getUserId()) != -1) {
			
			transfer.setFromAccountId(accountDAO.findAccountId(one.getUserId()));
			transfer.setToAccountId(reciveAccount);
			
			
			System.out.println("Pleae Enter the Amount need to be transfer");
			double amount =  newScan.nextDouble();
			transfer.setAmount(amount);
			
			transfer.setApproval(0);
			
		}
		
		}
		while(!accountDAO.isAccountAvilable(reciveAccount) || accountDAO.findAccountId(one.getUserId()) == -1);
		return transfer ;
		
		
	}
	
	// return false if transfer unsuccessful  to insert in the database else true 
	public Boolean transferNow(MyTransfer transfer) {
		
		Boolean done = false;
		
		if(accountDAO.transfer(transfer)) {
			
			done = true;
		}
		
		return done;
		
		
	}
	
	
	
	// get the account ballence of perticuler userid 
	
	public double getAccountBallence(int userid) {
		
		
		return accountDAO.getBallence(userid);
		
	}
	
	
	
	// this will update the user account ballence.
	
	public Boolean updateBallenceTransfer(int userid, double updateBy) {
		
		Boolean neg = false;
		double update = getAccountBallence(userid) - updateBy;
		
		if(update >= 0 ) {
			
			accountDAO.updateBallence(update, userid);
			neg = true;
			
		}
		
		return neg;
		
		
	}
	
	// this will update the accepted transection 
	
	public Boolean updateBAllenceTransfeAccept(int userid, double updateBy) {
		
		Boolean neg = false;
		double update = getAccountBallence(userid) + updateBy;
		
		if(update >= 0 ) {
			
			accountDAO.updateBallence(update, userid);
			neg = true;
			
		}
		
		return neg;
		
	}
	
	// Display all the upapprove transection for the user 
	
	public void pandingTransection(int accountid) {
		
		transfers = accountDAO.getPendigTransfer(accountid);
			
			for(int i = 0; i< transfers.size(); i++) {
				System.out.println("########################################################################################################################################");
				System.out.println("Transfer ID : "+transfers.get(i).getTransactionId()+" From Account ID : "+transfers.get(i).getFromAccountId()+" Amount : "+transfers.get(i).getAmount());
				
		}
		
		
	}
	
}
