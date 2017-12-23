package com.zking.ssm.dao.impl;

import com.zking.ssm.dao.UserDao;
import com.zking.ssm.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImpl2Test {

	private ApplicationContext applicationContext;
	public UserDao userDao;

	@Before
	public void setUp() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		userDao = (UserDao) applicationContext.getBean("userDao");
	}

	@Test
	public void testFindUserById() {
		User user = userDao.findUserById(3);
		System.out.println(user);
	}

	@Test
	public void testFindUserByName() {
		System.out.println(userDao.findUserByName("z"));
	}

	@Test
	public void testFindUserByName2() {
		System.out.println(userDao.findUserByName2("s"));
	}

	@Test
	public void testFindUserByNamePwd() {
		System.out.println(userDao.findUserByNamePwd(new User("zs", "123")));
	}

	@Test
	public void testFindUser() {
		System.out.println(userDao.findUser());
	}

	@Test
	public void testInsertUser() {
		User user = new User("胡九", "hj123", 15, "吃饭、打游戏", "小学生");
		userDao.insertUser(user);
		System.out.println("user_id :" + user.getUserId());
	}

	@Test
	public void testUpdateUser() {
		userDao.updateUser(new User(24, "胡九1", "hj1231", 151, "吃饭、打游戏1", "小学生1"));
	}

	@Test
	public void testDeleteUser() {
		userDao.deleteUser(24);
	}

}
