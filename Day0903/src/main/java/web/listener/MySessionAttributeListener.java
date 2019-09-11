package web.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MySessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		
		System.out.println("向session中添加值");

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		
		System.out.println("删除session中的值");

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		
		System.out.println("替换session中的值");

	}

}
