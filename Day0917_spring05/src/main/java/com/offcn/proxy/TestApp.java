package com.offcn.proxy;


public class TestApp {
	public static void main(String[] args) throws Throwable {
//		UserService userService = new UserServiceImpl();
//		userService.addUser();
//		userService.updateUser();
		UserService service = MyFactory.createService();
		service.addUser();
	}
	

//	@Test
//	public void demo02(){
//		UserService userService = MyFactory.createService();
//		userService.addUser();
//		userService.updateUser();
//	}

}
