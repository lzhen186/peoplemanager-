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
			System.out.println("mysql��������ʧ��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʧ��");
			e.printStackTrace();
		} 
	}
	
	public static int addUpDel(String sql) {
		int i = 0;
		try {
			 ps = conn.prepareStatement(sql);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʧ��");
			e.printStackTrace();
		}
		return i;
	}
	
	public static ResultSet selectSql(String sql) {
		try {
			ps = conn.prepareStatement(sql);
			res= ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("���ݿ��ѯʧ��");
			e.printStackTrace();
		}
		return res;
	}
	
	public static void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("���ݿ�ر��쳣");
			e.printStackTrace();
		}
	}
	
	
}
