package web.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyRequestAttributeListener implements ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		
		System.out.println("向request中添加");

	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		System.out.println("从request中删除");

	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		System.out.println ("替换request中的值");

	}

}
