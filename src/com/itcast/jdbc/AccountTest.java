package com.itcast.jdbc;

import org.junit.Test;

public class AccountTest {

	@Test
	public void transfer4() {
		AccountService4 as = new AccountService4();
		as.transfer("张中建", "李四", 100);
	}
	
	@Test
	public void transfer() {
		AccountService as = new AccountService();
		as.transfer("张中建", "李四", 100);
	}
}
