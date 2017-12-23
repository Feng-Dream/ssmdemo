package com.zking.ssm.model;

/**
 * 订单(Order)的扩展类
 * 
 * @author Administrator
 *
 */
public class OrderCustom extends Order {

	private String user_name;
	private String user_pwd;
	private Integer age;
	private String type;
	private String address;
	private String sex;

	public OrderCustom() {
		super();
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "OrderCustom [user_name=" + user_name + ", user_pwd=" + user_pwd + ", age=" + age + ", type=" + type
				+ ", address=" + address + ", sex=" + sex + "]";
	}

}
