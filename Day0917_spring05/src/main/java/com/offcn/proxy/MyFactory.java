package com.offcn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyFactory {

	/**
	 * 工厂生产代理类，目的：将目标类（切入点）和切面类（通知） 结合。
	 * @return
	 */
	public static UserService createService() throws Throwable{
		//1 创建目标类对象
		final UserService userService = new UserServiceImpl();
		//2 创建类对象
		final Aspect myAspect = new Aspect();

		//3 使用jdk 动态代理生产代理类
		UserService proxyService =(UserService) Proxy.newProxyInstance(MyFactory.class.getClassLoader(),userService.getClass().getInterfaces(),new InvocationHandler(){
			//method:addUser()方法的反射对象 args:addUser()方法参数
			@Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				myAspect.validate();
				//通过反射方式调用方法
				Object object=method.invoke(userService,args);
				myAspect.log();
				return object;
			}

		});

		return proxyService; //返回代理类
	}



}
