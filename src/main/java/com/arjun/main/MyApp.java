package com.arjun.main;


import com.arjun.menu.MyMenuManager;
import com.arjun.models.MyTransfer;
import com.arjun.models.MyUsers;
import com.arjun.services.MyAccountServices;
import com.arjun.services.MyAppServices;
import com.arjun.services.MyEmployeeServices;

import repositories.MyAccountDAO;
import repositories.MyAppDAO;


public class MyApp {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int userinput, userinputat2 = 0 ;
		//Boolean sw = true;
	MyUsers one = new MyUsers();
	MyAppServices appServices = new MyAppServices();
	MyAccountServices accountServices = new MyAccountServices();
	MyEmployeeServices employeeServices = new MyEmployeeServices();
	MyTransfer transfer = new MyTransfer();
	
		
		do {
			
			userinput = MyMenuManager.displayMainPage();
			Boolean sw = true;
			
			switch (userinput) {
			case 1:
				
						one = appServices.logInService();
						userinputat2 = MyMenuManager.menuManager(one);
						
						//this block //
						do {
						if(one.getSecurityLevel()==0) {
						
							
								switch(userinputat2) {
								case 1:
								
									//userinput = MyMenuManager.displayMainPage();
									sw = false;
									break;
								case 2:
							
									Boolean isApplicationDone = accountServices.accountApplication(one);
									if(isApplicationDone) {
										System.out.println("your accout application is Done Please wait for the approval :");
									}
									else {
										System.out.println("your account application is unsuccessful or you already have application panding please try again ");
									}
									userinputat2 = MyMenuManager.menuManager(one);
							
							
							
								break;
								}
						
							}
							
						//
						//This block will execute if the user is account holder 
						//
						//
						else if(one.getSecurityLevel() ==1) {
							
							
								switch(userinputat2) {
								case 1:
										
									
									sw = false;
								
								break;
								case 2:
									
									System.out.println("############################################");
									System.out.println("Your Account Ballence is $" + accountServices.getAccountBallence(one.getUserId()));
									userinputat2 = MyMenuManager.menuManager(one);
									
									
								break;
								case 3:
									
									Boolean done = true;
									
									do {
									transfer = accountServices.createTransfer(one);
									
									if(accountServices.updateBallenceTransfer(one.getUserId(), transfer.getAmount())) {
										done = accountServices.transferNow(transfer);
										
									
									}
									else {
										System.out.println("Can not Transfer Money ");
									}
									
									
									}
									while(!done);
									
										
										
										userinputat2 = MyMenuManager.menuManager(one);
																		
									
									
								break;
								case 4:
									
									System.out.println("you have selecter 4");
								break;
								case 5:
									
									System.out.println("you have selecter 5");
								break;

								}
								
								}
								
						
						
						//this block will execute if the user is Employee 
						else if(one.getSecurityLevel() == 2) {
							
								switch(userinputat2) {
								case 1:
									
									
									sw = false;
								break;
								case 2:
									
									int out;
										do {
									   out =  employeeServices.approveAccount(); 
										
										}
									   while(out!=0) ;
										
									   
									   userinputat2 = MyMenuManager.menuManager(one);
									
								break;
								case 3:
									
									System.out.println("you have selecter 3");
								break;
								case 4:
									
									System.out.println("you have selecter 4");
								break;
								case 5:
									
									System.out.println("you have selecter 5");
								break;


								
								
								}
							
								
							}
							
						//this is default block 
						else {
							System.out.println("Somthing Whent wrong");
						}
						
						
						}
						while(sw);
				
						break;	
			case 2:
					Boolean isUserCreated = appServices.creatUserService();
					if(isUserCreated) {
						System.out.println("New account created please Login now ");
					}
				break;
			}
			
		}
		while(userinput != 3);
		
	
	/*System.out.println("hello ");
	
	MyAppDAO one = new MyAppDAO();
	MyUsers two = new MyUsers(); 
	
	int uid = one.checkLogin("arjun22", "7829");
	
	two = one.getUsers(uid);
	
	
	System.out.println("My name is :" +two.getFirstName()+ "\n" +
						"My Last nem is "+two.getLastName());
	*/
	
		
	}

}
