package offcn_filter02.service.impl;


import offcn_filter02.bean.User;
import offcn_filter02.dao.UserDao;
import offcn_filter02.dao.impl.UserDaoImpl;
import offcn_filter02.service.UserService;

public class UserServiceImpl implements UserService {

	
	UserDao dao = new UserDaoImpl ();
	
	public User login(String username, String password) {
		
		return dao.login(username, password);
	}

}
