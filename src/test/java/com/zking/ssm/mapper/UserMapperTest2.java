package com.zking.ssm.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest2 {
	private ApplicationContext applicationContext;
	public UserMapperCustom userMapper;

	@Before
	public void setUp() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		userMapper = (UserMapperCustom) applicationContext.getBean("userMapper");
	}

	@Test
	public void testFindUserById() {
		System.out.println(userMapper.findUserById(3));
	}
}
