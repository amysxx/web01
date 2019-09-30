package com.offcn.mybatis.test;

import com.offcn.mybatis.dao.UserDao;
import com.offcn.mybatis.entity.UserEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

public class TestMybatis {
	public static void main(String[] args) throws IOException, SQLException {
		// 加载配置文件
		Reader reader = Resources.getResourceAsReader("mybatisConfig.xml");
		// 创建构造器对象
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// 创建工厂
		SqlSessionFactory sqlSessionFactory = builder.build(reader);
        //创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		// 执行sql语句
		UserDao userDao=session.getMapper(UserDao.class);
		UserEntity user=new UserEntity(8,"灭绝师太","000000",50);
		userDao.insertUser(user);
		// 提交事务
		session.commit();
		session.close();
	}
}
