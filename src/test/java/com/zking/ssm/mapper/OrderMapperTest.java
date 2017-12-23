package com.zking.ssm.mapper;

import com.zking.ssm.model.Order;
import com.zking.ssm.model.User;
import com.zking.ssm.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class OrderMapperTest {

	@Test
	public void testFindOrderUser() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		OrderMapperCustom orderMapperCustom = sqlSession.getMapper(OrderMapperCustom.class);

		System.out.println(orderMapperCustom.findOrderUser());
		sqlSession.close();
	}

	@Test
	public void testFindOrderUserResultMap() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		OrderMapperCustom orderMapperCustom = sqlSession.getMapper(OrderMapperCustom.class);

		System.out.println(orderMapperCustom.findOrderUserResultMap());
		sqlSession.close();
	}

	@Test
	public void testFindOrderUserAndOrderDetailResultMap() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		OrderMapperCustom orderMapperCustom = sqlSession.getMapper(OrderMapperCustom.class);

		System.out.println(orderMapperCustom.findOrderUserAndOrderDetailResultMap());
		sqlSession.close();
	}

	@Test
	public void testFindUserAndItemResultMap() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		OrderMapperCustom orderMapperCustom = sqlSession.getMapper(OrderMapperCustom.class);
		List<User> users = orderMapperCustom.findUserAndItemResultMap();
		System.out.println(users);
		sqlSession.close();
	}

	@Test
	public void testFindOrderUserLazyLoading() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		OrderMapperCustom orderMapperCustom = sqlSession.getMapper(OrderMapperCustom.class);
		List<Order> orders = orderMapperCustom.findOrderUserLazyLoading();
		for (Order order : orders) {
			System.out.println(order.getUserId());
		}
		sqlSession.close();
	}

}
