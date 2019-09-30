package com.offcn.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMybatis {
	public static void main(String[] args) throws IOException {
		// 加载配置文件
		Reader reader = Resources.getResourceAsReader("mybatisConfig.xml");
		// 创建构造器对象
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// 创建工厂
		SqlSessionFactory sqlSessionFactory = builder.build(reader);
        //创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		// 执行sql语句
		session.insert("insertUser");
		// 提交事务
		session.commit();
		session.close();
	}
}
