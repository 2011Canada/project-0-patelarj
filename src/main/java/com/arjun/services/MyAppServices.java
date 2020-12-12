package com.arjun.services;

import java.util.Scanner;

import com.arjun.models.MyUsers;
import com.arjun.util.MyConnectionFactory;

import repositories.MyAppDAO;

public class MyAppServices {

	MyAppDAO one = new MyAppDAO();
	MyUsers user = new MyUsers();
	Scanner newScan = new Scanner(System.in);
	
	public MyUsers logInService() {
		
		int uid;
		do {
		System.out.println("Please Enter the username :");
		String userName = newScan.nextLine();
		System.out.println("Please Enter the Password :");
		String passWord = newScan.nextLine();
		
		uid = one.checkLogin(userName, passWord);
		
		if (uid == -1) {
			System.out.println("Pleae Try again no user found");
			
		}
		}
		while(uid == -1);
		return user = one.getUsers(uid);
		
		
		
	}
	
	public Boolean creatUserService() {
		Boolean isUserCreated;
		
		String uname;
		System.out.println("Please Enter First Name :");
		user.setFirstName(newScan.nextLine());
		System.out.println("Please Enter Last Name :");
		user.setLastName(newScan.nextLine());
		
		do {
			
			System.out.println("Please Enter Username:");
			uname = newScan.nextLine();
			if(!one.isUserUnique(uname)) {
			
				System.out.println("Username already exists ");
			}
			
		}
		while(!one.isUserUnique(uname));
		user.setUserName(uname);
		
		System.out.println("Please Enter Password");
		user.setPssWord(newScan.nextLine());
		user.setSecurityLevel(0);
		
		isUserCreated = one.creatLogin(user);
		
		return isUserCreated;
		
	}
	
	
	
}
