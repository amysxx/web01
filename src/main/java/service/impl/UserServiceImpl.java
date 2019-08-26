package service.impl;


import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

/**
 * @author amy
 * @date 2019/8/26 19:16
 */
public class UserServiceImpl implements UserService {

    UserDao userdao = new UserDaoImpl ();
    @Override
    public int register(User user) {
        return userdao.add(user);
    }
}
