package com.zking.ssm.dao.impl;

import com.zking.ssm.dao.UserDao;
import com.zking.ssm.model.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserDaoImpl2 extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User findUserById(Integer userId) {
		SqlSession sqlSession = getSqlSession();
		User u = sqlSession.selectOne("findUserById", userId);
		return u;
	}

	@Override
	public List<User> findUserByName(String userName) {
		SqlSession sqlSession = getSqlSession();
		List<User> list = sqlSession.selectList("findUserByName", "%" + userName + "%");
		return list;
	}

	@Override
	public List<User> findUserByName2(String userName) {
		SqlSession sqlSession = getSqlSession();
		List<User> list = sqlSession.selectList("findUserByName2", userName);
		return list;
	}

	@Override
	public User findUserByNamePwd(User user) {
		SqlSession sqlSession = getSqlSession();
		User u = sqlSession.selectOne("findUserByNamePwd", user);
		return u;
	}

	@Override
	public List<User> findUser() {
		SqlSession sqlSession = getSqlSession();
		List<User> list = sqlSession.selectList("findUser");
		return list;
	}

	@Override
	public void insertUser(User user) {
		SqlSession sqlSession = getSqlSession();
		sqlSession.insert("insertUser", user);
		sqlSession.commit();
	}

	@Override
	public void updateUser(User user) {
		SqlSession sqlSession = getSqlSession();
		sqlSession.update("updateUser", user);
		sqlSession.commit();
	}

	@Override
	public void deleteUser(Integer userId) {
		SqlSession sqlSession = getSqlSession();
		sqlSession.delete("deleteUser", userId);
		sqlSession.commit();
	}

}
