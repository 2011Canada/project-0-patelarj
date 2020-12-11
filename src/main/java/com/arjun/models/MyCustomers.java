package com.arjun.models;

public class MyCustomers extends MyUsers {
	
	private double bankBallence;
	
	private Boolean isCustomer;
	
	
	public MyCustomers(String firstName, String lastName, String userName, String pssWord, double bankBallence, Boolean isCustomer) {
		// TODO Auto-generated constructor stub
		super(firstName, lastName, userName, pssWord);
		this.bankBallence = bankBallence;
		this.isCustomer = isCustomer;
		
	}


	public double getBankBallence() {
		return bankBallence;
	}


	public void setIsCustomer(Boolean isCustomer) {
		this.isCustomer = isCustomer;
	}


	public void setBankBallence(double bankBallence) {
		this.bankBallence = bankBallence;
	}

	
 
	
	

}
