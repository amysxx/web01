package offcn_filter02.dao.impl;

import offcn_filter02.bean.User;
import offcn_filter02.dao.UserDao;
import offcn_filter02.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;



public class UserDaoImpl implements UserDao {

	@Override
	public User login(String username, String password){
		
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        
        String sql = "select * from user where username=? and  password=?";
        
        User user = null;
        
        try {
			user = qr.query(sql, new BeanHandler<> (User.class),new Object[]{username,password});
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user;
	}
}
