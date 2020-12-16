package com.arjun.main;


import java.util.InputMismatchException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arjun.menu.MyMenuManager;
import com.arjun.models.MyTransfer;
import com.arjun.models.MyUsers;
import com.arjun.services.MyAccountServices;
import com.arjun.services.MyAppServices;
import com.arjun.services.MyEmployeeServices;


public class MyApp {

	public static Logger project0 = LogManager.getLogger("com.revature.project0");
	

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
						
						project0.info("User " +one.getUserId() +" is Login");
						
						//this block //
						do {
						if(one.getSecurityLevel()==0) {
						
							
								switch(userinputat2) {
								case 1:
								
									project0.info("User " +one.getUserId() +" is Logout");
									sw = false;
									break;
								case 2:
									
									try {
									Boolean isApplicationDone = accountServices.accountApplication(one);
									if(isApplicationDone) {
										System.out.println("your account application is Done Please wait for the approval...!!!!");
									}
									else {
										System.out.println("your account application is unsuccessful or you already have application pending please try again !! ");
									}
									
									}
									catch(InputMismatchException | NumberFormatException e) {
										System.out.println("Please Enter the valid input");
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
										
									project0.info("User " +one.getUserId() +" is Logout");
									sw = false;
								
								break;
								case 2:
									
									System.out.println("############################################");
									String st1 = String.format("%s%1.2f", "Your Account Balance is $", accountServices.getAccountBallence(one.getUserId()) );
									System.out.println(st1);
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
									
									int responce = -1;
									try {
									responce = accountServices.approveTransection(one.getUserId());
									}
									catch (InputMismatchException | NumberFormatException e) {
										// TODO: handle exception
										System.out.println("Please Enter a valid Choice");
										userinputat2=4;
									}
									if(responce == 0) {
									userinputat2 = MyMenuManager.menuManager(one);
									}
									
									
								break;
								case 5:
									
										Boolean issuccess = false;
									
										try {
											issuccess = accountServices.depositOrWidrow(one.getUserId());
											
										if(!issuccess) {
											
											System.out.println("Please Enter the valid amount");
											
										}
										else if(issuccess) {
											System.out.println("Your Transfer is Complete"); 
											userinputat2 = 2;
										}
										}
										catch (InputMismatchException | NumberFormatException e) {
											// TODO: handle exception
											System.out.println("Please Enter Valid Amount :");
										}
										 
										//userinputat2 = MyMenuManager.menuManager(one);
										
								break;

								}
								
								}
								
						
						
						//this block will execute if the user is Employee 
						else if(one.getSecurityLevel() == 2) {
							
								switch(userinputat2) {
								case 1:
									
									project0.info("User " +one.getUserId() +" is Logout");
									sw = false;
								break;
								case 2:
									
									int out = -1;
										do {
											try {
									   out =  employeeServices.approveAccount(); 
											}
											catch(InputMismatchException | NumberFormatException e) {
												
												System.out.println("Please Enter the valid input");
											}
										}
									   while(out!=0) ;
										
									   
									   userinputat2 = MyMenuManager.menuManager(one);
									
								break;
								case 3:
									
									
									employeeServices.getAllAccount();
									userinputat2 = MyMenuManager.menuManager(one);
									
								break;
								case 4:
									
									
									//employeeServices.getAllTrenasfer();
									employeeServices.getAllLog();
									userinputat2 = MyMenuManager.menuManager(one);
								break;
								


								
								
								}
							
								
							}
							
						//this is default block 
						else {
							System.out.println("Something went wrong twitter");
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
		
		
	}

}
