package com.offcn.mybatis.junit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.mybatis.dao.UserDao;
import com.offcn.mybatis.entity.UserEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class JunitMybatis {
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
	public void insertUser() throws SQLException {
		//创建执行对象
				SqlSession session = sqlSessionFactory.openSession();
				// 执行sql语句
				UserDao userDao=session.getMapper(UserDao.class);
				UserEntity user=new UserEntity(10,"珠珠","000000",30);
				userDao.insertUser(user);
				// 提交事务
				session.commit();
				session.close();
	}


	/** 更新
	 * @throws SQLException */

	@Test
	public void updateUser() throws SQLException {
		UserEntity user = new UserEntity(8, "紫衫龙王", "qkdny", 41);
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		// 执行sql语句
		UserDao userDao=session.getMapper(UserDao.class);
		userDao.updateUser(user);
		// 提交事务
		session.commit();
		session.close();
	}

	/**
	 * @throws SQLException */
	@Test
	public void delUser() throws SQLException {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		// 执行sql语句
		UserDao userDao=session.getMapper(UserDao.class);
		userDao.delUser(10);
		// 提交事务
		session.commit();
		session.close();
	}

	/** queryById
	 * @throws SQLException */
	@Test
	public void queryById() throws SQLException {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		UserDao userDao=session.getMapper(UserDao.class);
		// 执行sql语句
		UserEntity user =userDao.queryById(8);
		System.out.println(user);
		session.close();
	}

	/** queryAll
	 * @throws SQLException */
	@Test
	public void queryAll() throws SQLException {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		UserDao userDao=session.getMapper(UserDao.class);
		// 执行sql语句
		List<UserEntity> list = userDao.queryAll();
		for (UserEntity user : list) {
			System.out.println(user);
		}
		session.close();
	}

	/**
	 * @throws SQLException */
	@Test
	public void queryLikeOne() throws SQLException {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		UserDao userDao=session.getMapper(UserDao.class);
		// 执行sql语句
		List<UserEntity> list = userDao.queryLikeOne("师");
		for (UserEntity user : list) {
			System.out.println(user);
		}
		session.close();
	}

	/** queryMap
	 * @throws SQLException */
	@Test
	public void queryMap() throws SQLException {
		// 构造条件
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "scott");
		map.put("password", "tiger");
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		UserDao userDao=session.getMapper(UserDao.class);
		// 执行sql语句
		List<UserEntity> list = userDao.queryMap(map);
		for (UserEntity user : list) {
			System.out.println(user);
		}
		session.close();
	}
	/**
	 * 测试if
	 * @throws SQLException
	 */
	@Test
	public void queryAllIF() throws SQLException {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		UserDao userDao=session.getMapper(UserDao.class);
		// 执行sql语句
		UserEntity user = new UserEntity();
		//name
		//user.setUname("scott");
		//user.setUpass("tiger");
		//user.setUage(25);

		List<UserEntity> list = userDao.queryAllIF(user);
		for (UserEntity u: list) {
			System.out.println(u);
		}
		session.close();
	}
	/**
	 * choose
	 * @throws SQLException
	 */
	@Test
	public void queryAllChoose() throws SQLException {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		UserDao userDao=session.getMapper(UserDao.class);
		// 执行sql语句
		UserEntity user = new UserEntity();
		//name
		//user.setUname("scott");
		user.setUpass("tiger");
		//user.setUage(25);

		List<UserEntity> list = userDao.queryAllChoose(user);
		for (UserEntity u: list) {
			System.out.println(u);
		}
		session.close();
	}
	/**
	 * 测试where
	 * @throws SQLException
	 */
	@Test
	public void queryAllWhere() throws SQLException {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		UserDao userDao=session.getMapper(UserDao.class);
		// 执行sql语句
		UserEntity user = new UserEntity();
		//name
		//user.setUname("scott");
		user.setUpass("tiger");
		//user.setUage(25);

		List<UserEntity> list = userDao.queryAllWhere(user);
		for (UserEntity u: list) {
			System.out.println(u);
		}
		session.close();
	}
	/**
	 * 测试trim
	 * @throws SQLException
	 */
	@Test
	public void queryAllTrim() throws SQLException {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		UserDao userDao=session.getMapper(UserDao.class);
		// 执行sql语句
		UserEntity user = new UserEntity();
		//name
		user.setUname("scott");
		user.setUpass("tiger");
		//user.setUage(25);

		List<UserEntity> list = userDao.queryAllTrim(user);
		for (UserEntity u: list) {
			System.out.println(u);
		}
		session.close();
	}
	/**
	 * 测试set
	 * @throws SQLException
	 */
	@Test
	public void updateUserSet() throws SQLException {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		UserDao userDao=session.getMapper(UserDao.class);
		// 执行sql语句
		UserEntity user = new UserEntity();
		user.setUid(1);
		//name
		user.setUname("谢逊");
		user.setUpass("xiexun");
		//user.setUage(25);
		userDao.updateUserSet(user);
		session.commit();
		session.close();
	}
	/**
	 * 测试delete foreach
	 * @throws SQLException
	 */
	@Test
	public void delForEach() throws SQLException {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		UserDao userDao=session.getMapper(UserDao.class);
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		userDao.delForEach(list);
		session.commit();
		session.close();
	}

	/**
	 * insert foreach
	 * @throws SQLException
	 */
	@Test
	public void insertUserForEach() throws SQLException {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH);
		UserDao userDao=session.getMapper(UserDao.class);
/*		List<UserEntity> list=new ArrayList<UserEntity>();
		UserEntity user1 = new UserEntity("宋远桥1","syq",30);
		UserEntity user2 = new UserEntity("宋远桥2","syq",30);
		UserEntity user3 = new UserEntity("宋远桥3","syq",30);
		UserEntity user4 = new UserEntity("宋远桥4","syq",30);
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
	    userDao.insertUserForEach(list);
*/

		session.commit();
		session.close();
	}
	/** queryAll with page
	 * @throws SQLException */
	@Test
	public void queryAllPage() throws SQLException {
		// 创建执行对象
		SqlSession session = sqlSessionFactory.openSession();
		UserDao userDao=session.getMapper(UserDao.class);
		//指定分页信息startPage(页码, 记录数)
		PageHelper.startPage(2, 3);
		// 执行sql语句
		List<UserEntity> list = userDao.queryAll();

		//使用PageInfo工具类，获取更多分页信息
		PageInfo<UserEntity> info=new PageInfo<UserEntity>(list);//?
		System.out.println("总记录数:"+info.getTotal());
		System.out.println("总页数:"+info.getPages());
		System.out.println("每页条数:"+info.getPageSize());
		System.out.println("当前页:"+info.getPageNum());
		System.out.println("上一页:"+info.getPrePage());
		System.out.println("下一页:"+info.getNextPage());

		for (UserEntity user : info.getList()) {
			System.out.println(user);
		}
		session.close();
	}
}
