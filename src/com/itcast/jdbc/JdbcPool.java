package com.itcast.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcPool {

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
	
	@Test
	public void fun3() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils2.getConnection();
			String sql = "select * from province";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+"-"+rs.getString(2));
			}
		} catch (Exception e) {
			new RuntimeException(e);
		} finally {
			JdbcUtils2.close(con, ps, rs);
		}
		
		
	}
	
	@Test
	public void fun1() throws SQLException {
		BasicDataSource bs = new BasicDataSource();
		bs.setUrl(prop.getProperty("url"));
		bs.setDriverClassName(prop.getProperty("driverClassName"));
		bs.setUsername(prop.getProperty("username"));
		bs.setPassword(prop.getProperty("password"));
		
		Connection con = bs.getConnection();
		String sql = "update account set money = money + ? where name = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDouble(1, 100);
		ps.setString(2, "张中建");
		ps.executeUpdate();
	}
	
	@Test
	public void fun2() throws SQLException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		Connection con = ds.getConnection();
		String sql = "update account set money = money + ? where name = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDouble(1, -100);
		ps.setString(2, "张中建");
		ps.executeUpdate();
		JdbcUtils1.close(con, ps, null);
	}
}
