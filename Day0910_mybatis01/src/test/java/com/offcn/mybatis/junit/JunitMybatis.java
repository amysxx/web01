package com.offcn.mybatis.junit;

import com.offcn.mybatis.entity.UserEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JunitMybatis {
	//创建日志对象
	public static Logger loger=Logger.getLogger(JunitMybatis.class);
	public SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void init() {
		// 加载配置文件
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatisConfig.xml");
			// 创建构造器对象
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			// 创建工厂
			sqlSessionFactory = builder.build(reader);
			// 创建执行对象
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void insertUser() {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		// 执行sql语句
		session.insert("insertUser");
		// 提交事务
		session.commit();
		session.close();
	}

	/** 传递对象 */
	@Test
	public void insertUserWithParam() {
		UserEntity user = new UserEntity(8, "赵敏", "qkdny", 21);
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		// 执行sql语句
		session.insert("com.offcn.mybatis.entity.insertUserWithParam", user);
		// 提交事务
		session.commit();
		session.close();
	}

	/** 更新 */

	@Test
	public void updateUser() {
		UserEntity user = new UserEntity(8, "紫衫龙王", "qkdny", 41);
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		// 执行sql语句
		session.insert("updateUser", user);
		// 提交事务
		session.commit();
		session.close();
	}

	/***/
	@Test
	public void delUser() {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		// 执行sql语句
		session.delete("delUser", 8);
		// 提交事务
		session.commit();
		session.close();
	}

	/** queryById */
	@Test
	public void queryById() {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		// 执行sql语句
		UserEntity user = (UserEntity) session.selectOne("queryById", 5);
		System.out.println(user);
		session.close();
	}

	/** queryAll */
	@Test
	public void queryAll() {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		// 执行sql语句
		List<UserEntity> list = session.selectList("queryAll");
		for (UserEntity user : list) {
			System.out.println(user);
		}
		session.close();
	}

	/***/
	@Test
	public void queryLikeOne() {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		// 执行sql语句
        UserEntity u = new UserEntity ();
        u.setUname ("a");
		List<UserEntity> list = session.selectList("queryLikeOne", u);
		for (UserEntity user : list) {
			System.out.println(user);
		}
		session.close();
	}

	/** queryMap */
	@Test
	public void queryMap() {
		// 构造条件
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "admin");
		map.put("password", "123456");
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		// 执行sql语句
		List<UserEntity> list = session.selectList("queryMap", map);
		for (UserEntity user : list) {
			System.out.println(user);
		}
		session.close();
	}
	@Test
	public void testLog() {
		loger.debug("debug");
		loger.info("info");
		loger.warn("warn");
		loger.error("error");
		loger.fatal("fatal");
	}
}
