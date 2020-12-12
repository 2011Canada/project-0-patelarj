package com.arjun.services;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.arjun.models.MyAccount;

import com.arjun.models.MyUsers;

import repositories.MyAccountDAO;
import repositories.MyAppDAO;

public class MyAccountServices {

	
	MyAccountDAO accountDAO = new MyAccountDAO();
	 MyAccount account = new MyAccount();
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
	
	
	
}
