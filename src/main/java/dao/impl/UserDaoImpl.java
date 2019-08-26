package dao.impl;

import bean.User;
import dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import utils.C3P0Util;

import java.sql.SQLException;


/**
 * @author amy
 * @date 2019/8/26 19:15
 */
public class UserDaoImpl implements UserDao {
    @Override
    public int add(User user)  {
        QueryRunner qr = new QueryRunner (C3P0Util.getDataSource ());
        String sql = "insert into user values (null,?,?,?,?)";
        Object[] param = {user.getUsername (),user.getPassword (),user.getSex (),user.getAge ()};
        int row = 0;
        try {
            row = qr.update (sql,param);
        } catch (SQLException e) {
            e.printStackTrace ( );
        }

        return  row;
    }
}
