package ZDemo01_offcn0827servlet_02.service.impl;


import ZDemo01_offcn0827servlet_02.bean.User;
import ZDemo01_offcn0827servlet_02.dao.UserDao;
import ZDemo01_offcn0827servlet_02.dao.impl.UserDaoImpl;
import ZDemo01_offcn0827servlet_02.service.UserService;

public class UserServiceImpl implements UserService {

	
	UserDao dao = new UserDaoImpl ();
	
	@Override
    public User login(String username, String password) {
		
		return dao.login(username, password);
	}

}
