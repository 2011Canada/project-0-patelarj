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
									
									
									int respoce = accountServices.approveTransection(one.getUserId());
									
									if(respoce == 0) {
									userinputat2 = MyMenuManager.menuManager(one);
									}
									
									
								break;
								case 5:
									
										Boolean issuccess = false;
									
										
											issuccess = accountServices.depositOrWidrow(one.getUserId());
											System.out.println(issuccess);
										if(!issuccess) {
											
											System.out.println("Please Enter the valid amount");
											userinputat2 = 2;
										}
										else if(issuccess) {
											System.out.println("Your Transfer is Complit"); 
											userinputat2 = 2;
										}
										 
										//userinputat2 = MyMenuManager.menuManager(one);
										
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
									
									
									employeeServices.getAllAccount();
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
		
		
	}

}
