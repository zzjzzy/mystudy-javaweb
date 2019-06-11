package com.itcast.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

public class AccountDao {

	public void updateAccount(String name, double money) throws SQLException{
		QueryRunner qr = new QueryRunner();
		String sql = "update account set money = money + ? where name = ?";
		Connection con = JdbcUtils3.getConnection();
		qr.update(con, sql, money, name);
	}
	
//	@Test
//	public void fun1() throws SQLException {
//		updateAccount("张三", 100);
//	}
}
