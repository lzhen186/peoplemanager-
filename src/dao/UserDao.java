package dao;

import java.util.List;

import entity.UserBean;

public interface UserDao {
	public boolean login(String name,String pwd);//��¼
	public boolean register(UserBean user);//ע��
	public List<UserBean> getUserAll();//�����û���Ϣ����
	public boolean detele(int id);//����idɾ���û�
	public boolean update(int id,String name,String pwd,String sex,String home,String info);//�����û�
}
