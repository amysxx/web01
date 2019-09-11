package offcn_filter02.dao;


import offcn_filter02.bean.User;

public interface UserDao {
	
	public User login(String username, String password);

}
