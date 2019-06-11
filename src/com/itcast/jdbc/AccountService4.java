package com.itcast.jdbc;

import java.sql.SQLException;

public class AccountService4 {

	AccountDao4 ad = new AccountDao4();
	
	public void transfer(String from, String to, double money) {
		try {
			JdbcUtils4.beginTransaction();
			ad.updateAccount(from, -money);
//			int i = 1/0;
			ad.updateAccount(to, money);
			JdbcUtils4.commitTransaction();
		} catch (Exception e) {
			try {
				JdbcUtils4.rollbackTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
}
