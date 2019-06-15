package com.itcast.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils5 {

	private static DataSource ds = new ComboPooledDataSource();
	private static ThreadLocal<Connection> tCon = new ThreadLocal<Connection>();
	
	public static DataSource getDataSource() {
		return ds;
	}
	
	public static Connection getConnection() throws SQLException {
		Connection con = tCon.get();
		if (con==null) {
			return ds.getConnection();
		}
		return con;
	}
	
	public static void beginTransaction() throws SQLException{
		Connection con = tCon.get();
		if (con!=null) {
			throw new SQLException("当前已有事务，不能再开启");
		}
		con = ds.getConnection();
		tCon.set(con);
		con.setAutoCommit(false);
		
	}
	
	public static void commitTransaction() throws SQLException{
		Connection con = tCon.get();
		if (con==null) {
			throw new SQLException("当前没有事务，不能提交");
		}
		con.commit();
		con.close();
		tCon.remove();
	}
	
	public static void rollbackTransaction() throws SQLException {
		Connection con = tCon.get();
		if (con==null) {
			throw new SQLException("当前没有事务，不能提交");
		}
		con.rollback();
		con.close();
		tCon.remove();
	}
	
	public static void releaseConnection(Connection connection) throws SQLException{
		Connection con = tCon.get();
		if (con == null) {
			connection.close();
		}
		if (con != connection) {
			connection.close();
		}
	}
}
