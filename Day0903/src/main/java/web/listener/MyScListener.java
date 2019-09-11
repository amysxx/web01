package web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author 15566
 */

public class MyScListener implements ServletContextListener {

	
	@Override
    public void contextDestroyed(ServletContextEvent arg0) {
		
		System.out.println("ServletContext的对象被销毁了######");

	}


	@Override
    public void contextInitialized(ServletContextEvent arg0) {
		//arg0的作用就是用来获取事件源(被监听的对象---ServletContext的对象)
		//arg0.getServletContext();
		
		System.out.println("ServletContext的对象被创建了#####");

	}

}
