package com.itcast.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

/*
 * 对应用JdbcUtils4
 */
public class AccountDao4 {

	public void updateAccount(String name, double money) throws SQLException{
		Connection con = JdbcUtils4.getConnection();
		String sql = "update account set money = money+? where name = ?";
		QueryRunner qr = new QueryRunner();
		qr.update(con, sql, money, name);
	}
}
