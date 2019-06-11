package com.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class PpStatement {

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/spring";
		Connection con = DriverManager.getConnection(url,"root","123456");
		return con;
	}
	
	@Test
	public void fun1() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
//		String city = "聊城市";
		try {
			con = getConnection();
			String sql = "select * from city where name=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "青岛市");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+"-"+rs.getString(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void fun2() {
		 Connection con = null;
		 PreparedStatement ps = null;
		 try {
			con = getConnection();
			String sql = "insert into city (name, pid) values(?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1,"青岛市");
			ps.setInt(2, 1);
			int a = ps.executeUpdate();
			System.out.println(a);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
