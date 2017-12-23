package com.zking.ssm.dao.impl;

import com.zking.ssm.dao.UserDao;
import com.zking.ssm.model.User;
import com.zking.ssm.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {

	@Override
	public User findUserById(Integer userId) {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		User u = sqlSession.selectOne("findUserById", userId);
		sqlSession.close();
		return u;
	}

	@Override
	public List<User> findUserByName(String userName) {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		List<User> list = sqlSession.selectList("findUserByName", "%" + userName + "%");
		sqlSession.close();
		return list;
	}

	@Override
	public List<User> findUserByName2(String userName) {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		List<User> list = sqlSession.selectList("findUserByName2", userName);
		sqlSession.close();
		return list;
	}


	@Override
	public User findUserByNamePwd(User user) {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		User u = sqlSession.selectOne("findUserByNamePwd", user);
		sqlSession.close();
		return u;
	}

	@Override
	public List<User> findUser() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		List<User> list = sqlSession.selectList("findUser");
		sqlSession.close();
		return list;
	}

	@Override
	public void insertUser(User user) {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		sqlSession.insert("insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void updateUser(User user) {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		sqlSession.update("updateUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void deleteUser(Integer userId) {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		sqlSession.delete("deleteUser", userId);
		sqlSession.commit();
		sqlSession.close();
	}

}
