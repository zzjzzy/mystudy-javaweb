package com.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JdbcStart {

	@Test
	public void fun1() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/spring";
		Connection con = DriverManager.getConnection(url,"root","123456");
	}
}
