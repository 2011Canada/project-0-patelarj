package com.arjun.menu;

public class MyMenu {
	
			

		
		// Display Main Login Page 
			
	    public String loginMenu() {
				
				return "####################################"+ "\n" + 
						"1. Login"+ "\n" + 
					   "2. Create Account" + "\n" +
						"Make Your Choice : ";
				
			}
		
		// Display user Menu
		public String userMenu() {
			
			return "####################################"+ "\n" +
					"1. Logout"  +"\n"+
					"2. Apply for Account " +"\n"+
				  
				    "Make Your Choice : ";
			
		    }
		
		public String customerMenu() {
			
			return "####################################\n" +
				   "1. Logout \n"+
				   "2. View Account Balance \n"+
				   "3. Make Transfer \n"+
				   "4. Accept Transfer \n"+
				   "5. Deposit or Withdrow Money \n"+
				   
				   "Make Your Choice : ";
				   
			
		}  
		
		 public String employeeMenu() {
			
			return "####################################\n" +
					"1. Logout \n"+
					"2. View Account Request \n"+
					"3. view Customer Account \n"+
					"4. View All Transections \n"+
					"Make Your Choice : ";
					   
			
		}
		
		
			
 
 

}
