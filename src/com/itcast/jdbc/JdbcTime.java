package com.itcast.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class JdbcTime {

	@Test
	public void fun3(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils1.getConnection();
			String sql = "update user set birthday = ? where id = ?";
			ps = con.prepareStatement(sql);
			Date date = new Date(0);
			ps.setDate(1, date);
			ps.setInt(2, 1);
			int a = ps.executeUpdate();
			System.out.println(a);
			System.out.println(date.getTime());
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			try {
				if(con!=null) con.close();
				if(ps!=null) ps.close();
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	@Test
	public void fun1(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils1.getConnection();
			String sql = "update user set birthday = ? where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "2015-5-5");
			ps.setInt(2, 1);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			try {
				if(con!=null) con.close();
				if(ps!=null) ps.close();
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	@Test
	public void fun2(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils1.getConnection();
			String sql = "select * from user where id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			rs = ps.executeQuery();
			rs.next();
			System.out.println(rs.getDate(3));
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			try {
				if(con!=null) con.close();
				if(ps!=null) ps.close();
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
}
