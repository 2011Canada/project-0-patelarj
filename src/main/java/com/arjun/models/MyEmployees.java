package com.arjun.models;

public class MyEmployees extends MyUsers {
	
	private int eId;
	
	public MyEmployees(String firstName, String lastName, String userName, String pssWord, int eId) {
		super(firstName, lastName, userName, pssWord);
		// TODO Auto-generated constructor stub
		
		this.eId = eId;
	}


}
