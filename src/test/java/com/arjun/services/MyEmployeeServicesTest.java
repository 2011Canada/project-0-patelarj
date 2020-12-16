package com.arjun.services;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.arjun.models.MyAccount;

public class MyEmployeeServicesTest {
	
	

	
	private MyEmployeeServices emp = mock(MyEmployeeServices.class) ;
	
	@BeforeEach
	public void setupMyEmpSercices() {
		this.emp = new MyEmployeeServices(); 
	}
	
	@Test
	public void testisRequestExists() {
		List<MyAccount> accounts = new ArrayList<MyAccount>();
		MyAccount one = new MyAccount(1001, 1002, 600.00);
		MyAccount two = new MyAccount(1002, 1003, 700.00);
		MyAccount three = new MyAccount(1003, 1004, 900.00);
		
		accounts.add(one);
		accounts.add(two);
		accounts.add(three);
		
		int[] ans = {1001, 1002};
		
		// when transection is in the array 
		assertArrayEquals(ans, emp.isRequestExists(accounts, 1001));
		
		int[] ans1 = {0 , 0};
		// when transection is not in the array 
		
		assertArrayEquals(ans1, emp.isRequestExists(accounts, 0));
		
	}

}
