package service.impl;


import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

public class UserServiceImpl implements UserService {

	UserDao dao = new UserDaoImpl ();
	public User login(String username, String password) {
		return dao.findUserByUsernameAndPassword(username, password);
	}
	@Override
	public int addUser(User user) {
		return dao.insertUser(user);
	}
	@Override
	public User getUserByUsername(String username) {
		
		return dao.findUserByUsername(username);
	}

}
