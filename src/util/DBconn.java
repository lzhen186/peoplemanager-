package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBconn {
	private static String url="jdbc:mysql://localhost:3306/test";
	private static String name = "root";
	private static String pwd = "111111";
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet res = null;
	public static void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(url,name,pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("mysql驱动加载失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("连接数据库失败");
			e.printStackTrace();
		} 
	}
	
	public static int addUpDel(String sql) {
		int i = 0;
		try {
			 ps = conn.prepareStatement(sql);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("操作数据库失败");
			e.printStackTrace();
		}
		return i;
	}
	
	public static ResultSet selectSql(String sql) {
		try {
			ps = conn.prepareStatement(sql);
			res= ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("数据库查询失败");
			e.printStackTrace();
		}
		return res;
	}
	
	public static void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("数据库关闭异常");
			e.printStackTrace();
		}
	}
	
	
}
