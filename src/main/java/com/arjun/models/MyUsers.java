package com.arjun.models;

public class MyUsers {

	private String firstName;
	private String lastName;
	private String userName;
	private String pssWord;
	private int SecurityLevel;
	

	public MyUsers(String firstName, String lastName, String userName, String pssWord) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.pssWord = pssWord;
		this.SecurityLevel = 0;
		
	}

	public int getSecurityLevel() {
		return SecurityLevel;
	}

	public MyUsers() {
		
	}
	


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setSecurityLevel(int securityLevel) {
		SecurityLevel = securityLevel;
	}

	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setPssWord(String pssWord) {
		this.pssWord = pssWord;
	}
	
	
	
	
}
