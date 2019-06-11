package com.itcast.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class JdbcTx {

	@Test
	public void fun1() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils1.getConnection();
			con.setAutoCommit(false);
			String sql = "update account set money = money + ? where name = ?";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, 100);
			ps.setString(2, "张中建");
			ps.executeUpdate();
//			int i = 1/0;
			ps.setDouble(1, -100);
			ps.setString(2, "李四");
			ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
			try {
				if(con!=null) {
					con.rollback();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			throw new RuntimeException(e);
		} finally {
			JdbcUtils1.close(con, ps, rs);
		}
	}
}
