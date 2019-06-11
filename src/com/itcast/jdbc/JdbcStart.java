package com.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class JdbcStart {
	
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/spring";
		Connection con = DriverManager.getConnection(url,"root","123456");
		return con;
	}
	
	@Test
	public void fun() {
		
	}
	
	@Test
	public void fun9() {
		fun8("东省"+"' or 'a'='a");
	}
	
//	@Test
	public void fun8(String province) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.createStatement();
			String sql = "select * from province where name = '"+province+"'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println("用户存在，登录成功--"+rs.getString(2));
			}else {
				System.out.println("用户不存在，登录失败");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
//	@Test
//	public void fun7() {
//		Connection con = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			con = getConnection();
//			stmt = con.createStatement();
//			String sql = "select * from city";
//			rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				System.out.println(rs.getInt(1)+"-"+rs.getString(2));
//			}
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		} finally {
//			try {
//				if(rs!=null) rs.close();
//				if(stmt!=null) stmt.close();
//				if(con!=null) con.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//	}
	
	
//	@Test
//	public void fun6() {
//		Connection con = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			con = getConnection();
//			stmt = con.createStatement();
//			String sql = "select * from city";
//			rs = stmt.executeQuery(sql);
//			rs.next();
//			System.out.println(rs.getString(2));
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		} finally {
//			try {
//				if(con!=null)  con.close();
//				if(stmt!=null)  stmt.close();
//				if(rs!=null) rs.close();
//			} catch (Exception e2) {
//				throw new RuntimeException(e2);
//			}
//		}
//		
//	}

//	@Test
//	public void fun1() throws Exception{
//		//插入北京市的区
//		Class.forName("com.mysql.jdbc.Driver");
//		String url = "jdbc:mysql://localhost:3306/spring";
//		Connection con = DriverManager.getConnection(url,"root","123456");
//		Statement stmt = con.createStatement();
//		String sql = "insert into city (name, pid) values('密云区', 5)";
//		stmt.executeUpdate(sql);
//		stmt.close();
//		con.close();
//		System.out.println(stmt);
//	}
//	
//	@Test
//	public void fun2() throws Exception{
//		Class.forName("com.mysql.jdbc.Driver");
//		String url = "jdbc:mysql://localhost:3306/spring";
//		Connection con = DriverManager.getConnection(url,"root","123456");
//		Statement stmt = con.createStatement();
//		String sql = "delete from city where name='海淀区'";
//		stmt.executeUpdate(sql);
//		System.out.println(con);
//		System.out.println(stmt);
//		
//	}
//	
//	@Test
//	public void fun3() throws Exception{
//		//插入湖南省的市
//		Class.forName("com.mysql.jdbc.Driver");
//		String url = "jdbc:mysql://localhost:3306/spring";
//		Connection con= DriverManager.getConnection(url,"root","123456");
//		Statement stmt = con.createStatement();
//		String sql = "insert into city (name, pid) values('常得市',3)";
//		stmt.executeUpdate(sql);
//		stmt.close();
//		con.close();
//	}
//	
//	@Test
//	public void fun4() throws Exception{
//		//修改信息
//		Class.forName("com.mysql.jdbc.Driver");
//		String url = "jdbc:mysql://localhost:3306/spring";
//		Connection con = DriverManager.getConnection(url,"root","123456");
//		Statement stmt = con.createStatement();
//		String sql = "update city set name='常德市' where name='常得市'";
//		stmt.executeUpdate(sql);
//		stmt.close();
//		con.close();
//	}
	
//	@Test
//	public void fun5() throws Exception{
//		//查询
//		Class.forName("com.mysql.jdbc.Driver");
//		String url= "jdbc:mysql://localhost:3306/spring";
//		Connection con = DriverManager.getConnection(url,"root","123456");
//		Statement stmt = con.createStatement();
//		String sql = "select * from province";
//		ResultSet rs = stmt.executeQuery(sql);
////		System.out.println(rs.next());
//		while (rs.next()) {
//			System.out.print(rs.getInt(1)+"-");
//			System.out.println(rs.getString("name"));
//		}
////		System.out.println(rs.next());
//	}
	
	
}
