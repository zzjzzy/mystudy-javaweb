package com.itcast.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class JdbcBatch {

	@Test
	public void fun2(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils1.getConnection();
			String sql = "delete from province where name=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "海南省");
			ps.addBatch();
			ps.setString(1, "江苏省");
			ps.addBatch();
			int[] a = ps.executeBatch();
			System.out.println(a[0]);
			
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
			String sql = "insert into province(name) values(?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, "海南省");
			ps.addBatch();
			ps.setString(1, "江苏省");
			ps.addBatch();
			int[] a = ps.executeBatch();
			System.out.println(a[0]);
			
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
