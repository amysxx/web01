package ajax.dao;


import ajax.bean.User;

public interface UserDao {
	
	public User findUserByUsername(String username);
}
