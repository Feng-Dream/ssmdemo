package com.zking.ssm.mapper;

import com.zking.ssm.model.User;
import com.zking.ssm.model.UserCustom;
import com.zking.ssm.model.UserQueryOv;
import com.zking.ssm.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserMapperCustomTest {

	@Test
	public void testFindUserList() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		UserMapperCustom userMapper = sqlSession.getMapper(UserMapperCustom.class);

		UserQueryOv userQueryOv = new UserQueryOv();
		UserCustom userCustom = new UserCustom();
		userCustom.setUserName("zs");
		userCustom.setUserPwd("123");
		userQueryOv.setUserCustom(userCustom);
		List<Integer> user_ids = new ArrayList<Integer>();
		user_ids.add(2);
		user_ids.add(4);
		userQueryOv.setUser_ids(user_ids);

		System.out.println(userMapper.findUserList(userQueryOv));
		sqlSession.close();
	}

	@Test
	public void testFindUserCount() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		UserMapperCustom userMapper = sqlSession.getMapper(UserMapperCustom.class);

		UserQueryOv userQueryOv = new UserQueryOv();
		UserCustom userCustom = new UserCustom();
		userCustom.setUserName("zs");
		userCustom.setUserPwd("123");
		userQueryOv.setUserCustom(userCustom);

		System.out.println("count:" + userMapper.findUserCount(userQueryOv));
		sqlSession.close();
	}

	@Test
	public void testFindUserByIdResultMap() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		UserMapperCustom userMapper = sqlSession.getMapper(UserMapperCustom.class);
		System.out.println(userMapper.findUserByIdResultMap(25));
		sqlSession.close();
	}

	@Test
	public void testFindUserById() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		UserMapperCustom userMapper = sqlSession.getMapper(UserMapperCustom.class);
		System.out.println(userMapper.findUserById(25));
		sqlSession.close();
	}

	@Test
	public void testFindUserByName() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		UserMapperCustom userMapper = sqlSession.getMapper(UserMapperCustom.class);
		System.out.println(userMapper.findUserByName("%z%"));
		sqlSession.close();
	}

	@Test
	public void testFindUserByName2() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		UserMapperCustom userMapper = sqlSession.getMapper(UserMapperCustom.class);
		System.out.println(userMapper.findUserByName2("s"));
		sqlSession.close();
	}

	@Test
	public void testFindUserByNamePwd() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		UserMapperCustom userMapper = sqlSession.getMapper(UserMapperCustom.class);
		System.out.println(userMapper.findUserByNamePwd(new User("zs", "123")));
		sqlSession.close();
	}

	@Test
	public void testFindUser() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		UserMapperCustom userMapper = sqlSession.getMapper(UserMapperCustom.class);
		System.out.println(userMapper.findUser());
		sqlSession.close();
	}

	@Test
	public void testInsertUser() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		UserMapperCustom userMapper = sqlSession.getMapper(UserMapperCustom.class);
		User user = new User("胡九", "hj123", 15, "吃饭、打游戏", "小学生");
		userMapper.insertUser(user);
		System.out.println(user.getUserId());
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testUpdateUser() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		UserMapperCustom userMapper = sqlSession.getMapper(UserMapperCustom.class);
		userMapper.updateUser(new User(27, "胡九1", "hj1231", 151, "吃饭、打游戏1", "小学生1"));
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testDeleteUser() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		UserMapperCustom userMapper = sqlSession.getMapper(UserMapperCustom.class);
		userMapper.deleteUser(27);
		sqlSession.commit();
		sqlSession.close();
	}

	// 一级缓存测试
	@Test
	public void testCache1() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		UserMapperCustom userMapper = sqlSession.getMapper(UserMapperCustom.class);
		// 第一次发送请求，查询id为2的用户
		User user1 = userMapper.findUserById(2);
		System.out.println(user1);

		// 如果sqlSession去执行commit操作(执行插入、更新、删除)，会清空一级缓存，这样做的目的是为了让缓存中存储的是最新的信息，避免脏读

		// // 更新user1的信息
		// user1.setUser_name("测试用户9999");
		// userMapper.updateUser(user1);
		// // 执行commit操作去清空缓存
		// sqlSession.commit();

		// 第二次发送请求，查询id为2的用户
		User user2 = userMapper.findUserById(2);
		System.out.println(user2);
		sqlSession.close();
	}

	// 二级缓存测试
	@Test
	public void testCache2() {
		SqlSession sqlSession1 = SqlSessionFactoryUtil.getSqlSession();
		SqlSession sqlSession2 = SqlSessionFactoryUtil.getSqlSession();
		// SqlSession sqlSession3 = SqlSessionFactoryUtil.getSqlSession();

		UserMapperCustom userMapper1 = sqlSession1.getMapper(UserMapperCustom.class);
		// 第一次发送请求，查询id为2的用户
		User user1 = userMapper1.findUserById(2);
		System.out.println(user1);
		// 这里执行关闭操作，将sqlSession中的数据写到二级缓存区域
		sqlSession1.close();

		// 如果sqlSession去执行commit操作(执行插入、更新、删除)，会清空一级缓存和二级缓存，这样做的目的是为了让缓存中存储的是最新的信息，避免脏读

		// UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
		// User user3 = userMapper3.findUserById(2);
		// // 更新user1的信息
		// user3.setUser_name("张小明");
		// userMapper3.updateUser(user3);
		// // 执行commit操作去清空UserMapper下的二级缓存
		// sqlSession3.commit();
		// sqlSession3.close();

		UserMapperCustom userMapper2 = sqlSession2.getMapper(UserMapperCustom.class);
		// 第二次发送请求，查询id为2的用户
		User user2 = userMapper2.findUserById(2);
		System.out.println(user2);
		sqlSession2.close();
	}
}
