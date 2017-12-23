package com.zking.ssm.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionFactoryUtil {
	private static SqlSessionFactory sqlSessionFactory;
	public static String resource = "/mybatis/configuration.xml";

	static {
		InputStream inputStream = SqlSessionFactory.class.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
