package com.zking.ssm.dao.impl;

import com.zking.ssm.dao.UserDao;
import com.zking.ssm.model.User;
import org.junit.Test;

public class UserDaoImplTest {

	public UserDao userdao = new UserDaoImpl();

	@Test
	public void testFindUserById() {
		System.out.println(userdao.findUserById(3));
	}

	@Test
	public void testFindUserByName() {
		System.out.println(userdao.findUserByName("z"));
	}

	@Test
	public void testFindUserByName2() {
		System.out.println(userdao.findUserByName2("s"));
	}

	@Test
	public void testFindUserByNamePwd() {
		System.out.println(userdao.findUserByNamePwd(new User("zs", "123")));
	}

	@Test
	public void testFindUser() {
		System.out.println(userdao.findUser());
	}

	@Test
	public void testInsertUser() {
		User user = new User("胡九", "hj123", 15, "吃饭、打游戏", "小学生");
		userdao.insertUser(user);
		System.out.println("user_id :" + user.getUserId());
	}

	@Test
	public void testUpdateUser() {
		userdao.updateUser(new User(24, "胡九1", "hj1231", 151, "吃饭、打游戏1", "小学生1"));
	}

	@Test
	public void testDeleteUser() {
		userdao.deleteUser(24);
	}

}
