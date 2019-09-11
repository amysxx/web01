package ajax.dao.impl;

import ajax.bean.User;
import ajax.dao.UserDao;
import ajax.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;



public class UserDaoImpl implements UserDao {

	@Override
	public User findUserByUsername(String username) {
		
		User user = null;
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from user where username=?";
		
		try {
	      user = qr.query(sql,new BeanHandler<>(User.class),username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
