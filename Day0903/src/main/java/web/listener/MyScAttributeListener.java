package web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyScAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("向sc中添加了一个数据");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		
         System.out.println("删除sc中的数据");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		
          System.out.println("替换sc中的数据");
	}

}
