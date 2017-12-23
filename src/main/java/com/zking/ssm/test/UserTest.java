package com.zking.ssm.test;

import com.zking.ssm.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class UserTest {

	@Test
	public void findUserByIdTest() {
		// 核心配置文件位置
		String resource = "/configuration.xml";

		// 将核心配置文件转成输入流
		InputStream inputStream = UserTest.class.getResourceAsStream(resource);

		// 创建会话工厂，传入核心配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过会话工厂得到会话sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {

			// 查询
			User u = sqlSession.selectOne("findUserById", 2);
			System.out.println(u);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 关闭流
			sqlSession.close();
		}
	}

	@Test
	public void findUserByNameTest() {
		// 核心配置文件位置
		String resource = "/configuration.xml";

		// 将核心配置文件转成输入流
		InputStream inputStream = UserTest.class.getResourceAsStream(resource);

		// 创建会话工厂，传入核心配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过会话工厂得到会话sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {

			// 查询
			List<User> list = sqlSession.selectList("findUserByName", "%s%");
			System.out.println(list);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 关闭流
			sqlSession.close();
		}
	}

	@Test
	public void findUserByName2Test() {
		// 核心配置文件位置
		String resource = "/configuration.xml";

		// 将核心配置文件转成输入流
		InputStream inputStream = UserTest.class.getResourceAsStream(resource);

		// 创建会话工厂，传入核心配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过会话工厂得到会话sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			// 查询
			List<User> list = sqlSession.selectList("findUserByName2", "s");
			System.out.println(list);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 关闭流
			sqlSession.close();
		}
	}

	@Test
	public void findUserByNamePwdTest() {
		// 核心配置文件位置
		String resource = "/configuration.xml";

		// 将核心配置文件转成输入流
		InputStream inputStream = UserTest.class.getResourceAsStream(resource);

		// 创建会话工厂，传入核心配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过会话工厂得到会话sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			User user = new User("zs", "123");
			// 查询
			User u = sqlSession.selectOne("findUserByNamePwd", user);
			System.out.println(u);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 关闭流
			sqlSession.close();
		}
	}

	@Test
	public void findUserTest() {
		// 核心配置文件位置
		String resource = "/configuration.xml";

		// 将核心配置文件转成输入流
		InputStream inputStream = UserTest.class.getResourceAsStream(resource);

		// 创建会话工厂，传入核心配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过会话工厂得到会话sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			// 查询
			List<User> list = sqlSession.selectList("findUser");
			System.out.println(list);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 关闭流
			sqlSession.close();
		}
	}

	@Test
	public void insertUserTest() {
		// 核心配置文件位置
		String resource = "/configuration.xml";

		// 将核心配置文件转成输入流
		InputStream inputStream = UserTest.class.getResourceAsStream(resource);

		// 创建会话工厂，传入核心配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过会话工厂得到会话sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			User user = new User("测试7", "cs7", 777, "睡觉7", "钻石会员7");
			// 查询
			int insert = sqlSession.insert("insertUser", user);

			// 提交事物
			sqlSession.commit();

			System.out.println(insert);
			System.out.println(user.getUserId());
		} catch (Exception e) {
			// 回滚事务
			sqlSession.rollback();
			throw new RuntimeException(e);
		} finally {
			// 关闭流
			sqlSession.close();
		}
	}

	@Test
	public void updateUserTest() {

		// 核心配置文件位置
		String resource = "/configuration.xml";

		// 将核心配置文件转成输入流
		InputStream inputStream = UserTest.class.getResourceAsStream(resource);

		// 创建会话工厂，传入核心配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过会话工厂得到会话sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			User user = new User(7, "测试99", "cs99", 7799, "睡觉99", "钻石会员99");
			// 查询
			int update = sqlSession.update("updateUser", user);

			// 提交事物
			sqlSession.commit();

			System.out.println(update);
		} catch (Exception e) {
			// 回滚事务
			sqlSession.rollback();
			throw new RuntimeException(e);
		} finally {
			// 关闭流
			sqlSession.close();
		}
	}

	@Test
	public void deleteUserTest() {

		// 核心配置文件位置
		String resource = "/configuration.xml";

		// 将核心配置文件转成输入流
		InputStream inputStream = UserTest.class.getResourceAsStream(resource);

		// 创建会话工厂，传入核心配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过会话工厂得到会话sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			// 删除
			int delete = sqlSession.delete("deleteUser", 14);

			// 提交事物
			sqlSession.commit();

			System.out.println(delete);

		} catch (Exception e) {
			// 回滚事务
			sqlSession.rollback();
			throw new RuntimeException(e);
		} finally {
			// 关闭流
			sqlSession.close();
		}
	}
}
