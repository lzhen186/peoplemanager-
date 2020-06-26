package entity;

public class UserBean {
	private int id;
	private String name;
	private String pwd;
	private String sex;
	private String home;
	private String info;
	public int getId() {
		return id;
	}
	public UserBean() {
		
	}
	public UserBean( String name, String pwd, String sex, String home, String info) {
		super();
		
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.home = home;
		this.info = info;
	}
	public UserBean(int id, String name, String pwd, String sex, String home, String info) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.home = home;
		this.info = info;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}
