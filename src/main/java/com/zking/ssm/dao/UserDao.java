package com.zking.ssm.dao;

import com.zking.ssm.model.User;

import java.util.List;

public interface UserDao {
	public User findUserById(Integer userId);

	public List<User> findUserByName(String userName);

	public List<User> findUserByName2(String userName);

	public User findUserByNamePwd(User user);

	public List<User> findUser();

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(Integer userId);
}
