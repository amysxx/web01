package ajax.service.impl;


import ajax.bean.User;
import ajax.dao.UserDao;
import ajax.dao.impl.UserDaoImpl;
import ajax.service.UserService;

public class UserServiceImpl implements UserService {

	   UserDao dao = new UserDaoImpl ();
	@Override
    public User getUserByUsername(String username) {
		return dao.findUserByUsername(username);
	}
}
