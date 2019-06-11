package com.itcast.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * 使用数据库连接池
 */
public class JdbcUtils2 {

	private static DataSource ds = new ComboPooledDataSource();
	
	public static DataSource getDataSource() {
		return ds;
	}
	
	public static Connection getConnection() {
		try {
			return ds.getConnection();
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
			// TODO: handle exception
		}
	}
	
	
}
