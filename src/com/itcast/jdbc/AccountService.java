package com.itcast.jdbc;

import org.junit.Test;

public class AccountService {

	private AccountDao accountDao = new AccountDao();
	
	public void transfer(String from, String to, double money) {
		try {
			JdbcUtils3.beginTransaction();
			accountDao.updateAccount(from, -money);
			int i = 1/0;
			accountDao.updateAccount(to, money);
			JdbcUtils3.commitTransaction();
		} catch (Exception e) {
			try {
				JdbcUtils3.rollbackTransaction();
				System.out.println(e.getMessage());
			} catch (Exception e2) {
				throw new RuntimeException(e);
			}
		}
	}
	
//	@Test
//	public void fun1() {
//		transfer("张三", "李四", 100);
//	}
	
}
