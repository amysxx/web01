package com.offcn.mybatis.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.offcn.mybatis.entity.UserEntity;

/**
 * 用户持久层接口
 * 
 * @author Administrator
 *
 */
public interface UserDao {
	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int insertUser(UserEntity user) throws SQLException;

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int updateUser(UserEntity user) throws SQLException;

	/**
	 * 删除用户
	 * 
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	public int delUser(int uid) throws SQLException;

	/**
	 * 根据id查询用户
	 * 
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	public UserEntity queryById(int uid) throws SQLException;

	/**
	 * 查询全部用户
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<UserEntity> queryAll() throws SQLException;

	/**
	 * 模糊查询
	 * 
	 * @param uname
	 * @return
	 * @throws SQLException
	 */
	public List<UserEntity> queryLikeOne(String uname) throws SQLException;
	/**
	 * 条件查询
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	public  List<UserEntity> queryMap(Map<String,Object> map) throws SQLException;
	/**
	 * 测试if查询
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<UserEntity> queryAllIF(UserEntity user) throws SQLException; 
	/**
	 * 测试choose
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<UserEntity> queryAllChoose(UserEntity user) throws SQLException; 
	/**
	 * 测试where
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<UserEntity> queryAllWhere(UserEntity user) throws SQLException;
	/**
	 * 测试trim
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<UserEntity> queryAllTrim(UserEntity user) throws SQLException;
	/**
	 * 测试set
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public void updateUserSet(UserEntity user) throws SQLException;
	/**
	 * delete foreach
	 * @param list
	 * @return
	 * @throws SQLException
	 */
	public int delForEach(List<Integer> list) throws SQLException;
	/**
	 * insert for each
	 * @param list
	 * @return
	 * @throws SQLException
	 */
	public int insertUserForEach(List<UserEntity> list) throws SQLException;
}
