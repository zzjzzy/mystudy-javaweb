package com.itcast.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

public class DBUtilsDemo {
	
	int a[][] = {{1,2,3},{1,2}};
//	Object[] str = {1,"aaa"};
	
	@Test
	public void fun7() throws Exception {
		QueryRunner qr = new QueryRunner(JdbcUtils2.getDataSource());
		String sql = "insert into account(name, money) values(?,?)";
		Object[] param1 = {"张三", 2000};
		Object[] param2 = {"jeck", 2000};
		Object[][] params = new Object[2][];
		params[0] = param1;
		params[1] = param2;
		qr.batch(sql,params);
	}
	
	@Test
	public void fun6() throws Exception {
		QueryRunner qr = new QueryRunner(JdbcUtils2.getDataSource());
		String sql = "delete from city where id=?";
		qr.update(sql,31);
	}
	
	@Test
	public void fun5() {
		QueryRunner qr = new QueryRunner(JdbcUtils2.getDataSource());
		String sql = "select id,name from city where pid=?";
		try {
			List<Map<String, Object>> list = qr.query(sql, new MapListHandler(), 1);
			System.out.println(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void fun4() {
		QueryRunner qr = new QueryRunner(JdbcUtils2.getDataSource());
		String sql = "delete from account where id=?";
		try {
			qr.update(sql,5);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void fun3() {
		QueryRunner qr = new QueryRunner(JdbcUtils2.getDataSource());
		String sql = "insert into account(name,money) values(?,?)";
		try {
			qr.update(sql,"张三",2000d);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void fun2() {
		QueryRunner qr = new QueryRunner(JdbcUtils2.getDataSource());
		String sql = "select * from account";
		try {
			Map<String, Object> map = qr.query(sql, new MapHandler());
			System.out.println(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void fun1() {
		QueryRunner qr = new QueryRunner(JdbcUtils2.getDataSource());
		String sql = "update account set money = ?";
		try {
			qr.update(sql,2000);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
