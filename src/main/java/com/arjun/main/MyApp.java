package com.arjun.main;


import com.arjun.menu.MyMenuManager;
import com.arjun.models.MyUsers;
import com.arjun.services.MyAppServices;

import repositories.MyAppDAO;


public class MyApp {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int userinput;
		Boolean sw = true;
	MyUsers one = new MyUsers();
	MyAppServices appServices = new MyAppServices();
		
		do {
			
			userinput = MyMenuManager.displayMainPage();
			
			do {
			switch (userinput) {
			case 1:
				one = appServices.logInService();
				MyMenuManager.menuManager(one);
				userinput =3;
				break;

			case 2:
				break;
			}
			
			}
			while (userinput != 3);
			
			
		}
		while(userinput !=3);
		
	
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
