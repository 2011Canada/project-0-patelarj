package com.arjun.menu;

public class MyMenu {
	
			

		
		// Display Main Login Page 
			
	   static public String loginMenu() {
				
				return "####################################"+ "\n" + 
						"1. Log In"+ "\n" + 
					   "2. Creat Account" + "\n" +
						"Make Your Choice : ";
				
			}
		
		// Display user Menu
		static public String userMenu() {
			
			return "####################################"+ "\n" +
					"1. Apply for Account " +"\n"+
				   "2. Log Out"  +"\n"+
				    "Make Your Choice : ";
			
		    }
		
		static public String customerMenu() {
			
			return "####################################\n" +
					"1. View Account Ballence \n"+
				   "2. Make Transfer \n"+
				   "3. Accept Transfer \n"+
				   "4. Deposit & Widrow Money \n"+
				   "5. Log Out \n"+
				   "Make Your Choice : ";
				   
			
		}  
		
		static public String employeeMenu() {
			
			return "####################################\n" +
					"1. View Account Request \n"+
					   "2. view Customer Account \n"+
					   "3. View All Transection \n"+
					   "5. Log Out \n"+
					   "Make Your Choice : ";
					   
			
		}
		
		
			
 
 

}
