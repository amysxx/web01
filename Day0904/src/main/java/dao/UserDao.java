package dao;


import bean.User;

public interface UserDao {

	public User findUserByUsernameAndPassword(String username, String password);

	public int insertUser(User user);
	
	public User findUserByUsername(String username);
}
