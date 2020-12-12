package com.arjun.models;

public class MyAccount {
	private int accountId;
	private int userId;
	private double accountBallence;
	private int accountStatus;
	public MyAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyAccount(int accountId, int userId, double accountBallence, int accountStatus) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.accountBallence = accountBallence;
		this.accountStatus = accountStatus;
	}
	
	public MyAccount(int accountId, int userId, double accountBallence) {
		
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.accountBallence = accountBallence;
		this.accountStatus = 0;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getAccountBallence() {
		return accountBallence;
	}
	public void setAccountBallence(double accountBallence) {
		
		if(accountBallence>=0) {
			this.accountBallence = accountBallence;
		
		}
		
	}
	public int getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	
	
	
	
	
	
}
