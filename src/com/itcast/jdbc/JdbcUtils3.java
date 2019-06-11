package com.itcast.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils3 {

	private static DataSource ds = new ComboPooledDataSource();
	private static Connection con = null;
	
	public static DataSource getDataSource() {
		return ds;
	}
	
	public static Connection getConnection() throws SQLException{
		if (con == null) {
			return ds.getConnection();
		}
		return con;
	}
	
	public static void beginTransaction() throws SQLException{
		if (con!=null) {
			throw new SQLException("事务已开启，在结束当前事务前，不能再开启事务");
		}
		con = ds.getConnection();
		con.setAutoCommit(false);
	}
	
	public static void commitTransaction() throws SQLException{
		if (con == null) {
			throw new SQLException("当前没有事务，不能提交事务");
		}
		con.commit();
		con.close();
		con = null;
	}
	
	public static void rollbackTransaction() throws SQLException{
		if (con == null) {
			throw new SQLException("当前没有事务，不能回滚事务");
		}
		con.rollback();
		con.close();
		con = null;
	}
	
}
