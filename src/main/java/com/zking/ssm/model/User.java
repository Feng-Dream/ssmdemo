package com.zking.ssm.model;

import java.util.Date;
import java.util.List;

public class User {
	private Integer userId;

	private String userName;

	private String userPwd;

	private Integer age;

	private String hobby;

	private String type;

	private Date birthday;

	private String address;

	private String sex;

	private List<Order> orders;

	public User() {
		super();
	}

	public User(Integer userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public User(String userName, String userPwd) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public User(String userName, String userPwd, Integer age, String hobby, String type) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.age = age;
		this.hobby = hobby;
		this.type = type;
	}

	public User(Integer userId, String userName, String userPwd, Integer age, String hobby, String type) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.age = age;
		this.hobby = hobby;
		this.type = type;
	}

	public User(Integer userId, String userName, String userPwd, Integer age, String hobby, String type, Date birthday,
			String address, String sex) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.age = age;
		this.hobby = hobby;
		this.type = type;
		this.birthday = birthday;
		this.address = address;
		this.sex = sex;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd == null ? null : userPwd.trim();
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby == null ? null : hobby.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}