package com.arjun.menu;

import java.util.Scanner;

import com.arjun.models.MyUsers;

public class MyMenuManager {
	
	
	
	static MyMenu myMenu = new MyMenu();
	static Scanner myScanner = new Scanner(System.in);
	
	// this method validate the user input and display the log in option.
	public static int displayMainPage()   {
		
		int userInput = 0;
		
		Boolean swi = true;
		
		while(swi) {
		
			try {
			System.out.println(myMenu.loginMenu());
			
			userInput =Integer.parseInt(myScanner.nextLine()); 
			
			}
			catch (NumberFormatException e) {
				System.out.println("Please Enter valid number");
			}
			
			if (userInput > 0 && userInput <=2 ) {
				
				swi = false;
				
			}	
			
		}
	
		return userInput;	
		
		
	}
	
	public static int menuManager(MyUsers one) {
		
		
		
		if(one.getSecurityLevel() == 0) {
		  return displayUserMenu(one);
		}
		else if (one.getSecurityLevel()== 1) {
			return displayCustomerMenu(one);
		}
		else if(one.getSecurityLevel()==2) {
			return displayEmployeeMenu(one);
		}
		else {
			System.out.println("User not exist");
		}
		
		return 1;
		
	}
	
	public static int displayUserMenu(MyUsers one) {
		int userInput =0 ;
		Boolean swi = true;
		
		
		
		while(swi) {
			
			System.out.println("Hello :"+one.getFirstName()+" "+one.getLastName()+"...");
			try {
				System.out.println(myMenu.userMenu());
				userInput =Integer.parseInt(myScanner.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("Please Enter valid number");
			}
			if (userInput > 0 && userInput <=2 ) {
				
				swi = false;
				
			}	
			
		}
		
		return userInput;
	}
	
	public static int displayCustomerMenu(MyUsers one) {
		int userInput = 0;
		Boolean swi = true;
		
		while(swi) {
			System.out.println("Hello :"+one.getFirstName()+" "+one.getLastName()+"...");
			try {
				System.out.println(myMenu.customerMenu());
				userInput =Integer.parseInt(myScanner.nextLine());
			}
			catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Please Enter valid number");
			}
			if(userInput > 0 && userInput <= 5) {
				swi = false;
			}
		}
		
		return userInput;
	}
	
	public static int displayEmployeeMenu(MyUsers one) {
		int userInput = 0;
		Boolean swi = true;
		while(swi) {
			System.out.println("Hello :"+one.getFirstName()+" "+one.getLastName()+"...");
			try {
				System.out.println(myMenu.employeeMenu());
				userInput =Integer.parseInt(myScanner.nextLine());
			}
			catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Please Enter valid number");
			}
			if(userInput > 0 && userInput <= 5) {
				swi = false;
			}
		}
		
		return userInput;
	}
	

}
