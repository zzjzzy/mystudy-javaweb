package com.itcast.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/*
 * 最开始的，不使用数据库连接池。
 */

public class JdbcUtils1 {

	private static final String dbconfig = "dbconfig.properties";
	private static Properties prop = new Properties();
	static {
		try {
			InputStream in = 
					Thread.currentThread().getContextClassLoader().getResourceAsStream(dbconfig);
			prop.load(in);
			Class.forName(prop.getProperty("driverClassName"));
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("username"),
					prop.getProperty("password"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(con!=null) con.close();
			if(ps!=null) ps.close();
			if(rs!=null) rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
