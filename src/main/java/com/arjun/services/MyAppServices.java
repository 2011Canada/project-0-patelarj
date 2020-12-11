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
		
		System.out.println("Please Enter the username :");
		String userName = newScan.nextLine();
		System.out.println("Please Enter the Password :");
		String passWord = newScan.nextLine();
		
		int uid = one.checkLogin(userName, passWord);
		
		if (uid == -1) {
			System.out.println("Pleae Try again no user found");
			
		}
		return user = one.getUsers(uid);
		
		
		
	}
	
	
	
}
