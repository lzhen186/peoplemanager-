package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.UserBean;
import util.DBconn;

public class UserDaoImpl implements UserDao {
	
	public boolean login(String name,String pwd) {//µ«¬º
		boolean flag = false;
		try {
			DBconn.init();
			String sql="select * from user where name='"+name+"' and pwd='"+pwd+"'";
			
			ResultSet res = DBconn.selectSql(sql);
			while(res.next()) {
				if(res.getString("name").equals(name)&&res.getString("pwd").equals(pwd)) {
				    flag = true;
				}
			}
			DBconn.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean register(UserBean user) {//◊¢≤·
		boolean flag = false;
		DBconn.init();
		
		String sql = "insert into user(name,pwd,sex,home,info) values ('"+user.getName()+"','"+user.getPwd()+"','"+user.getSex()+"','"+user.getHome()+"','"+user.getInfo()+"')";
		int i = DBconn.addUpDel(sql);
		
		if(i>0) {
			flag = true;
			DBconn.closeConn();
		}
		return flag;
		
	}
	
	
	public List<UserBean> getUserAll(){//≤È—Ø
		List<UserBean> list = new ArrayList<UserBean>();
		try {
			DBconn.init();
			String sql = "select * from user";
			ResultSet res = DBconn.selectSql(sql);
			
			while(res.next()) {
				UserBean user = new UserBean();
				user.setId(res.getInt("id"));
				user.setName(res.getString("name"));
				user.setPwd(res.getString("pwd"));
				user.setSex(res.getString("sex"));
				user.setHome(res.getString("home"));
				user.setInfo(res.getString("info"));
				list.add(user);
			}
			DBconn.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean detele(int id) {//…æ≥˝
		boolean flag = false;
		DBconn.init();
		String sql="delete from user where id="+id;
		int i = DBconn.addUpDel(sql);
		if(i>0) {
			flag=true;
		}
		DBconn.closeConn();
		return flag;
	}
	
	public boolean update(int id,String name,String pwd,String sex,String home,String info) {//∏¸–¬
		boolean flag = false;
		DBconn.init();
		String sql ="update user set name ='"+name
				+"' , pwd ='"+pwd
				+"' , sex ='"+sex
				+"' , home ='"+home
				+"' , info ='"+info+"' where id = "+id;
		int i =DBconn.addUpDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
